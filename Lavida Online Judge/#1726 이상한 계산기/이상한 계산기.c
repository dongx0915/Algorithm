#include <stdio.h>

int main() {
	int test, num1, num2, sum1, sum2, sumk = 0, sum3 = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &num1, &num2);
		sumk = 0, sum3 = 0;
		for (sum1 = 0; num1 != 0; ) {
			sum1 += num1 % 10;
			num1 = num1 / 10;
		}

		for (sum2 = 0; num2 != 0; ) {
			sum2 += num2 % 10;
			num2 = num2 / 10;
		}

		sumk = sum1 + sum2;

		if (sumk >= 10) {
			while (sumk != 0) {
				sum3 += sumk % 10;
				sumk = sumk / 10;
			}
		}

		printf("%d\n", sum3);
	}
}