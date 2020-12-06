#include <stdio.h>

int main() {
	int test, AN, AM, BN, BM;
	int i, j;
	int a[10][10], b[10][10], c[10][10];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &AN, &AM);
		for (i = 0; i < AN; i++) {
			for (j = 0; j < AM; j++) {
				scanf("%d", &a[i][j]);
			}
		}

		scanf("%d %d", &BN, &BM);
		for (i = 0; i < BN; i++) {
			for (j = 0; j < BM; j++) {
				scanf("%d", &b[i][j]);
			}
		}

		if (AN == BN && AM == BM) {
			for (i = 0; i < AN; i++) {
				for (j = 0; j < AM; j++) {
					c[i][j] = a[i][j] + b[i][j];
					printf("%d", c[i][j]);
					if (j != AM - 1) printf(" ");
				}
				printf("\n");
			}
		}
		else printf("Impossible\n");
	}
	return 0;
}