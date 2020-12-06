#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, person, i, sum, average, min, save_i;
	int score[20], save[20];

	scanf("%d", &test);
	while (test--) {
		scanf("%d", &person);

		for (sum = 0, i = 0; i < person; i++) {
			scanf("%d", &score[i]);
			sum += score[i];
		}

		average = sum / person;

		sort(score, score + person);

		for (i = 0; i < person; i++) {
			save[i] = average - score[i];
			if (save[i] < 0)
				save[i] = -save[i];
		}

		min = save[0];
		for (i = 1; i < person; i++) {
			if (min > save[i]) {
				min = save[i];
				save_i = i;
			}
		}
		
		printf("%d\n", score[save_i]);
	}

	return 0;
}