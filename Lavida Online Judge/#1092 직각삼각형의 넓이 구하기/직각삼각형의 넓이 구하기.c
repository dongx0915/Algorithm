#include <stdio.h>

int main() {
	int test, a, b, c, n[1000], i, j, temp = 0;
	scanf("%d", &test);

	while (test--) {
		for (i = 0; i < 3; i++) {
			scanf("%d", &n[i]);
		}
		for (i = 0; i < 2; i++) {
			for (j = i + 1; j < 3; j++) {
				if (n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		a = n[0];
		b = n[1];
		c = n[2];
		if ((a + b) <= c) {
			printf("-1\n");
		}
		else if ((a + b) > c) {
			if ((a * a) + (b * b) == (c * c))
				printf("%.2f\n", ((double)a * (double)b) / (double)2);
			else if ((a * a) + (b * b) != (c * c))
				printf("-2\n");
		}
	}
	return 0;
}