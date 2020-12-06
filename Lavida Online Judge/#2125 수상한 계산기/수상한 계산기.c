#include <stdio.h>

int Reverse(int n) {
	int a, rev_n;
	a = n;
	rev_n = 0;
	while (a != 0) {
		rev_n = (rev_n * 10) + (a % 10);
		a = a / 10;
	}

	return rev_n;
}

int main() {
	int test, n1, n2, rev_n1, rev_n2, sum;
	int sumk, sumk2;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &n1, &n2);

		rev_n1 = Reverse(n1);
		rev_n2 = Reverse(n2);

		sum = 0, sumk = 0;

		sum = rev_n1 + rev_n2;

		if (sum >= 10) {
			while (sum != 0) {
				sumk += (sum % 10);
				sum = sum / 10;
			}
			if (sumk >= 10) {
				sumk2 = 0;
				while (sumk != 0) {
					sumk2 += (sumk % 10);
					sumk = sumk / 10;
				}
				printf("%d\n", sumk2);
			}
			else
				printf("%d\n", sumk);
		}

		else
			printf("%d\n", sum);
	}
	return 0;
}