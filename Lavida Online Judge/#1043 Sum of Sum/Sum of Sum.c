#include <stdio.h>

int main() {
	int test, n, i,k ,sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		sum = 0;
		for (k = 1; k <= n; k++) {
			for (i = 1; i <= k; i++) {
				sum += i;
			}
		}
		printf("%d\n", sum);
	}
	return 0;
}