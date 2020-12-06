#include <stdio.h>

int main() {
	int pw, i;
	char word[1000], answer[5];

	scanf("%s", word);

	for (i = 0; i < 4; i++) {
		scanf("%d", &pw);

		answer[i] = word[pw];
	}
	for (i = 0; i < 4; i++)
		printf("%c", answer[i]);
	printf("\n");
	return 0;
}