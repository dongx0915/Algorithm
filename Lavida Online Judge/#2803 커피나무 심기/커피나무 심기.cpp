#include <stdio.h>

int main() {
	int test, num, i, j;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);
		int orchard[20][20], first = 0, end = 0, k = 0;

		if (num % 2 != 0) first = num / 2, end = num / 2, k = (num / 2);
		else first = (num / 2) - 1, end = (num / 2), k = (num / 2) - 1;

		for (i = 0; i < num; i++)  for (j = 0; j < num; j++) orchard[i][j] = 0;

		while (k--) {
			for (i = first - k; i <= end + k; i++) {
				for (j = first - k; j <= end + k; j++) {
					orchard[i][j]++;
				}
			}
		}

		for (i = 0; i < num; i++) {
			for (j = 0; j < num; j++) {
				switch (orchard[i][j]) {
				case 3: orchard[i][j] = 6; break;
				case 4: orchard[i][j] = 9; break;
				case 5: orchard[i][j] = 11; break;
				case 6: orchard[i][j] = 12; break;
				case 7: orchard[i][j] = 15; break;
				case 8: orchard[i][j] = 19; break;
				}
				printf("%c", 'A' + orchard[i][j]);
			}
			printf("\n");
		}
		if (test != 0) printf("\n");
	}
	return 0;
}