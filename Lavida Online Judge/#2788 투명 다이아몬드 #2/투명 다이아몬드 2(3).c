#include <stdio.h>

int main() {
	int test, n, i, j, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		if (n % 2 == 0)
			n++;
		for (i = 0; i < (n / 2) + 1; i++) {
			for (j = (n / 2); j > i; j--)
				printf(" ");
			for (j = 0; j <= i; j++) {
				if (j == 0)
					printf("$");
				else
					printf(" ");
				if (j == i) {
					for (k = 0; k < i; k++) {
						if (k == i - 1)
							printf("$");
						else
							printf(" ");
					}
				}
			}
			printf("\n");
		}

		for (i = 0; i < (n / 2); i++) {
			for (j = 0; j <= i; j++)
				printf(" ");
			for (j = (n / 2); j > i; j--) {
				if (j == (n / 2))
					printf("$");
				else
					printf(" ");
				if (j == i + 1) {
					for (k = (n / 2) - 1; k > i; k--) {
						if (k == i + 1)
							printf("$");
						else
							printf(" ");
					}
				}
			}
			printf("\n");
		}
	}
	return 0;
}