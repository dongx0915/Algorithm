#include <stdio.h>
int m[100][100], trans[100][100];
void printMatrix(int a, int b);

int main() {
	int test, a, b;
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

		int cnt = 0;
		for (i = 0; i < a; i++) {
			for (j = 0; j < b; j++) {
				if (trans[i][j] == m[i][j]) cnt++;
			}
		}
		if (cnt == a * b) printf("Identical\n");
		else printMatrix(a, b);
	}

	return 0;
}

void printMatrix(int a, int b) {
	for (int i = 0; i < b; i++) {
		for (int j = 0; j < a; j++) {
			printf("%d", trans[i][j]);
			if (j != a - 1)
				printf(" ");
		}
		printf("\n");
	}
}