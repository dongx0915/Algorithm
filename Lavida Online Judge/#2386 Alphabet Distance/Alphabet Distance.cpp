#include <stdio.h>

int main() {
	char word1, word2;
	int distance = 0;
	scanf("%c %c", &word1, &word2);
	distance = word2 - word1 - 1;
	printf("%d\n", distance);
	return 0;
}