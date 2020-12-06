#include <stdio.h>

int JudgeNum(int rotto[], int person_num[]) {
	int cnt = 0, saverotto[6];

	for (int i = 0; i < 6; i++) {
		saverotto[i] = rotto[i];
		for (int j = 0; j < 6; j++) {
			if (person_num[j] == saverotto[i]) {
				cnt++;
				saverotto[i] = 0;
			}
		}
	}
	return cnt;
}

int main() {
	int test, rotto[6], person, person_num[6];
	int i, j;
	int cnt_1st, cnt_2nd, cnt_3rd, cnt_4th;
	long long dev_money;
	scanf("%d", &test);

	while (test--) {
		cnt_1st = 0, cnt_2nd = 0, cnt_3rd = 0, cnt_4th = 0;
		long long money[4] = { 0 };

		for (i = 0; i < 6; i++)	scanf("%d", &rotto[i]);

		scanf("%lld", &dev_money);
		scanf("%d", &person);

		for (i = 0; i < person; i++) {
			for (j = 0; j < 6; j++) scanf("%d", &person_num[j]);

			switch (JudgeNum(rotto, person_num)) {
			case 6: cnt_1st++; break;
			case 5: cnt_2nd++; break;
			case 4: cnt_3rd++; break;
			case 3: cnt_4th++; break;
			}
		}

		if (cnt_1st != 0) money[0] = (dev_money / 2) / cnt_1st;
		if (cnt_2nd != 0) money[1] = (dev_money / 4) / cnt_2nd;
		if (cnt_3rd != 0) money[2] = ((dev_money / 100) * 15) / cnt_3rd;
		if (cnt_4th != 0) money[3] = ((dev_money / 100) * 5) / cnt_4th;

		printf("%d %lld %d %lld %d %lld %d %lld\n", cnt_1st, money[0], cnt_2nd, money[1], cnt_3rd, money[2], cnt_4th, money[3]);
	}

	return 0;
}