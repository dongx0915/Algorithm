#include <stdio.h>
int sdoku[9][9];

int judge() {
	for (int i = 0; i < 9; i++) {
		int across[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 ,9 };
		int down[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 ,9 };
		for (int j = 0; j < 9; j++) {
			if (across[sdoku[i][j]] != 0) across[sdoku[i][j]] = 0;
			else return 0;

			if (down[sdoku[j][i]] != 0) down[sdoku[j][i]] = 0;
			else return 0;
		}
	}
	return 1;
}

int across_sqr() {
	int square = 0, i_cnt = 0;
	int i = 0, j;

	while (1) {
		if (i >= 9) break;
		if (square >= 9) i_cnt += 3, square = 0;
		int judgenum[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 ,9 };

		for (i = i_cnt; i < i_cnt + 3; i++) {
			for (j = square; j < square + 3; j++) {
				if (judgenum[sdoku[i][j]] != 0) judgenum[sdoku[i][j]] = 0;
				else return 0;
			}
		}
		square += 3;
	}
	return 1;
}

int main() {
	int test;
	scanf("%d", &test);

	while (test--) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				scanf("%d", &sdoku[i][j]);
			}
		}
		if (judge() == 1 && across_sqr() == 1) printf("Yes\n");
		else printf("No\n");
	}
	return 0;
}