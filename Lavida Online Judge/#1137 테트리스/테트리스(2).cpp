#include <stdio.h>

int main() {
	int test, down;
	int i, j;
	char tetris[20][10];
	char buffer;
	scanf("%d", &test);

	while (test--)
	{
		int cnt[20] = { 0 };
		scanf("%d", &down);
		scanf("%c", &buffer);

		for (i = 0; i < down; i++) {
			for (j = 0; j < 10; j++) {
				scanf("%c", &tetris[i][j]);
				if (tetris[i][j] == '@') cnt[i]++;
			}
			scanf("%c", &buffer);
		}

		for (i = 0; i < down; i++) {
			for (j = 0; j < 10; j++) {
				if (cnt[i] == 10) continue;
				else{
					printf("%c", tetris[i][j]);
					if (j == 9) printf("\n");
				}
			}
		}
	}

	return 0;
}