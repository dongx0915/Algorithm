#include <stdio.h>
#include <string.h>

int main() {
	int test, i, str = 0;
	char pw[200];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", pw);

		str = strlen(pw);

		for (i = 0; i <= str - 1; i += 2)
			printf("%c", pw[i]);
		for (i = 1; i <= str - 1; i += 2)
			printf("%c", pw[i]);

		printf("\n");
	}

	return 0;
}