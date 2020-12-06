#include <stdio.h>
#include <math.h>
#pragma warning(disable:4996)

int isPrime(unsigned int x) { // x가 소수이면 1리턴 아니면 0
	unsigned limit, i;

	if (x == 2) return 1; // 2는 소수
	if (x <= 1 || x % 2 == 0) return 0;

	limit = (int)sqrt((double)x);

	for (i = 3; i <= limit; i += 2) {
		if (x % i == 0) return 0;
	}
	return 1;
}

int main() {
	int test, a, b, prime_cnt, i;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &a, &b);

		for (prime_cnt = 0, i = a; i <= b; i++) {
			if (isPrime(i) == 1)
				prime_cnt++;
		}
		printf("%d\n", prime_cnt);
	}
	return 0;
}