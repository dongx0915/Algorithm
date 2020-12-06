#include <stdio.h>

int main() {
	int test, n, rev_n, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		rev_n = 0;
		k = n;
		while (k != 0) {
			rev_n = (rev_n * 10) + (k % 10);
			k = k / 10;
		}

		if (n > rev_n)
			printf("%d\n", n);
		else
			printf("%d\n", rev_n);
	}

	return 0;
}