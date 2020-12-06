#include <stdio.h>
#include <math.h>

int main() {
	int test, a[1000], n, i, xl, k;
	double sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d",&xl, &n);
		for (i = 0; i < n; i++) {
			scanf("%d", &a[i]);
		}
		for (i = 0, sum = 0, k = n - 1; i < n; i++,k--) {
			sum += a[i] * pow((double)xl , (double)k);
		}
		printf("%.0f\n", sum);
	}
	return 0;
}