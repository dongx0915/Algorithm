#include <stdio.h>

int main() {
	long long int  n, m, sum;
	int test;
	scanf("%d", &test);

	while (test--) {
		scanf("%lld %lld", &n, &m);
		for (sum = 0; n <= m; n++) {
			sum += n;
		}
		printf("%lld\n", sum);
	}
	return 0;
}