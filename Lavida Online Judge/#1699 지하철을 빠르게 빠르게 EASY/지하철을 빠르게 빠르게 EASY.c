#include <stdio.h>

int main() {
	int test, train, money, si[1000], vi[1000], i, temp = 0, min, min_i, min_si;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &train, &money);
		for (i = 0; i < train; i++)
			scanf("%d", &si[i]);
		for (i = 0; i < train; i++)
			scanf("%d", &vi[i]);

		while (money--) {
			for (min_si = 1000000, i = 0; i < train; i++) {
				if (min_si > si[i]) {
					min_si = si[i];                           
					min_i = i;
				}
			}
			si[min_i] += vi[min_i];
		}

		for (min = 1000000, i = 0; i < train; i++) {
			if (min > si[i])
				min = si[i];
		}

		printf("%d\n", min);
	}
	return 0;
}