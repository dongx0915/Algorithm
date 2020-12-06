#include <stdio.h>

int Reverse(int n) {
	int a, rev_n;
	a = n, rev_n = 0;

	while (a != 0) {
		rev_n = (rev_n * 10) + (a % 10);
		a = a / 10;
	}

	return rev_n;
}

int main() {
	int test, n1, n2, rev_n1, rev_n2, sum, rev_sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &n1, &n2);

		sum = 0, rev_sum = 0;

		rev_n1 = Reverse(n1);
		rev_n2 = Reverse(n2);

		sum = rev_n1 + rev_n2;

		rev_sum = Reverse(sum);

		printf("%d\n", rev_sum);
	}

	return 0;
}