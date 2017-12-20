#include <stdio.h>
#include <stdlib.h>
#include <gd.h>
#include <gdfontl.h>
#include <math.h>

void drawImage(double * buffer,int n,const char * fname); 

double XMIN=-2.0;
double XMAX=2.0;
double YMIN=-2.0;
double YMAX=2.0;
int COUNT_MAX=1000;

__global__ void pixelValue(int n, double XMIN, double XMAX, double YMIN, double YMAX, int COUNT_MAX, double * img_buffer) {
    double cx, cy;
    double tx, ty;
    double zx, zy;
    double img_val;
    int count;
    double BOUNDARY=5.0;
    int ij,i,j;

    //   ADD COMMAND HERE TO SET VALUE OF IJ, GLOBAL THREAD INDEX
    ij = threadIdx.x + blockIdx.x*blockDim.x;

    while(ij<n*n) {
        i = ij/n;
        j = ij%n;
    
        cx = XMIN + (double)i/(double)n*(XMAX-XMIN);
        cy = YMAX - (double)j/(double)n*(YMAX-YMIN);
        zx = 0.0;
        zy = 0.0;
    
        count=0;
        img_val=0.0;
        while(count<COUNT_MAX) {
            count++;
            tx = zx*zx-zy*zy+cx;
            ty = 2*zx*zy+cy;
            zx = tx;    
            zy = ty;
            if((zx*zx+zy*zy)>BOUNDARY) {
                img_val= log((double)count);
                break;
            }
        }
        img_buffer[ij]=img_val;

        // ADD COMMAND HERE TO INCREMENT IJ, BY THE GLOBAL SIZE
		ij += blockDim.x*gridDim.x;
    }
}

int main(int argc, char ** argv) {
    int i,j,ij,n;
    double * img_buffer;
    // DEFINE dev_img_buffer
	double * dev_img_buffer;
    cudaEvent_t start,stop;
    float time_elapsed=0;

    cudaEventCreate(&start);
    cudaEventCreate(&stop);

    n=100;
    i=1;
    if(argc>i) sscanf(argv[i++],"%d",&n);
    if(argc>i) sscanf(argv[i++],"%lf",&XMIN);
    if(argc>i) sscanf(argv[i++],"%lf",&XMAX);
    if(argc>i) sscanf(argv[i++],"%lf",&YMIN);
    if(argc>i) sscanf(argv[i++],"%lf",&YMAX);
    if(argc>i) sscanf(argv[i++],"%d",&COUNT_MAX);


    printf("Mandelbrot Example\n");
    printf("N = %d\n",n);
    printf("X = %lf -> %lf, Y = %lf -> %lf\n",XMIN,XMAX,YMIN,YMAX);
    printf("DEPTH = %d\n",COUNT_MAX);

    img_buffer = (double *)malloc(sizeof(double)*n*n);
    // ALLOCATE dev_img_buffer
	cudaMalloc((void **)&dev_img_buffer,sizeof(double)*n*n);

    cudaEventRecord(start);
    // CALL pixelValue with 39 blocks and 64 threads per block 
	pixelValue<<<39,64>>>(n, XMIN, XMAX, YMIN, YMAX, COUNT_MAX,dev_img_buffer);
    // COPY dev_img_buffer to img_buffer
	cudaMemcpy(img_buffer,dev_img_buffer,sizeof(double)*n*n,cudaMemcpyDeviceToHost);
    cudaEventRecord(stop);
    cudaEventSynchronize(stop);
    cudaEventElapsedTime(&time_elapsed,start,stop);

    printf("ELAPSED TIME IN CALCULATION LOOP = %lf ms\n",time_elapsed);

    printf("Drawing image\n");
    drawImage(img_buffer,n,"file.png");

    free(img_buffer);
    // FREE dev_img_buffer
	cudaFree((void*)dev_img_buffer);
    return 0;

}

gdImagePtr im;
FILE *pngout;
int black;
int white;
#define NCOLORS 200
int cmap[NCOLORS];

void drawImage(double * buffer,int n,const char * fname) {
    int i,j,scale;
    double max,min,ncolors;
    im = gdImageCreate(n,n);
    black = gdImageColorResolve(im, 0, 0, 0);
    white = gdImageColorResolve(im, 255, 255, 255);
    ncolors = (double)NCOLORS;
    for (i=0;i<NCOLORS;i++) {
        cmap[i] = gdImageColorResolve(im,
            (int)((ncolors-i)/ncolors*255.0),
            (int)((ncolors/2.0-abs(ncolors/2.0-i))/(ncolors/2.0)*255.0),
            (int)((i)/ncolors*255.0)
        );
    }
    cmap[0] = black;

    gdImageFilledRectangle(im,0,0,n,n,white);
    max=buffer[0];
    min=buffer[0];
    for(i=0;i<n*n;i++) {
        if(buffer[i]>max) max=buffer[i];
        if(buffer[i]<min) min=buffer[i];
    }
    if(max==min) { max += 0.5; min -= 0.5; }
    for(i=0;i<n;i++) {
        for(j=0;j<n;j++) {
            scale = (int)((buffer[i*n+j]-min)/(max-min)*ncolors);
            if(scale<0) scale=0;
            if(scale>99) scale=99;
            gdImageSetPixel(im,i,j,cmap[scale]);
        }
    }
    gdImageRectangle(im,0,0,n-1,n-1,black);
    pngout = fopen(fname, "wb");
    gdImagePng(im, pngout);
    fclose(pngout);

    //cleanup
    gdImageDestroy(im);
}


