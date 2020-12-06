#include <stdio.h>

int main() {
	int test, sum, pr, day, i;
	scanf("%d", &test);

	while (test--) {
		
		scanf("%d", &pr);
		day = 0, i = 5000, sum = 0;
		while (sum < pr) {
			sum += i;
			day++;
			if (day % 10 == 0)
				i += 200;
				
		}
		printf("%d\n", day);
	}
	return 0;
}