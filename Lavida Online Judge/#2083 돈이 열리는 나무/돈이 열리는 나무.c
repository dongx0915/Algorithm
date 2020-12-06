#include <stdio.h>

int main() {
	int test, n, i, j, k, s;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		for (i = 1; i <= n; i++) {
			for (j = n; j > i; j--) {
				printf(" ");
			}
			for (k= n, j = 0; j < i; j++, k--) {
				printf("%d", k);
				if (j == i - 1) {
					for (s = 0 ; s < i - 1; s++, k++)
						printf("%d", k + 1);
				}
			}
			printf("\n");
		}

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				printf(" ");
			}
			for (j = n; j > i; j--) {
				printf("%d", j);
				if (j == i + 1) {
					for (s = j + 1, k = n - 1; k > i; k--, s++) {
						printf("%d", s);
					}
				}
			}
			printf("\n");
		}
	}
	return 0;
}