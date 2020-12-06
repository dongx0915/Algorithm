#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, y, x, min, max, i, j, min_i, max_i;
	int level[20][20];
	int save_min[20], save_max[20];
	scanf("%d", &test);

	while (test--) {
		int minmax[40] = { 0 };
		scanf("%d %d", &y, &x);
	
		for (min_i = 0, max_i = 0, i = 0; i < y; i++, min_i++, max_i++) {
			for (min = 501, max = 0, j = 0; j < x; j++) {
				scanf("%d", &level[y][x]);
				
				if (min >= level[y][x]) {
					min = level[y][x];
					save_min[min_i] = min;
				}
				if (max <= level[y][x]) {
					max = level[y][x];
					save_max[max_i] = max;
				}
			}
		}		

		int k = 0;
		for (i = 0; i < max_i; i++, k++) minmax[k] = save_max[i];
		for (j = 0; j < min_i; j++, k++) minmax[k] = save_min[j];
		sort(minmax, minmax + k);

		printf("%d %d\n", minmax[k - 1], minmax[0]);

		sort(save_max, save_max + max_i);
		for (i = 0; i < max_i; i++) {
			printf("%d", save_max[i]);
			if (i != max_i - 1)
				printf(" ");
		}
		printf("\n");
	}
	return 0;
}