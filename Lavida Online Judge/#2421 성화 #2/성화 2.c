#include <stdio.h>

int main() {
	int n, i, j, k, test;

	scanf("%d", &test);
	while (test--) {

		scanf("%d", &n);
		if (n % 2 == 0)
			n -= 1;

		for (i = 1; i <= (n / 2) + 1; i++) {
			for (j = (n / 2) + 1; j > i; j--) {
				printf(" ");
			}
			for (j = 0; j < i; j++) {
				if (j == 0)
					printf("*");
				else
					printf(" ");
				if (j == i - 1) {
					for (k = 1; k < i; k++)
						if (k == i - 1)
							printf("*");
						else
							printf(" ");
				}
			}
			printf("\n");
		}

		for (i = 1; i <= (n / 2); i++) {
			for (j = 0; j < i; j++) {
				printf(" ");
			}
			for (j = (n / 2); j >= i; j--) {
				if (j == (n / 2))
					printf("*");
				else
					printf(" ");
				if (j == i) {
					for (k = (n / 2); k > i; k--)
						if (k == i + 1)
							printf("*");
						else
							printf(" ");
				}
			}
			printf("\n");
		}

		for (i = 0; i < n; i++) {
			if (i == 0 || i == n - 1) {
				for (j = 0; j < n; j++) {
					printf("*");
				}
			}
			else {
				for (j = 0; j < n; j++) {
					if (j == 0 || j == n - 1)
						printf("*");
					else
						printf(" ");
				}
			}
			printf("\n");
		}
	}

	return 0;
}