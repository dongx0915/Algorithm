#include <stdio.h>

int main() {
	int test, price, sum, day, i;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &price);
		day = 0;
		for (sum = 0, i = 3000; sum < price; i += 50) {
			day++;
			sum += i;
		}
		if (day > 100)
			printf("NO\n");
		else
			printf("%d\n", day);
	}
	return 0;
}