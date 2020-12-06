#include <stdio.h>

int main() {
	int n, sum[10], i = 0, j = 0, score1 = 0, score2 = 0, sumk = 0;
	for (i = 0; i < 10; i++) {
		scanf("%d", &n);
		sum[i] = n;
	}

	for (i = 0, sumk = 0; i < 10; i++) {
		sumk += sum[i];
		if (sumk >= 100)
			break;
	}

	score1 = 100 - (sumk - sum[i]);
	score2 = 100 - sumk;

	if (score1 < 0)
		score1 = -score1;
	if (score2 < 0)
		score2 = -score2;

	if (score1 == score2)
		printf("%d\n", sumk);
	else if (score1 > score2)
		printf("%d\n", sumk);
	else
		printf("%d\n", sumk - sum[i]);

	return 0;
}