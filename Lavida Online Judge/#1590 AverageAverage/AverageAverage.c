#include <stdio.h>

int main() {
	int test, n, k[100], i;
	double sum, avg;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++)
			scanf("%d", &k[i]);
		for (sum = 0, i = 0; i < n; i++) {
			sum += k[i];
		}
		avg = sum / (double)n;
		printf("%.1lf\n", avg);
	}
	return 0;
}