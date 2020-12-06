#include <stdio.h>
#include <string.h>

char sentence[500000], save[500000];

int compare_word(char save[]) {

	if (!strcmp(save, "not")) return 0;
	else if (!strcmp(save, "never")) return 0;
	else if (!strcmp(save, "no")) return 0;
	else if (!strcmp(save, "bad")) return 0;
	else return 1;
}

int main() {
	int test, i, k;

	char buffer;
	scanf("%d", &test);
	scanf("%c", &buffer);
	while (test--) {
		gets(sentence);

		int sum = 0, len = 0;
		for(i = 0, k = 0; sentence[k] != '\0'; k++) {
			if (sentence[i] == '.') break;
			if (sentence[k] >= 65 && sentence[k] <= 90) sentence[k] += 32;

			if (sentence[k] == ' ') {
				save[i] = '\0';
		
				len = strlen(save);

				if (!compare_word(save)) sum -= 10;
				else sum += (len * len);
				i = 0;
			}
			else {
				save[i] = sentence[k];
				i++;
			}
		}

		if (sum < 0) sum = 0;
		printf("%d\n", sum);
	}
	return 0;
}
