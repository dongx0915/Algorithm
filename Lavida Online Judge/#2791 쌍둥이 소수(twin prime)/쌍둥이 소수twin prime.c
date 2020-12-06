#include <stdio.h>
#include <math.h>

int IsPrime(int n) {
	int i, limit;

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
	int m, n, a[1000], i, j, cnt, k, temp = 0;

	while (1) {
		scanf("%d %d", &m, &n);
		if (m == 0 && n == 0)
			break;
		if (n < m) {
			temp = m;
			m = n;
			n = temp;
		}
		for (j = 0, cnt = 0, i = m; i <= n; i++) {
			if (i + 2 <= n) {
				if (IsPrime(i) == 1 && IsPrime(i + 2) == 1) {
					a[j] = i;
					j++;
					cnt++;
				}
			}
		}
		if (cnt == 0)
			printf("No Twin Primes!\n");
		else {
			for (j = 0, k = 1; k <= cnt; k++, j++) {
				printf("%d:(%d,%d)\n", k, a[j], a[j] + 2);
			}
		}
	}
	return 0;
}