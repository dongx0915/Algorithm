#include <stdio.h>
int rotto[6], myrotto[6];

int judgenum() {
	int save_rotto[6], cnt, i, j;

	for (cnt = 0, i = 0; i < 6; i++) {
		save_rotto[i] = rotto[i];
		for (j = 0; j < 6; j++) {
			if (save_rotto[i] == myrotto[j]) {
				save_rotto[i] = 0;
				cnt++;
			}
		}
	}
	return cnt;
}

int main() {
	int test, money, person, i, j;
	scanf("%d", &test);

	while (test--) {
		int cnt_rank[5] = { 0 }, dev_money[5] = { 0 };

		for (i = 0; i < 6; i++) scanf("%d", &rotto[i]);
		scanf("%d", &money);
		scanf("%d", &person);

		while (person--) {
			for (i = 0; i < 6; i++) scanf("%d", &myrotto[i]);

			switch (judgenum()) {
			case 6: cnt_rank[1]++; break;
			case 5: cnt_rank[2]++; break;
			case 4: cnt_rank[3]++; break;
			case 3: cnt_rank[4]++; break;
			}
		}
		if (cnt_rank[1] != 0) dev_money[1] = (money / 2) / cnt_rank[1];
		if (cnt_rank[2] != 0) dev_money[2] = (money / 4) / cnt_rank[2];
		if (cnt_rank[3] != 0) dev_money[3] = ((money / 100) * 15) / cnt_rank[3];
		if (cnt_rank[4] != 0) dev_money[4] = ((money / 100) * 5) / cnt_rank[4];

		printf("%d %d %d %d %d %d %d %d\n", cnt_rank[1], dev_money[1], cnt_rank[2], dev_money[2], cnt_rank[3], dev_money[3], cnt_rank[4], dev_money[4]);
	}
	return 0;
}