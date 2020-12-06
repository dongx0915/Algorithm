#include <stdio.h>
int sdoku[9][9];

int across_down() {
	for (int i = 0; i < 9; i++) {
		int acr_check[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int down_check[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int j = 0; j < 9; j++) {
			if (acr_check[sdoku[i][j]] == 0) return 0;
			else acr_check[sdoku[i][j]] = 0;

			if (down_check[sdoku[j][i]] == 0) return 0;
			else down_check[sdoku[j][i]] = 0;
		}
	}
	return 1;
}

int square_check() {
	int square = 0, i_cnt = 0;
	int i, j;
	
	while (1) {
		int square_check[10] = { 0,1,2,3,4,5,6,7,8,9 };
	
		if (square >= 9) i_cnt += 3, square = 0;
		if (i_cnt >= 9) break;

		for (i = i_cnt; i < i_cnt + 3; i++) {
			for (j = square; j < square + 3; j++) {
				if (square_check[sdoku[i][j]] == 0) return 0;
				else square_check[sdoku[i][j]] = 0;
			}
		}
		square += 3;
	}
	return 1;
}

int main() {
	int test, i, j;

	scanf("%d", &test);
	while (test--) {
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				scanf("%d", &sdoku[i][j]);
			}
		}

		if (across_down() == 1 && square_check() == 1) printf("Yes\n");
		else printf("No\n");
	}

	return 0;
}