#include <stdio.h>

int main() {
	int test, num1, num2;
	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &num1, &num2);
		printf("%d\n", num1 + num2);
	}
	return 0;
}