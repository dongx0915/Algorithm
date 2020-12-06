#include <stdio.h>

int main() {
	int test, n, i, j, k;

	scanf("%d", &test);

		for (k = 1; k <= test; k++) {
			scanf("%d", &n);
			printf("Case #%d:\n", k);

			for (i = 1; i <= n; i++) {
				for (j = 0; j < i; j++)
					printf("*");
				printf("\n");
			}

			for (i = 0; i < n - 1; i++) {
				for (j = n - 1; j > i; j--)
					printf("*");
				printf("\n");
			}
			printf("\n");
	}

	return 0;
}