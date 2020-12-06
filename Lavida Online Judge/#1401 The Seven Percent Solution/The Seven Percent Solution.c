#include <stdio.h>
#include <string.h>


const int MAXSIZE = 80;

int main() {
	char word[MAXSIZE];
	while (1) {
		gets(word);

		if (word[0] == '#')
			break;

		for (int i = 0; word[i] != '\0'; i++) {
				switch (word[i]) {
				case ' ': printf("%%20"); break;
				case '!': printf("%%21"); break;
				case '$': printf("%%24"); break;
				case '%': printf("%%25"); break;
				case '(': printf("%%28"); break;
				case ')': printf("%%29"); break;
				case '*': printf("%%2a"); break;
				default: printf("%c", word[i]); break;
				}
		}
		printf("\n");
	}
	return 0;
}