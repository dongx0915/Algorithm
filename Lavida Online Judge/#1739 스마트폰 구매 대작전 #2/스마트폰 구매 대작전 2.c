#include <stdio.h>

int main() {
	int test, price, day, money, sum, i, j;
	double dv_i;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &price);
		sum = 0, day = 0, money = 5000, i = 0, j = 1;
		
		while (sum < price) {
			sum += money;
			day++;
			i++;
			dv_i = (double)i / 10;
			if (dv_i == (double)j) {
				money += 500;
				i = 0;
				j++;
			}
		}
		printf("%d\n", day);
	}
	return 0;
}