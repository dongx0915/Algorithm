#include <stdio.h>
#include <math.h>

int main() {
	int test, vote, score[100];
	int i, j, k, sum;
	scanf("%d", &test);
	while (test--) {
		int save[7] = { 0 };
		scanf("%d", &vote);
		for (i = 0; i < vote; i++) scanf("%d", &score[i]);

		for (int index = 0; index < vote; index++) {
			for (sum = 0, i = 1; i <= 7; i++) {
				for (j = 1; j <= 7; j++) {
					for (k = 1; k <= 7; k++) {
						sum = pow(2, i) + pow(2, j) + pow(2, k);
						if (sum == score[index]) {
							save[i - 1]++, save[j - 1]++, save[k - 1]++;
							break;
						}
					}
				}
			}
		}
		int min_i = 0, max_i = 0, min = save[0], max = save[0];
		for ( i = 1; i < 7; i++) {
			if (min > save[i]) min = save[i], min_i = i;
			if (max < save[i]) max = save[i], max_i = i;
		}
		int min_cnt = 0, max_cnt = 0;
		for (i = 0; i < 7; i++) {
			if (min == save[i]) min_cnt++;
			if (max == save[i]) max_cnt++;
		}
		if (min_cnt == 1 && max_cnt == 1) printf("%d/%d\n", max_i+1, min_i +1);
		else printf("Nagari\n");
	}
	return 0;
}