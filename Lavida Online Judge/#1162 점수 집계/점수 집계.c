#include <stdio.h>

int main() {
	int test, i, j, temp;
	int score[5];

	scanf("%d", &test);
	while (test--) {
		for (i = 0; i < 5; i++)
			scanf("%d", &score[i]);

		for (i = 0; i <= 5; i++) {
			for (j = i + 1; j <= 4; j++) {
				if (score[i] > score[j]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}

		if ((score[3] - score[1]) >= 4)
			printf("KIN\n");
		else
			printf("%d\n", score[1] + score[2] + score[3]);
	}

	return 0;
}