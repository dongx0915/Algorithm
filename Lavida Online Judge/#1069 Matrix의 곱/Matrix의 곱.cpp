#include <stdio.h>

int main() {
	int test, AN, AM, BN, BM;
	int i, j, k;
	int a[10][10], b[10][10];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &AN, &AM);
		for (i = 0; i < AN; i++) for (j = 0; j < AM; j++) scanf("%d", &a[i][j]);

		scanf("%d %d", &BN, &BM);
		for (i = 0; i < BN; i++) for (j = 0; j < BM; j++) scanf("%d", &b[i][j]);

		if (AM == BN) {
			//AN * BM 행렬
			int c[10][10] = { 0 };

			for (i = 0; i < AN; i++) {
				for (j = 0; j < BM; j++) {
					for (k = 0; k < AM; k++) {
						c[i][j] += a[i][k] * b[k][j];
					}
					printf("%d", c[i][j]);
					if (j != BM - 1) printf(" ");
				}
				printf("\n");
			}
		}
		else printf("Impossible\n");
	}
	return 0;
}