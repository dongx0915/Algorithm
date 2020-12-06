#include <stdio.h>

int main() {
	int a, b, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &a, &b);

		if ((a - b) >= 0) printf("1\n");
		else printf("0\n");
	}
	return 0;
}