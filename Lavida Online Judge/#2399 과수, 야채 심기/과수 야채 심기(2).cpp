#include <stdio.h>

int main() {
	int test, num, i, j;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);
		int orchard[20][20];

		for (i = 0; i < num; i++) {
			for (j = 0; j < num; j++) {
				orchard[i][j] = (num / 2);
			}
		}

		if (num % 2 != 0) { // 홀수일때
			int index = num / 2;
			int k = (num / 2);

			while (k--) {
				for (i = index - k; i <= index + k; i++) {
					for (j = index - k; j <= index + k; j++) {
						orchard[i][j]--;
					}
				}
			}
			for (i = 0; i < num; i++) {
				for (j = 0; j < num; j++) {
					switch (orchard[i][j]) {
					case 4: orchard[i][j] = 6; break;
					case 5: orchard[i][j] = 10; break;
					case 6: orchard[i][j] = 12; break;
					case 7: orchard[i][j] = 15; break;
					case 8: orchard[i][j] = 18; break;
					case 9: orchard[i][j] = 22; break;
					}
					printf("%c", 'A' + orchard[i][j]);
				}
				printf("\n");
			}
			if (test != 0) printf("\n");
		}

		else {
			int index = (num / 2);
			int k = (num / 2) - 1;

			while (k--) {
				for (i = index - 1 - k; i <= index + k; i++) {
					for (j = index - 1 - k; j <= index + k; j++) {
						orchard[i][j]--;
					}
				}
			}

			for (i = 0; i < num; i++) {
				for (j = 0; j < num; j++) {
					switch (orchard[i][j]){
					case 5: orchard[i][j] = 7; break;
					case 6: orchard[i][j] = 11; break;
					case 7: orchard[i][j] = 13; break;
					case 8: orchard[i][j] = 16; break;
					case 9: orchard[i][j] = 19; break;
					case 10: orchard[i][j] = 23; break;
					}
					printf("%c", 'A' + orchard[i][j] - 1);
				}
				printf("\n");
			}
			if (test != 0) printf("\n");
		}
	}

	return 0;
}