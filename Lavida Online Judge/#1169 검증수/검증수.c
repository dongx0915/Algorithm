#include <stdio.h>

int main()
{
	int a;
	int b;
	int c;
	int d;
	int e;
	int sum;

	scanf("%d %d %d %d %d", &a, &b, &c, &d, &e);

	sum = (a*a + b*b + c*c + d*d + e*e) % 10;

	printf("%d", sum);
	return 0;
}