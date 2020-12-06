#include <stdio.h>

int reverse_int(int n) {
	int rev_n = 0;
	while (n != 0) {
		rev_n = (rev_n * 10) + (n % 10);
		n = n / 10;
	}
	return rev_n;
}

int main() {
	int test, n, rev_n;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		rev_n = reverse_int(n);

		if (n > rev_n)
			printf("%d\n", n);
		else
			printf("%d\n", rev_n);
	}
	return 0;
}