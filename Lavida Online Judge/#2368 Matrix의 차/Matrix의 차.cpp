#include <stdio.h>

int main() {
	int test, AM, AN, BM, BN, i, j;
	int a[10][10], b[10][10], c[10][10];
	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &AM, &AN);
		for (i = 0; i < AM; i++) 	for (j = 0; j < AN; j++) scanf("%d", &a[i][j]);
			
		scanf("%d %d", &BM, &BN);
		for (i = 0; i < BM; i++) for (j = 0; j < BN; j++) scanf("%d", &b[i][j]);
			
		if (AM == BM && AN == BN) {
			int zero_cnt = 0;
			for (i = 0; i < AM; i++) {
				for (j = 0; j < AN; j++) {
					c[i][j] = a[i][j] - b[i][j];
					if (c[i][j] == 0) zero_cnt++;
				}
			}
			if (zero_cnt == AM * AN) printf("Identical\n");
			else {
				for (i = 0; i < AM; i++) {
					for (j = 0; j < AN; j++) {
						printf("%d", c[i][j]);
						if (j != AN - 1) printf(" ");
					}
					printf("\n");
				}
			}
		}
		else printf("Impossible\n");
	}
	return 0;
}