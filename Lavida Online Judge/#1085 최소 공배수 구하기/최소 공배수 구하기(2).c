#include <stdio.h>

int main() {
	long long test, a, b, k, i, gcd, x, y, lcm;
	scanf("%lli", &test);

	while (test--)
	{
		scanf("%lli %lli", &a, &b);
		x = a; y = b; k = 0;
		if (x == 0 || y == 0) {
			printf("0\n");
		}
		else {
			for (k = a % b, i = k; i > 0;) {
				k = a % b;
				a = b;
				b = k;
				if (k == 0) {
					gcd = a;
					break;
				}
			}
			printf("%lli\n", (x * y) / gcd);
		}
	}
	return 0;
}