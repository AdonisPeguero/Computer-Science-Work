#include <stdio.h>

int main(int argc, char * argv[])
{
    
    
    int var1, var2;
    // (1) error checking for the number of arguments
    if(argc !=3){
        printf("usage: add num1 num2! n");
        return 1;
    }
    // (2) check the arguments
    var1= atoi(argv[1]);
    if ( var1 == 0 && strcmp("0", argv[1])<>0)
    var2= atoi(argv[2]);
    int sum = var1+var2;
    printf("The sum of %d and %d is %d /n", var1, var2, sum);
    
    
    
    //printf("Hello, World!\n");

    return 0;
}

