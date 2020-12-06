#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, dungeon, soldier, i, j, k;
	int level[10][20];

	scanf("%d", &test);

	while (test--) {
		int minmax[100] = { 0 }, min_i[100] = { 0 }, max_i[100] = { 0 };
		scanf("%d %d", &dungeon, &soldier);

		for (i = 0; i < dungeon; i++) {
			int min = 201, max = 0;
			for (j = 0; j < soldier; j++) {
				scanf("%d", &level[i][j]);
				if (min >= level[i][j]) min = level[i][j];
				if (max <= level[i][j]) max = level[i][j];
			}
			min_i[i] = min;
			max_i[i] = max;
		}
		k = 0;
		for (i = 0; i < dungeon; i++, k++) minmax[k] = min_i[i];
		for (i = 0; i < dungeon; i++, k++) minmax[k] = max_i[i];
		sort(minmax, minmax + k);

		printf("%d\n", minmax[k - 1]);
		for(i = 0; i < dungeon; i++) printf("%d %d\n", max_i[i], min_i[i]);
	}
	return 0;
}