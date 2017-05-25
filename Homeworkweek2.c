#include <stdio.h>

int main()
{
    
    int a, b, c;
    int *pa, *pb, *pc;
    a = 12;
    b = 9;
    pa = &a;
    pb = pa;
    pc = pa;
    printf("%d %d %d\n", *pa, *pb, *pc);    
    pa = &b;
    printf("%d %d %d\n", *pa, *pb, *pc);
    printf("%p %p %p\n", pa, pb, pc);
    printf("%p %d %d\n",(void*)&a, a, sizeof(a));
 
    
  

//    return 0;
}

