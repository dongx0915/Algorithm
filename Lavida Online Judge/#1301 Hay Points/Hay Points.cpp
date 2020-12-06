#include <stdio.h>
#include <string.h>

struct word {
	char skill[20];
	int money;
};

int main() {
	int wordcnt, st_cnt;
	int index = 0, sum = 0, i, j, k;
	char text;
	char sentence[2000];
	word word[1000];

	scanf("%d %d", &wordcnt, &st_cnt);

	for (i = 0; i < wordcnt; i++) scanf("%s %d", word[i].skill, &word[i].money);
	for (i = 0; i < st_cnt; i++) {
		char buffer;
		scanf("%c", &buffer);
		sum = 0;

		while (1) {
			scanf("%c", &text);		

			if (text == '.') break;
			else if (text == ' ' || text == '\n') {
				sentence[index] = '\0';
				for (j = 0; j < wordcnt; j++) {
					if (!strcmp(sentence, word[j].skill)) {
						sum += word[j].money;
						break;
					}
				}
				index = 0;
			}
			else sentence[index++] = text;
		}
		printf("%d\n", sum);
	}
	return 0;
}