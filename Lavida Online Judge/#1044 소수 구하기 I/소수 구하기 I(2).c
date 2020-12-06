#include <stdio.h>

int main() {
	int test, n, i;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		if (n == 2)
			printf("Prime\n");
		else {
			for (i = 2; i < n; i++) {
				if (n % i == 0) {
					printf("Not Prime\n");
					break;
				}
			}
			if (i == n) {
				printf("Prime\n");
			}
		}
	}
	return 0;
}