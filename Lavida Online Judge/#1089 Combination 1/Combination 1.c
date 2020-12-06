#include <stdio.h>

int main() {
	int test, n, k, fac_n, fac_k, fac_nk;
	int i, j, r, com;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &n, &k);
		for (i = 1, fac_n = 1; i <= n; i++) {
			fac_n *= i;
		}
		for (j = 1, fac_k = 1; j <= k; j++) {
			fac_k *= j;
		}
		for (r = 1, fac_nk = 1; r <= (n - k); r++) {
			fac_nk *= r;
		}
		com = fac_n / (double)(fac_k * fac_nk);
		printf("%d\n", com);
	}
	return 0;
}