#include <stdio.h>
#include <string.h>

int main() {
	char pw[101];
	int test, i, j, len = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%s", pw);

		len = strlen(pw);
		if (len % 2 == 0) {
			for (i = 0; i < (len / 2); i++) {
				printf("%c%c", pw[i], pw[len - 1 - i]);
			}
		}
		else {
			for (i = 0; i < (len / 2) + 1; i++) {
				if (i == len / 2)
					printf("%c", pw[i]);
				else
					printf("%c%c", pw[i], pw[len - 1 - i]);
			}
		}
		printf("\n");
	}
	return 0;
}