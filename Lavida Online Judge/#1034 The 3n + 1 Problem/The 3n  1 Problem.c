#include <stdio.h>

int cnt_day(int n) {
	int day = 1;

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
	int m, n, save_n, save_m, temp, return_day, i, k, max_day;

	while (scanf("%d %d", &m, &n) != EOF) {
		save_n = n;
		save_m = m;

		if (m > n) {
			temp = n;
			n = m;
			m = temp;
		}

		for (max_day = 0, i = m; i <= n; i++) {
			return_day = cnt_day(i);

			if (max_day < return_day)
				max_day = return_day;
		}
		printf("%d %d %d\n", save_m, save_n, max_day);
	}
	return 0;
}