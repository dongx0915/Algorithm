#include <stdio.h>
#pragma warning(disable:4996)

int main() {
	int n, k, i, j;
	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		for (j = 0; j < i; j++) {
			printf(" ");
			k = j;
		}
		for (j = n; j > i; j--) {
			printf("@");
			if (j == i + 1) {
				for (k = n - 1; k >= j; k--) {
					printf("@");
				}
			}
		}
		printf("\n");
	}
	for (i = 0; i < n - 1; i++) {
		for (j = n - 2; j > i; j--) {
			printf(" ");
		}
		for (j = 0; j <= i + 1; j++) {
			printf("@");
			if (j >= i + 1) {
				for (k = 0; k < j; k++) {
					printf("@");
				}
			}
		}
		printf("\n");
	}
	return 0;
}