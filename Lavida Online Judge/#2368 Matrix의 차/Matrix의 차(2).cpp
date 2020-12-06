#include <stdio.h>

int main() {
	int test, an1, am1, bn2, bm2, i ,j, zero_cnt = 0;
	int a[10][10], b[10][10], c[10][10];

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &an1, &am1);
		for (i = 0; i < an1; i++) {
			for (j = 0; j < am1; j++) {
				scanf("%d", &a[i][j]);
			}
		}

		scanf("%d %d", &bn2, &bm2);
		for (i = 0; i < bn2; i++) {
			for (j = 0; j < bm2; j++) {
				scanf("%d", &b[i][j]);
			}
		}

		if (an1 == bn2 && am1 == bm2) {
			for (zero_cnt = 0, i = 0; i < an1; i++) {
				for (j = 0; j < am1; j++) {
					c[i][j] = a[i][j] - b[i][j];
					if (c[i][j] == 0)
						zero_cnt++;
				}
			}

			if (zero_cnt == (an1 * am1))
				printf("Identical\n");
			else {
				for (i = 0; i < an1; i++) {
					for (j = 0; j < am1; j++) {
						printf("%d", c[i][j]);
						if (j != am1 - 1)
							printf(" ");
					}
					printf("\n");
				}
			}
		}
		else
			printf("Impossible\n");
	}

	return 0;
}