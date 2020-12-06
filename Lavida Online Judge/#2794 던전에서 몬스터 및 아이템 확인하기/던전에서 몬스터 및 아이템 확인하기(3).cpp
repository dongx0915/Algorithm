#include <stdio.h>

int dungeon[22][22];
char alphabet[27] = { 'A', 'B', 'C', 'D', 'E' ,'F' ,'G', 'H', 'I', 'J' ,'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W','X' ,'Y' ,'Z' };

int main() {
	int test, across, down;
	int i, j;
	char buffer;
	scanf("%d", &test);
	while (test--) {
		int mark_cnt[4] = { 0 };
		int cnt_alphabet[26] = { 0 };
		scanf("%d %d", &down, &across);
		//scanf("%c", &buffer);

		for (i = 0; i < down; i++) {
			for (j = 0; j < across; j++) {
				scanf(" %c", &dungeon[i][j]);
				if ((dungeon[i][j] >= 65) && (dungeon[i][j] <= 90)) {
					cnt_alphabet[dungeon[i][j] - 'A']++;
				}
				switch (dungeon[i][j]) {
				case '!': mark_cnt[0]++; break;
				case '$': mark_cnt[1]++; break;
				case '@': mark_cnt[2]++; break;
				case '&': mark_cnt[3]++; break;
				default: break;
				}
			}
			//scanf("%c", &buffer);
		}

		printf("!:%d\n", mark_cnt[0]);
		printf("$:%d\n", mark_cnt[1]);
		printf("@:%d\n", mark_cnt[2]);
		printf("&:%d\n", mark_cnt[3]);

		int zero_cnt = 0;
		for (i = 0; i < 26; i++) {
			if (cnt_alphabet[i] == 0) zero_cnt++;
		}

		if (zero_cnt != 26) {
			for (i = 0; i < 26; i++) {
				if (cnt_alphabet[i] != 0) {
					printf("%c:%d ", alphabet[i], cnt_alphabet[i]);
				}
			}
			printf("\n");
		}

	}

	return 0;
}