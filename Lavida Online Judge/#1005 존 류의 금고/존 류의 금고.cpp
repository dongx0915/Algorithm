#include <stdio.h>

int main() {
	char password[101];
	int num[4];
	scanf("%s", password);
	for (int i = 0; i < 4; i++) scanf("%d", &num[i]);
	for (int i = 0; i < 4; i++) printf("%c", password[num[i]]);
	printf("\n");
	return 0;
}