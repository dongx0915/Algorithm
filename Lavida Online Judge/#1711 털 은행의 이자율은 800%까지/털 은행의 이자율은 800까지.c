#include <stdio.h>

int main() {
	int a, b;
	double res = 0;
	scanf("%d %d", &a, &b);

	res = (double)a + (a * (double)b / (double)100);
	
	printf("%.1lf\n", res);
	return 0;
}