#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, score[5], i;

	scanf("%d", &test);

	while (test--) {
		for (i = 0; i < 5; i++) {
			scanf("%d", &score[i]);
		}

		sort(score, score + 5);

		if (score[3] - score[1] >= 4)
			printf("KIN\n");
		else
			printf("%d\n", score[1] + score[2] + score[3]);
	}

	return 0;
}