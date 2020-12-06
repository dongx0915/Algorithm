#include <stdio.h>

int main() {
	int test, sum, i;
	char word[5000], buffer;

	scanf("%d", &test);
	scanf("%c", &buffer);
	while (test--) {
		gets(word);

		for (sum = 0, i = 0; word[i] != '\0'; i++) {
			if (word[i] >= 'A' && word[i] <= 'Z') word[i] += 32;

			if (word[i] == 'w' || word[i] == 'x' || word[i] == 'y' || word[i] == 'z') sum += 29;
			else if (word[i] == 'b' || word[i] == 'd' || word[i] == 'f' || word[i] == 'p') sum += 15;
			else if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') sum += 8;
			else if (word[i] == 'r' || word[i] == 's' || word[i] == 't') sum -= 7;
		}
		printf("%d\n", sum);
	}
	return 0;
}