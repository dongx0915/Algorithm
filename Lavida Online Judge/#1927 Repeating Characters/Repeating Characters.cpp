#include <stdio.h>

int main() {
	int test, num, repeat;
	char word[100];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d %s", &num, &repeat, word);
		printf("%d ", num);
		for (int i = 0; word[i] != '\0'; i++) {
			for (int j = 0; j < repeat; j++) {
				printf("%c", word[i]);
			}
		}
		printf("\n");
	}
	return 0;
}