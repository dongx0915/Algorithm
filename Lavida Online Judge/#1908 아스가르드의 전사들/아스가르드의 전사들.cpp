#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, y, x, min, max, i, j, min_i, max_i;
	int level[10][10];
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

		for (i = k - 1; i >= 0; i--) {
			printf("%d", minmax[i]);
			if (i != 0)
				printf(" ");
		}
		printf("\n");
	}
	return 0;
}