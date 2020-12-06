#include <stdio.h>

int main() {

	int n, i, j, k;

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		if (i == 0 || i == n - 1) {
			for (j = 0; j < n; j++) {
				printf("*");
				if (j == n - 1)
					printf("\n");
			}
		}
		else {
			while (1) {
				for (k = 0; k < n; k++) {
					if (k == 0 || k == n - 1) {
						printf("*");
					}
					else
						printf(" ");
				}
				printf("\n");
				break;
			}
		}
	}
	return 0;
}