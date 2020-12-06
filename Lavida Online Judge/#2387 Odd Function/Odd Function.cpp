#include <stdio.h>

int main() {
	int n;
	scanf("%d", &n);
	if (n % 2 != 0) printf("%d\n", n);
	else printf("0\n");

	return 0;
}