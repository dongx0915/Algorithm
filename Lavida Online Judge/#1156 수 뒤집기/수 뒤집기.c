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
	int test, n, rev_n, save, rev2_n, sum, rev_sum;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		rev_n = reverse_int(n);
		sum = n + rev_n;
		rev_sum = reverse_int(sum);

		if (rev_sum == sum)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}