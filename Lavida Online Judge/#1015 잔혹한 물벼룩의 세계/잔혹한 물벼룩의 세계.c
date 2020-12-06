#include <stdio.h>

void cnt_day(int n) {
	int day = 0;
	while (n != 1) {
		if (n % 2 == 0)
			n = n / 2;
		else
			n = 3 * n + 1;
		day++;
	}
	printf("%d\n", day);
}

int main() {
	int test, n;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		cnt_day(n);
	}
	return 0;
}