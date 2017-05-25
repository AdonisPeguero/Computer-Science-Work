#include <stdio.h>
int main()
{
    int a;
    int * ptr_a;
    a= 10;
    ptr_a = &a;
    printf("a=%d\n", a);
    printf("ptr_a=%p\n", ptr_a);
    return 0;
}