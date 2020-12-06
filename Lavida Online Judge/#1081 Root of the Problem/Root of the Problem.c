#include <stdio.h>
#include <math.h>

int main() {
	int b, n, i, test;
	double res = 0, res_i1 = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &b, &n);
		for (i = 1; pow(i, n) < b; i++)
		{
		}
		res = (double)b - pow(i - 1, n);
		res_i1 = pow(i, n) - (double)b;

		if (res < res_i1 || res == 0)
			printf("%d\n", i - 1);
		else 
			printf("%d\n", i);
	}

	return 0;
}