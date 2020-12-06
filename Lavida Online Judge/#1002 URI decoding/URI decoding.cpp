#include <stdio.h>
#include <string.h>

int main() {
	char URI[81];

	gets(URI);

	for (int i = 0; URI[i] != '\0'; i++) {
		if (URI[i] == '%' && URI[i + 1] == '2') {
			switch (URI[i + 2]) {
			case '0': printf(" "); break;
			case '1': printf("!"); break;
			case '4': printf("$"); break;
			case '5': printf("%%"); break;
			case '8': printf("("); break;
			case '9': printf(")"); break;
			case 'a': printf("*"); break;
			}
			i += 2;
		}
		else printf("%c", URI[i]);
	}
	printf("\n");
}