#include <stdio.h>


int IsPrime(int n) {
	int i;

	if (n <= 1) return 0;
	if (n == 2) return 1;
	if (n % 2 == 0) return 0;

	for (i = 3; i < n; i += 2) {
		if (n % i == 0)
			return 0;
	}
	return 1;
}

int main() {
	int test, n, prime;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		prime = IsPrime((int)n);

		if (prime == 1)
			printf("Prime\n");
		else if (prime == 0)
			printf("Not Prime\n");
	}
	return 0;
}