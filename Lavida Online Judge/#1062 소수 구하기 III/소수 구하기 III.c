#include <stdio.h>
#include <math.h>
#include <stdlib.h>

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
	int test, a, b, prime, i, cnt = 0;

	scanf("%d", &test);

	while (test--) {
		cnt = 0;
		scanf("%d %d", &a, &b);
		for (i = a; i <= b; i++) {
			prime = IsPrime(i);
			if (prime == 1) cnt++;
		}
		printf("%d\n", cnt);
	}
	return 0;
}