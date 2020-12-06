#include <stdio.h>

int main() {
	int test, n, i, j, k, s;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 1; i <= n; i++) {
			for (j = n; j > i; j--)
				printf(" ");
			for (s = 1, j = 0; j < i; j++,s++) {
				printf("%d", s);
				if (j == i - 1) {
					for (k = 1; k < i; k++, s--)
						printf("%d", s - 1);
				}
			}
			printf("\n");
		}

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++)
				printf(" ");
			for (s = 1, j = n; j > i; j--, s++) {
				printf("%d", s);
				if (j == i + 1) {
					for (k = n - 1; k > i; k--, s--)
						printf("%d", s - 1);
				}
			}
			printf("\n");
		}
	}
	return 0;
}