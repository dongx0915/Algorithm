#include <stdio.h>

int main() {
	int test, i, j, rotto[6], bonus, number[6];
	int cnt, bonus_cnt;
	scanf("%d", &test);

	while (test--) {
		for (i = 0; i < 6; i++)
			scanf("%d", &rotto[i]);
		scanf("%d", &bonus);

		for (i = 0; i < 6; i++)
			scanf("%d", &number[i]);

		for (bonus_cnt = 0, cnt = 0, i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (number[j] == bonus) {
					bonus_cnt++;
					bonus = 0;
				}
				else if (number[j] == rotto[i]) {
					cnt++;
					rotto[i] = 0;
				}
			}
		}

		switch (cnt) {
		case 6:
			printf("1\n");
			break;
		case 5:
			if (bonus_cnt == 1)
				printf("2\n");
			else
				printf("3\n");
			break;
		case 4:
			printf("4\n");
			break;
		case 3:
			printf("5\n");
			break;
		default:
			printf("Fail\n");
			break;
		}
	}
	return 0;
}