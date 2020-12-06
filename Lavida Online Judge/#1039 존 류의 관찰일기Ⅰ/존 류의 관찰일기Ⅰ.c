#include <stdio.h>

int main() {
	int test, a, b, c, d, n;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &a, &b, &c, &d);
		if ((b - a) == (c - b) && (c - b) == (d - c))
			n = d + (d - c);
		else if ((b / a) == (c / b) && (c / b) == (d / c))
			n = d * (d / c);

		printf("%d\n", n);
	}
	return 0;
}