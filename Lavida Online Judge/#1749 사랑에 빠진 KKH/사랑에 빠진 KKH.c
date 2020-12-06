#include <stdio.h>
#include <math.h>
#pragma warning(disable:4996)

int main() {
	int test, y, n, i;
	double sum = 0, x;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		for (sum = 1, i = 0; i < n; i++) {
			scanf("%lf %d", &x, &y);
			sum *= pow(x, y);
		}

		printf("%.2lf\n", sum);
	}
	return 0;
}