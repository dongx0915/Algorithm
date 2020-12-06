#include <stdio.h>

int main() {
	int test, y, x, i, j, k ,s;
	char mine[30][30];


	scanf("%d", &test);

	while (test--) {
		int submine[30][30] = { 0 };
		char buffer;

		scanf("%d %d", &y, &x);
		scanf("%c", &buffer);

		for (i = 0; i < y; i++) {
			for (j = 0; j < x; j++) {
				scanf("%c", &mine[i][j]);

				if (mine[i][j] == '*') {
					for (k = i - 1; k <= i + 1; k++) {
						for (s = j - 1; s <= j + 1; s++) {
							if (k < 0 || s < 0 || k > y - 1 || s > x - 1) continue;
							else submine[k][s]++;
						}
					}
				}
			}
			scanf("%c", &buffer);
		}

		for (i = 0; i < y; i++) {
			for (j = 0; j < x; j++) {
				if (mine[i][j] == '*') printf("*");
				else printf("%d", submine[i][j]);
			}
			printf("\n");
		}

	}
	return 0;
}