#include <stdio.h>

int main() {
	int R, S, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &R, &S);
		printf("%d\n", R / S);
	}
	return 0;
}