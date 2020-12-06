#include <stdio.h>

int main() {
	int test, num, i , j;
	int student[1000];

	scanf("%d", &test);
	while (test--) {
		int sum = 0;
		double avg = 0, cnt = 0;
		scanf("%d", &num);

		for (i = 0; i < num; i++) {
			scanf("%d", &student[i]);
			sum += student[i];
		}
		avg = sum / num;
		for (i = 0; i < num; i++) {
			if (avg < student[i]) cnt++;
		}
		printf("%.3lf%%\n", (cnt / num) * 100);
	}
	return 0;
}