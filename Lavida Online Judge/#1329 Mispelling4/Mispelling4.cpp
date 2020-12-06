#include <stdio.h>

int main() {
	int test, erase, cnt = 0;
	char word[81];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %s", &erase, word);

		printf("%d ", ++cnt);
		for (int i = 0; word[i] != '\0'; i++) if (i == erase - 1) continue; else printf("%c", word[i]);
		printf("\n");
	}
	return 0;
}