#include <stdio.h>

int main() {
	int test, sum, i;
	char word[31];

	scanf("%d", &test);
	while (test--) {
		scanf("%s", word);

		for (sum = 0, i = 0; word[i] != '\0'; i++) sum += word[i] - 96;
		printf("%d\n", sum);
	}
	return 0;
}