#include <stdio.h>
int main()
{
int A;
int B;
int *pa, *pb, *pc;
A = 12;
B = 9;
pa = &A;
pb = pa;
pc = pa;
printf("%d %d %d\n", *pa, *pb, *pc);
pa = &B;
printf("%d %d %d\n", *pa, *pb, *pc);
return 0;
}
