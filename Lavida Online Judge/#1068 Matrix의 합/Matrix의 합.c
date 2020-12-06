#include <stdio.h>

int main() {
	int test, a[10][10], b[10][10], c[10][10];
	int i, j, n1, m1, n2, m2;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &n1, &m1);
		for (i = 0; i < n1; i++) {
			for (j = 0; j < m1; j++) {
				scanf("%d", &a[i][j]);
			}
		}
		scanf("%d %d", &n2, &m2);
		for (i = 0; i < n2; i++) {
			for (j = 0; j < m2; j++) {
				scanf("%d", &b[i][j]);
			}
		}
		if (n1 == n2 && m1 == m2){
			for (i = 0; i < n2; i++) {
				for (j = 0; j < m2; j++) {
					c[i][j] = a[i][j] + b[i][j];
					printf("%d", c[i][j]);
					if (j != m2 - 1)
						printf(" ");
				}
				printf("\n");
			}
		}
		else
			printf("Impossible\n");
	}
	return 0;
}