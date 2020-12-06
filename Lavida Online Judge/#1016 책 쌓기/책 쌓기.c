#include <stdio.h>

int main() {
	int test, i, cnt;
	double n, sum, k;

	scanf("%d", &test);

	while (test--) {
		scanf("%lf", &n);

		for (cnt =0, k = 0, sum = 0, i = 2; sum < n; i++, cnt++) {
			k = 1.0 / (double)i;
			sum += k;
		}
		printf("%d\n", cnt);
	}
	return 0;
}