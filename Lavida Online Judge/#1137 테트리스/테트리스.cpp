#include <stdio.h>

int main() {
	int test, down, i, j;
	char tetris[20][10];
	char buffer;

	scanf("%d", &test);
	while (test--) {
		scanf("%d", &down);
		scanf("%c", &buffer);
		int cnt_block[20] = { 0 };

		for (i = 0; i < down; i++) {
			for (j = 0; j < 10; j++) {
				scanf("%c", &tetris[i][j]);
				if (tetris[i][j] == '@') cnt_block[i]++;
			}
			scanf("%c", &buffer);
		}

		for (i = 0; i < down; i++) {
			for (j = 0; j < 10; j++) {
				if (cnt_block[i] == 10) continue;
				else {
					printf("%c", tetris[i][j]);
					if (j == 9) printf("\n");
				}
			}
		}

	}
	return 0;
}