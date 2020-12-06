#include <stdio.h>

int main() {
	int m, i, res = 0;

	while (1) {
		scanf("%d", &m);
		if (m == 0)
			break;
		else {
			for (res = m, i = 2; i <= 7; ) {
				if (res % i == 0) {
					res /= i;
				}
				if (i == 2)
					i++;
				else
					i += 2;
			}
		}
		printf("%d\n", res);
	}

	return 0;
}