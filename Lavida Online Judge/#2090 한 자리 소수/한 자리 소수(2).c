#include <stdio.h>

int main() {
	int m, i, res = 0;

		while (1) {
			scanf("%d", &m);
			if (m == 0)
				break;
			else if (m % 2 == 0) {
				res = m / 2;
				for (i = 3; i <= 7; i += 2) {
					if (res % i == 0)
						res /= i;
				}
			}
			else {
				for (res = m, i = 3; i <= 7; i += 2) {
					if (res % i == 0) {
						res /= i;
					}
				}
			}
			printf("%d\n", res);
		}

	return 0;
}