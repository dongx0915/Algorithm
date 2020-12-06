#include <stdio.h>

int main()
{
	int a, b, c, x, y, z, sum1, sum2, sum3, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d", &a, &b, &c);
		scanf("%d %d %d", &x, &y, &z);

		if (a > x) {
			if((a - x) > 5)
				sum1 = 10 - (a - x);
			if ((a - x) <= 5)
				sum1 = (a - x);
		}
		if (a < x) {
			if ((x - a) > 5)
				sum1 = 10 - (x - a);
			if ((x - a) <= 5)
				sum1 = (x - a);
		}
		if (b > y) {
			if ((b - y) > 5)
				sum2 = 10 - (b - y);
			if ((b - y) <= 5)
				sum2 = (b - y);
		}
		if (b < y) {
			if ((y - b) > 5)
				sum2 = 10 - (y - b);
			if ((y - b) <= 5)
				sum2 = (y - b);
		}
		if (c > z) {
			if ((c - z) > 5)
				sum3 = 10 - (c - z);
			if ((c - z) <= 5)
				sum3 = (c - z);
		}
		if (c < z) {
			if ((z - c) > 5)
				sum3 = 10 - (z - c);
			if ((z - c) <= 5)
				sum3 = (z - c);
		}
		if (a == x)
			sum1 = 0;
		if (b == y)
			sum2 = 0;
		if (c == z)
			sum3 = 0;

		printf("%d\n", sum1 + sum2 + sum3);
	}
	return 0;
}