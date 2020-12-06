#include <stdio.h>

int main() {
	int m, n, k, i, sum;

	while (1) {
		scanf("%d %d %d", &m, &n, &k);
		if (m == 0 && n == 0 && k == 0)
			break;
		for (i = m, sum = 0; i <= n; i++) {
			sum += i;
		}

		if (sum % k == 0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}