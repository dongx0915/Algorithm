#include <stdio.h>
#include <math.h>

int IsPrime(int n) {
	int i, limit;

	if (n <= 1) return 0;
	if (n == 2) return 1;
	if (n % 2 == 0) return 0;

	limit = (int)sqrt((double)n);

	for (i = 3; i <= limit; i += 2) {
		if (n % i == 0) {
			return 0;
		}
	}
	return 1;
}

int main() {
	int test, n, i, res[100], j, cnt = 0, k;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		for (j = 0, i = 2; i <= n; i++) {
			if (IsPrime(i) == 1) {
				while (1) {
					if (n % i == 0) {
						n = n / i;
						res[j] = i;
						j++, cnt++;
					}
					else
						break;
				}
			}
		}

		for (k = 0; k < j; k++) {
			printf("%d", res[k]);
			if (k != j - 1)
				printf(" ");
			if (k == j - 1)
				printf("\n");
		}
	}
	return 0;
}