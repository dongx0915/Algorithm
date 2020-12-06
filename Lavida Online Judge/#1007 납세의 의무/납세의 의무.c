#include <stdio.h>

int main() {
	int t, n;
	double pr;

	scanf("%d", &t);
	scanf("%d", &n);

	pr = (double)n * 100 / (100 + t);

	printf("%.2f\n", pr);
	return 0;
}