#include <stdio.h>

int cnt_day(int n) {
	int day = 0;
	while (n != 1) {
		if (n % 2 == 0)
			n = n / 2;
		else
			n = 3 * n + 1;
		day++;
	}
	return day;
}

int main() {
	int test, n, day;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		printf("%d\n", cnt_day(n));
	}
	return 0;
}