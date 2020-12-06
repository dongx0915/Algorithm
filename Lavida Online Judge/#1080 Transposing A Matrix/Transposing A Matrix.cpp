#include <stdio.h>

int main() {
	int test, m[100][100], trans[100][100], a, b;
	int i, j;

	scanf("%d", &test);
 //i 랑 j값 체인지
	while (test--) {
		scanf("%d %d", &a, &b);
		for (i = 0; i < a; i++) {
			for (j = 0; j < b; j++) {
				scanf("%d", &m[i][j]);
			}
		}

		for (i = 0; i < a; i++) {
			for (j = 0; j < b; j++) {
				trans[j][i] = m[i][j];
			}
		}

		for (i = 0; i < b; i++) {
			for (j = 0; j < a; j++) {
				printf("%d", trans[i][j]);
				if (j != a - 1)
					printf(" ");
			}
			printf("\n");
		}
	}

	return 0;
}