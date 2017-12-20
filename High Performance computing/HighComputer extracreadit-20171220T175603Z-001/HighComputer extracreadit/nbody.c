#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#ifdef USE_MPI
#include <mpi.h>
#endif 



void calc_accelerations(int n, double * ax, double * ay, double * az,
    double *x, double *y, double *z, double mG) {
    int i,j;
    double k;
    double dx,dy,dz,dr,dr2,dr3i;
    int size=1;
    int rank=0;
#ifdef USE_MPI
    double * buffer;
    MPI_Comm_size(MPI_COMM_WORLD,&size);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    buffer = (double *)malloc(sizeof(double)*n);
#endif
    // calculate accelerations
    for(i=0;i<n;i++) {
        ax[i] = 0.0;
        ay[i] = 0.0;
        az[i] = 0.0;
    }
    for(i=rank;i<n;i+=size) {//MPI round robin schedule
        for(j=i+1;j<n;j++) {
            dx = x[j]-x[i];
            dy = y[j]-y[i];
            dz = z[j]-z[i];
            dr2 = dx*dx+dy*dy+dz*dz;
            dr=sqrt(dr2);
            dr3i=1.0/(dr2*dr);
            k=mG*dr3i;
            ax[i]+=dx*k;
            ay[i]+=dy*k;
            az[i]+=dz*k;
            ax[j]-=dx*k;
            ay[j]-=dy*k;
            az[j]-=dz*k;
        }
    }
#ifdef USE_MPI
    MPI_Allreduce(ax,buffer,n,MPI_DOUBLE, MPI_SUM,MPI_COMM_WORLD);
    for(i=0;i<n;i++) ax[i]=buffer[i];
    MPI_Allreduce(ay,buffer,n,MPI_DOUBLE, MPI_SUM,MPI_COMM_WORLD);
    for(i=0;i<n;i++) ay[i]=buffer[i];
    MPI_Allreduce(az,buffer,n,MPI_DOUBLE, MPI_SUM,MPI_COMM_WORLD);
    for(i=0;i<n;i++) az[i]=buffer[i];

    free(buffer);
#endif
}
void leapfrog(int n,
            double * x,double *y,double *z,
            double *vx,double *vy,double *vz,
            double *ax,double *ay,double *az, double time_step) {
    int i;
    // leapfrog forward, update velocities then positions
    for(i=0;i<n;i++) {
        vx[i] += ax[i]*time_step;
        vy[i] += ay[i]*time_step;
        vz[i] += az[i]*time_step;
    }
    for(i=0;i<n;i++) {
        x[i] += vx[i]*time_step;
        y[i] += vy[i]*time_step;
        z[i] += vz[i]*time_step;
    }
}

int main(int argc, char ** argv) {
    int n=1000;
    double * x, *y, *z;
    double * vx, *vy, *vz;
    double * ax, *ay, *az;
    double time=0.0;
    double time_final = 1;
    double time_step = 0.01;
    int i;
    double mG=0.001;
    int rank, size;

#ifdef USE_MPI
	double start_time;
	double stop_time;
#endif

#ifdef USE_MPI
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &size);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);

#endif

    // allocate memory
    x = (double *)malloc(sizeof(double)*n);
    y = (double *)malloc(sizeof(double)*n);
    z = (double *)malloc(sizeof(double)*n);
    vx = (double *)malloc(sizeof(double)*n);
    vy = (double *)malloc(sizeof(double)*n);
    vz = (double *)malloc(sizeof(double)*n);
    ax = (double *)malloc(sizeof(double)*n);
    ay = (double *)malloc(sizeof(double)*n);
    az = (double *)malloc(sizeof(double)*n);    
    // initialize memory
    for(i=0;i<n;i++) {
        x[i] = (double)rand()/(double)RAND_MAX;
        y[i] = (double)rand()/(double)RAND_MAX;
        z[i] = (double)rand()/(double)RAND_MAX;
        vx[i] = 0.0;
        vy[i] = 0.0;
        vz[i] = 0.0;
    }
#ifdef USE_MPI
	MPI_Bcast(x, n, MPI_DOUBLE, 0 , MPI_COMM_WORLD);
	MPI_Bcast(y, n, MPI_DOUBLE, 0 , MPI_COMM_WORLD);
	MPI_Bcast(z, n, MPI_DOUBLE, 0 , MPI_COMM_WORLD);
#endif


#ifdef USE_MPI
	start_time = MPI_Wtime();
#endif
    //time loop
    while(time<time_final) {
        calc_accelerations(n,ax,ay,az,x,y,z,mG);
        leapfrog(n,x,y,z,vx,vy,vz,
            ax,ay,az,time_step);
        // update time
        time += time_step;
    }


#ifdef USE_MPI
	stop_time = MPI_Wtime();
        if(rank==0) {
            printf("USING %d PROCESSES\n",size);
            printf("ELAPSED TIME IN MAIN LOOP = %lf\n", stop_time - start_time);
        }
#endif

    // free memory
    free(x);
    free(y);
    free(z);
    free(vx);
    free(vy);
    free(vz);
    free(ax);
    free(ay);
    free(az);

#ifdef USE_MPI
	MPI_Finalize();
#endif
    return 0;

}
