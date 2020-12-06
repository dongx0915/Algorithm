#include <stdio.h>

int main() {
	long long test, n, m, sum;

	scanf("%lld", &test);
	while (test--) {
		sum = 0;

		scanf("%lld %lld", &n, &m);
		sum = ((n + m) * (m - n + 1)) / 2;

		printf("%lld\n", sum);
	}
	return 0;
}