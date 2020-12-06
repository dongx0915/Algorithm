#include <stdio.h>

int main() {
	int test, num, i, j;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);
		int orchard[20][20], first = 0, end = 0, k = 0;

		if (num % 2 != 0) first = num / 2, end = num / 2, k = (num / 2);
		else first = (num / 2) - 1, end = (num / 2), k = (num / 2) - 1;

		for (i = 0; i < num; i++)  for (j = 0; j < num; j++) orchard[i][j] = 1;

		while (k--) {
			for (i = first - k; i <= end + k; i++) {
				for (j = first - k; j <= end + k; j++) {
					orchard[i][j]++;
				}
			}
		}
		for (i = 0; i < num; i++) {
			for (j = 0; j < num; j++) {
				printf("%d", orchard[i][j]);
			}
			printf("\n");
		}
		if (test != 0) printf("\n");
	}
	return 0;
}