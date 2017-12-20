#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>


int main(int argc, char ** argv) {
    int n = 10000000;
    double *x = (double *)malloc(sizeof(double)*n);
    double *y = (double *)malloc(sizeof(double)*n);
    double *z = (double *)malloc(sizeof(double)*n);
    double *z2 = (double *)malloc(sizeof(double)*n);
    double min=0.0;
    double max = 10.0;
    double step = (min-max)/(double)(n-1);
    int i,iter;
    int itmax = 100;
    clock_t start, stop;
    double elapsed_time;
    double pi = acos(-1.0);
    double temp = (max-min)+(max-min)*pi;
  
    start = clock();
    for(i=0;i<(n-4);i+=5) {
       x[i] = min+(double)i*step;
       x[i+1] = min+(double)i*step;
       x[i+2] = min+(double)i*step;
       x[i+3] = min+(double)i*step;
       x[i+4] = min+(double)i*step;
       
       y[i] = exp(-(x[i]-5.0*x[i]-5.0));
       y[i+1] = exp(-(x[i+1]-5.0*x[i+1]-5.0));
       y[i+2] = exp(-(x[i+2]-5.0*x[i+2]-5.0));
       y[i+3] = exp(-(x[i+3]-5.0*x[i+3]-5.0));
       y[i+4] = exp(-(x[i+4]-5.0*x[i+4]-5.0)); 
       
       z[i] = y[i]*sin((x[i]-min)/temp);
       z[i+1] = y[i+1]*sin((x[i+1]-min)/temp);
       z[i+2] = y[i+2]*sin((x[i+2]-min)/temp);
       z[i+3] = y[i+3]*sin((x[i+3]-min)/temp);
       z[i+4] = y[i+4]*sin((x[i+4]-min)/temp);
       
       z[i] = z2[i]*y[i];
       z[i+1] = z2[i+1]*y[i+1];
       z[i+2] = z2[i+2]*y[i+2];
       z[i+3] = z2[i+3]*y[i+3];
       z[i+4] = z2[i+4]*y[i+4];
    }
/*We can use loop unrolling here to can things a little faster.
finally all some of this loops can be put together into one big loop */


  /*  for(i=0;i<(n-4);i+=5) {                           
       y[i] = exp(-(x[i]-5.0*x[i]-5.0));
       y[i+1] = exp(-(x[i+1]-5.0*x[i+1]-5.0));
       y[i+2] = exp(-(x[i+2]-5.0*x[i+2]-5.0));
       y[i+3] = exp(-(x[i+3]-5.0*x[i+3]-5.0));
       y[i+4] = exp(-(x[i+4]-5.0*x[i+4]-5.0));
    } */
/*for(i=0;i<n;i++) {
    y[i] = exp(-(pow(x[i]-5.0,2.0)));
}             
    raising X to a power is expensive 
    taking perhaps hundreds of machine cycles
    and since it is to the power of 2 
    it is better to multiple x by it self.
    loop unrolling will also be helpful*/



 /*for(i=0;i<(n-4);i+=5) {
       z[i] = y[i]*sin((x[i]-min)/temp);
       z[i+1] = y[i+1]*sin((x[i+1]-min)/temp);
       z[i+2] = y[i+2]*sin((x[i+2]-min)/temp);
       z[i+3] = y[i+3]*sin((x[i+3]-min)/temp);
       z[i+4] = y[i+4]*sin((x[i+4]-min)/temp);
    } */
    /*
    for(i=0;i<n;i++) {
       double pi = acos(-1.0);
       z[i] = y[i]*sin((x[i]-min)/(max-min)*2.0*pi);
    }
   (max-min)*2.0*pi takes too long, it is faster to add (max-min) by it self. But 
wait there's more, since (max-min) are used many times 
   it is better to have a separate variable that stores this operation
   temp = (max-min)+(max-min). double pi can be move outside.
   more loop unrolling*/
   
   

  
        z2[0] = 0.5*(z[0]+z[1]);
        z2[n-1] = 0.5*(z[n-1]+z[n-2]);
        for(i=1;i<n-5;i+=5) {
            z2[i] = (1.0/3.0)*(z[i-1]+z[i]+z[i+1]);
            z2[i+1] = (1.0/3.0)*(z[i-2]+z[i]+z[i+2]);
            z2[i+2] = (1.0/3.0)*(z[i-3]+z[i]+z[i+3]);
            z2[i+3] = (1.0/3.0)*(z[i-4]+z[i]+z[i+4]);
            z2[i+4] = (1.0/3.0)*(z[i-5]+z[i]+z[i+5]);
        }
       /* for(i=0;i<(n-4);i+=5) {
            z[i] = z2[i]*y[i];
            z[i+1] = z2[i+1]*y[i+1];
            z[i+2] = z2[i+2]*y[i+2];
            z[i+3] = z2[i+3]*y[i+3];
            z[i+4] = z2[i+4]*y[i+4];
        } */
    /* The first for loop can be remove since iter is not use for going through the 
loop. This made the code run alot more faster. 
    And yes more loop unrolling*/
    
    
    stop = clock();
    elapsed_time = (stop-start)/(double)CLOCKS_PER_SEC;

    printf("ELAPSED TIME = %f\n",elapsed_time);

    free(x);
    free(y);
    free(z);
    free(z2);
}
