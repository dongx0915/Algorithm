#include <stdio.h>

int main() {
	int test, i, int_num, sum;
	char word[31];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", word);

		for (sum = 0, int_num = 0, i = 0; word[i] != '\0'; i++) {
			int_num = (int)word[i] - 96;
			sum += int_num;
		}
		printf("%d\n", sum);
	}
	return 0;
}