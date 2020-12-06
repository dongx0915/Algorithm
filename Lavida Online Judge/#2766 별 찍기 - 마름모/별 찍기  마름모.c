#include <stdio.h>

int main() {
	int n, i, j, k;

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		for (j = n - 1; j > i; j--) {
			printf(" ");
		}
		for (j = 0; j <= i; j++) {
			printf("*");
			if (j == i - 1) {
				for (k = 0; k < i; k++)
					printf("*");
			}
		}
		printf("\n");
	}
	for (i = 0; i < n - 1; i++) {
		for (j = 0; j <= i; j++)
			printf(" ");
		for (j = n - 1; j > i; j--) {
			printf("*");
			if (j == i + 1) {
				for (k = n- 2; k > i; k--)
					printf("*");
			}
		}
		printf("\n");
	}
	return 0;
}