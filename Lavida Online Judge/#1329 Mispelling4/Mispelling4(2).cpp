#include <stdio.h>
#include <string.h>

int main() {
	int test, n, i, j = 1, len;
	char word[81];

	scanf("%d", &test);

	for (j = 1; j <= test; j++) {
		scanf("%d %s", &n, word);

		len = strlen(word);

		for (i = n - 1; i + 1 < len; i++)
			word[i] = word[i + 1];

		printf("%d ", j);
		for (i = 0; i < len - 1; i++)
			printf("%c", word[i]);
		printf("\n");
	}

	return 0;
}