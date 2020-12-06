#include <stdio.h>

int main() {
	int test, n, score[1000], i, j, sum = 0, temp = 0, k;
	double avg = 0, ss;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++)
			scanf("%d", &score[i]);
		for (i = 0; i < n - 1; i++)
		{
			for (j = i + 1; j < n; j++)
			{
				if (score[i] > score[j]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		for (i = 1, sum = 0; i < n - 1; i++) {
			sum += score[i];
		}
		avg = (sum / (double)(n - 2));
		k = (int)avg;
		ss = avg - (double)(sum / (n - 2));
		if (((ss * 100) - (int)(ss * 100)) >= 0.5) {
			ss += 0.005;
		}
		printf("%.2f\n", ((double)k + ss));
	}
	return 0;
}