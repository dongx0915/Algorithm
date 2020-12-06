#include <stdio.h>
#include <string.h>

typedef struct {
	char word[11];
}struct_word;

int main() {
	int test, wordnum, i, j;
	char buffer;
	char sentence[330];
	struct_word words[500];

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &wordnum);
		scanf("%c", &buffer);

		for (i = 0; i < wordnum; i++) {
			scanf("%s", words[i].word);
			for (j = 0; words[i].word[j] != '\0'; j++) {
				if (words[i].word[j] >= 65 && words[i].word[j] <= 90)
					words[i].word[j] += 32;
			}
		}
		scanf("%c", &buffer);
		gets(sentence);

		for (i = 0; sentence[i] != '\0'; i++) {
			if (sentence[i] >= 65 && sentence[i] <= 90)
				sentence[i] += 32;
		}

		int len = 0, cmp_cnt = 0, k, index;
		len = strlen(sentence);
		char save_str[500];

		for (cmp_cnt = 0, index = 0, k = 0, i = 0; i < len; i++, index++) {
			if (sentence[i] == ' ' || sentence[i] == '.') {
				save_str[index] = '\0';
				for (j = 0; j < wordnum; j++) {
					if (strcmp(save_str, words[j].word) == 0) {
						cmp_cnt++;
						strcpy(words[j].word, "0");
					}
				}
				k++, index = -1;
			}
			else
				save_str[index] = sentence[i];
		}

		if (k == cmp_cnt)
			printf("True\n");
		else
			printf("False\n");
	}
	return 0;
}