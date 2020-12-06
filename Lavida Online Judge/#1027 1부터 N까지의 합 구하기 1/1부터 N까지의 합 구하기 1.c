#include <stdio.h>

int main() {
	int test, n, i, sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 1, sum = 0; i <= n; i++) {
			sum += i;
		}
		printf("%d\n", sum);
	}
	return 0;
}