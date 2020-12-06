#include <stdio.h>

int main() {
	int m, n, sum, i;
	while (1) {
		scanf("%d %d", &m, &n);
		if (m == 0 && n == 0)
			break;
		for (i = 1, sum = 0; i <= m; i += 2) {
			sum += i;
		}
		if (sum % n == 0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}