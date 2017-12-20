#include <stdio.h>
#include <omp.h>
#include <stdlib.h>
#include <time.h>

// 
// The monte carlo pi program
//

static long num_trials = 10000;

int main (int argc, char* argv[])
{
   long i;  long Ncirc = 0;
   double pi, x, y, test;
   double r = 1.0;   // radius of circle. Side of squrare is 2*r 

   srand ( time ( NULL));
   	
   
   // Get number of threads from command line
	  int thread_count = strtol(argv[1], NULL, 10);



#pragma omp parallel for private(x,y,test) reduction(+:Ncirc)
   
	  for (i = 0; i <= thread_count; i++)
	  {

		  for (i = 0; i < num_trials; i++)
		  {
			  //float in range -1 to 1
			  x = (double)rand() / RAND_MAX*2.0 - 1.0;
			  y = (double)rand() / RAND_MAX*2.0 - 1.0;

			  test = x*x + y*y;

			  if (test <= r*r) Ncirc++;
		  }

		  pi = 4.0 * ((double)Ncirc / (double)num_trials);

		  printf("\n %ld trials, pi is %f \n", num_trials, pi);
	  }
    return 0;
}
