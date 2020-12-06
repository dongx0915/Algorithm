#include <stdio.h>

int main() {
	int n, i, sum, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		for (i = 1, sum = 1; i <= n; i++) {
			if (sum % i == 0)
				sum = sum / i;
			else
				sum *= i;
		}
		printf("%d\n", sum);
	}
	return 0;
}