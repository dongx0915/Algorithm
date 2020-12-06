#include <stdio.h>
#include <string.h>

int main() {
	int test;
	char message[101];

	scanf("%d", &test);
	while (test--) {
		scanf("%s", message);
		int len = strlen(message);

		for (int i = 0; i < len; i += 2) printf("%c", message[i]);
		for (int i = 1; i < len; i += 2) printf("%c", message[i]);
		printf("\n");
	}
	return 0;
}