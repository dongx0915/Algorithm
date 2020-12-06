#include <stdio.h>

int main() {
	int a, b, c, solution;

	while (1) {
		scanf("%d %d %d", &a, &b, &c);

		if (a == 0 && b == 0 && c == 0)
			break;

		solution = (b * b) - (4 * a * c);

		if (solution > 0)
			printf("real\n");
		else if (solution == 0)
			printf("multiple\n");
		else
			printf("imaginary\n");
	}
	return 0;
}