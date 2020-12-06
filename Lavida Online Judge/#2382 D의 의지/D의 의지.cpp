#include <stdio.h>

int main() {
	int a, b, c, d = 0;
	scanf("%d %d %d", &a, &b, &c);

	printf("%d\n", (b * b) - (4 * a * c));
	return 0;
}