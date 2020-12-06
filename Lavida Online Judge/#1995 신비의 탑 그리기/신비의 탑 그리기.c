#include <stdio.h>

int main() {
	int h, i, j, k;

	scanf("%d", &h);

	for (i = 0; i < h; i++) {
		for (j = 0; j < i; j++) {
			printf(" ");
		}
		for (j = h - 1; j >= i; j--) {
			printf("@");
			if (j <= i) {
				for (k = h - 1; k > j; k--) {
					printf("@");
				}
			}
		}
		printf("\n");
	}
	k = 2 * h - 1;
	while (k--) {
		for (i = 2 * h - 1; i > 0; i--) {
			printf("@");
		}
		printf("\n");
	}
	return 0;
}