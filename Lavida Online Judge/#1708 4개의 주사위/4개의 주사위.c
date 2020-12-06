#include <stdio.h>

int main() {
	int a, b, c, d;
	double sum = 0;

	scanf("%d %d %d %d", &a, &b, &c, &d);

	sum = ((a - b) * c) / (double)d;

	printf("%.2lf\n", sum);
	return 0;
}