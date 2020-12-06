#include <stdio.h>

int main() {
	int a, b, c, d, e, f, g, sum, n = 7;
	scanf("%d %d %d %d %d %d %d", &a, &b, &c, &d, &e, &f, &g);
	sum = a + b + c + d + e + f + g;

	if (a == 0)n--;
	if (b == 0)n--;
	if (c == 0)n--;
	if (d == 0)n--;
	if (e == 0)n--;
	if (f == 0)n--;
	if (g == 0)n--;

	printf("%d %d\n", sum, sum / n);
	return 0;
}