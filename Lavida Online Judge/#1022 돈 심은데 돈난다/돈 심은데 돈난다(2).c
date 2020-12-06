#include <stdio.h>

int main() {
	int test, i, j, n, k;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		for (i = 1; i <= n; i++) {
			for (j = n; j > i; j--) {
				printf(" ");
			}
			for (j = 0; j < i; j++) {
				printf("%d", j + 1);
				if (j == i - 1) {
					for (k = j; k > 0; k--)
						printf("%d", k);
				}
			}
			printf("\n");
		}

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++){
				printf(" ");
			}
			for (k = 1, j = n; j > i; j--, k++) {
				printf("%d", k);
				if (j == i + 1) {
					for (; k > 1; k--) {
						printf("%d", k - 1);
					}
				}
			}
			printf("\n");
		}
	}
	return 0;
}