#include <stdio.h>
#include <math.h>

int IsPrime(long long n) {
	long long i, limit;

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
	int test;
	long long a;
	scanf("%d", &test);

	while (test--) {
		scanf("%lld", &a);
		if (IsPrime(a) == 1)
			printf("Prime\n");
		else
			printf("Emirp\n");
	}
	return 0;
}