#include <stdio.h>
#include <string.h>

int main() {
	int test, len1 = 0, len2 = 0;
	char word1[1001], word2[1000];

	scanf("%d", &test);
	while (test--) {
		int alpha1[26] = { 0 }, alpha2[26] = { 0 };
		scanf("%s", word1);
		scanf("%s", word2);
		len1 = strlen(word1), len2 = strlen(word2);

		for (int i = 0; i < len1; i++) {
			alpha1[word1[i] - 97]++;
		}
		for (int i = 0; i < len2; i++) {
			alpha2[word2[i] - 97]++;
		}

		for (int i = 0; i < 26; i++) {
			if (alpha1[i] == 0 || alpha2[i] == 0) continue;
			else if (alpha1[i] != 0 || alpha2[i] != 0) {
				if (alpha1[i] > alpha2[i]) {
					for (int j = 0; j < alpha2[i]; j++) printf("%c", 'a' + i);
				}
				else {
					for (int j = 0; j < alpha1[i]; j++) printf("%c", 'a' + i);
				}
			}
		}
		printf("\n");
	}
	return 0;
}