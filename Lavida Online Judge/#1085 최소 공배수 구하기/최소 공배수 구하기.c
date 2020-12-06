#include <stdio.h>

int main() {
	int test;
	long long a, b, x = 0, y = 0, k, gcd = 0;
	scanf("%d", &test);

	while (test--) {
		scanf("%lld %lld", &a, &b);
		x = a; y = b;
		if (a == 0 || b == 0)
			printf("0\n");
		else {
			while (1) {
				k = a % b;
				a = b;
				b = k;
				if (k == 0) {
					gcd = a;
					break;
				}
			}

			printf("%lld\n", (x * y) / gcd);
		}
	}
	return 0;
}