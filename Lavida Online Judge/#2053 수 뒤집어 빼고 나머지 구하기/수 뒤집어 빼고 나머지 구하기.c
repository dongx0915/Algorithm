#include <stdio.h>

int main() {
	int test, n, rev_n, a = 0;
	int minus = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		a = n;
		rev_n = 0;
		while (a != 0) {
			rev_n = (rev_n * 10) + (a % 10);
			a = a / 10;
		}

		if (n == rev_n)
			printf("SAME\n");

		else if (n > rev_n) {
			minus = n - rev_n;
			printf("%d\n", minus % 51);
		}
		else {
			minus = rev_n - n;
			printf("%d\n", minus % 51);
		}
	}

	return 0;
}