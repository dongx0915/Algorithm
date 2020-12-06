#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int IsPrime(int n) {
	int i, limit;

	if (n <= 1) return 0;
	if (n == 2) return 1;
	if (n % 2 == 0) return 0;

	limit = (int)sqrt((double)n);

	for (i = 3; i <= limit; i += 2) {
		if (n%i == 0) {
			return 0;
		}
	}
	return 1;
}

int main() {
	int test, n, a, r, k = 0;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &a);

		n = a;  r = 0;
		while (a) {
			r = (r * 10) + (a % 10);
			a = a / 10;
		}
		k = n + r;

		IsPrime(k);
		if (IsPrime(k) == 1)
			printf("Prime\n");
		else
			printf("Not Prime\n");
	}
	return 0;
}