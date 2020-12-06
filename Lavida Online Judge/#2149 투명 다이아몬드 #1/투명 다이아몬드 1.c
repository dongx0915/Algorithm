#include <stdio.h>

int main() {
	int test, h, i, j, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &h);
		if (h % 2 == 0)
			h -= 1;
		for (i = 1; i <= (h / 2) + 1; i++) {
			for (j = (h / 2) + 1; j > i; j--)
				printf(" ");
			for (j = 0; j < i; j++) {
				if (j == 0)
					printf("$");
				else
					printf(" ");
				if (j == i - 1) {
					for (k = 1; k < i; k++) {
						if (k == i - 1)
							printf("$");
						else
							printf(" ");
					}
				}
			}
			printf("\n");
		}

		for (i = 1; i <= (h / 2); i++) {
			for (j = 0; j < i; j++)
				printf(" ");
			for (j = (h / 2); j >= i; j--) {
				if (j == (h / 2))
					printf("$");
				else
					printf(" ");
				if (j == i) {
					for (k = (h / 2); k > i; k--) {
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