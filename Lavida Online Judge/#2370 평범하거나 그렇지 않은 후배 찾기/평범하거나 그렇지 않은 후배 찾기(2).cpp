#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, num, sum, score[20], save[20];
	int i, save_i[20], cnt;
	double avg, min, abs[20];
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);

		for (sum = 0, i = 0; i < num; i++) {
			scanf("%d", &score[i]);
			save[i] = score[i];
			sum += save[i];
		}
		sort(save, save + num);
		avg = (double)sum / (double)num;

		for (cnt = 0, min = 10001, i = 0; i < num; i++) {
			abs[i] = avg - (double)score[i];

			if (abs[i] < 0)
				abs[i] = -abs[i];

			if (min > abs[i]) {
				min = abs[i];
				cnt = 0;
				save_i[cnt] = i;
			}
			else if (min == abs[i]) {
				cnt++;
				save_i[cnt] = i;
			}
		}
		sort(save_i, save_i + (cnt + 1));
		printf("%d %d\n", save[num - 1], score[save_i[cnt]]);
	}
	return 0;
}