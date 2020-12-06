#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, person, score[20], save[20] = { 0 };
	int i, j, min, sum, cnt, save_i[20];
	double avg = 0;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &person);
		for (sum = 0, i = 0; i < person; i++) {
			scanf("%d", &score[i]);
			sum += score[i];
		}
		sort(score, score + person);
		avg = (double)sum / (double)person;

		for (cnt = 0, min = 10001, i = 0; i < person; i++) {
			save[i] = avg - score[i];
			if (save[i] < 0) save[i] = -save[i];

			if (min > save[i]) {
				min = save[i];
				cnt = 0;
				save_i[cnt] = i;
			}
			else if (min == save[i]) {
				cnt++;
				save_i[cnt] = i;
			}
		}
		sort(save_i, save_i + (cnt + 1));
		printf("%d %d\n", score[person - 1], score[save_i[cnt]]);
	}

	return 0;
}