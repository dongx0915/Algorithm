#include <stdio.h>

int main() {
	int a, b, c, d, e, f, g, sum;
	scanf("%d %d %d %d %d %d %d", &a, &b, &c, &d, &e, &f, &g);

	sum = (a + b + c + d + e + f + g);

	printf("%d %d\n", sum, (sum / 7));
	printf("%d\n", (sum * 7000));

	return 0;
}