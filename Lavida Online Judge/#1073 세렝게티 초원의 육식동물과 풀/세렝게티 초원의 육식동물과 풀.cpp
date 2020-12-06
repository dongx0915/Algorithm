#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, territory, life, i, j, k;
	int power[10][10];

	scanf("%d", &test);
	while (test--) {
		int minmax[100];
		scanf("%d %d", &territory, &life);

		for (k = 0, i = 0; i < territory; i++) {
			int min = 1001, max = 0;
			for (j = 0; j < life; j++) {
				scanf("%d", &power[i][j]);
				if (min >= power[i][j]) min = power[i][j];
				if (max <= power[i][j]) max = power[i][j];
			}
			minmax[k++] = min, minmax[k++] = max;
		}

		sort(minmax, minmax + k);
		for (i = 0; i < k; i++) {
			printf("%d", minmax[i]);
			if (i != k - 1) printf(" ");
		}
		printf("\n");
	}
	return 0;
}