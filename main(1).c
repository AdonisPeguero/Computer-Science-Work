#include <stdio.h>
#include <ctype.h>

int main(int argc, char *argv[]){
  if (argc != 4){
    printf("usege: num1 num2 num3!\n");
    return 0;
  }
  if (isalpha(*argv[1])){
    printf("max: invalid input %s\n", argv[1]);
    return 0;
  }
  if (isalpha(*argv[2])){
    printf("max: invalid input %s\n", argv[2]);
    return 0;
  }
  if (isalpha(*argv[3])){
    printf("max: invalid input %s\n", argv[2]);
    return 0;
  }
  char MaxInput = *argv[1];
  

  if (MaxInput < *argv[2]){ 
      
      MaxInput = *argv[2];
    }
    

  if (MaxInput < *argv[3]){ 
      
      MaxInput = *argv[3];
      
  }
  
  printf("The maximum value is %c\n", MaxInput);
}

