#include <stdio.h>
#include <string.h>

int main() {
	int test, games;
	char name1[11], name2[11];
	char word1[16], word2[16];

	scanf("%d", &test);

	while (test--) {
		int len1 = 0, len2 = 0;
		scanf("%s %s", name1, name2);
		scanf("%d", &games);

		for (int i = 0; i < games; i++) {
			scanf("%s %s", word1, word2);
			len1 = strlen(word1),	len2 = strlen(word2);

			if (len1 > len2) printf("%s wins by length!\n", name1);
			else if (len1 < len2) printf("%s wins by length!\n", name2);
			else if (!strcmp(word1, word2)) printf("%s and %s have same words!\n", name1, name2);
			else {
				for (int i = 0; i < len1; i++) {
					if (word1[i] > word2[i]) {
						printf("%s wins by order('%c' is better than '%c')!\n", name2, word2[i], word1[i]);
						break;
					}
					else if (word1[i] < word2[i]) {
						printf("%s wins by order('%c' is better than '%c')!\n", name1, word1[i], word2[i]);
						break;
					}
				}
			}

		}
	}
	return	 0;
}