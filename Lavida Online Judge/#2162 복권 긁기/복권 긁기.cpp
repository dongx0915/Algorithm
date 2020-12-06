#include <stdio.h>
int rotto[6], mynum[6], bonus, bonus_cnt = 0;

int judgenum() {
	int cnt = 0; 
	bonus_cnt = 0;

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (mynum[j] == bonus) {
				bonus_cnt++;
				bonus = 0;
				continue;
			}
			else if (mynum[j] == rotto[i]) {
				rotto[i] = 0;
				cnt++;
			}
		}
	}
	return cnt;
}

int main() {
	int test, i, j;

	scanf("%d", &test);

	while (test--) {
		for (i = 0; i < 6; i++) scanf("%d", &rotto[i]);
		scanf("%d", &bonus);
		for (i = 0; i < 6; i++) scanf("%d", &mynum[i]);

		switch (judgenum()){
		case 6: printf("1\n"); break;
		case 5: if (bonus_cnt == 1) printf("2\n"); else printf("3\n"); break;
		case 4: printf("4\n"); break;
		case 3: printf("5\n"); break;
		default: printf("Fail\n"); break;
		}
	}
	return 0;
}