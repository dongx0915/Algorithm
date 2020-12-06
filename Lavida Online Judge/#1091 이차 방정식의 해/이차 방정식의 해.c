#include <stdio.h>

int main() {
	int test, a, b, c, k;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d", &a, &b, &c);
		k = (b * b) - 4 * a * c;

		if (k > 0)
			printf("This Equation has two answers\n");
		else if (k == 0)
			printf("This Equation has only one answer\n");
		else if (k < 0)
			printf("This Equation has no answer\n");
	}
	return 0;
}