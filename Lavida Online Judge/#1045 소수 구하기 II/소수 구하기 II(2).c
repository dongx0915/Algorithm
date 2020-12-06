#include <stdio.h>

int main() {
	int test, a, b, i, j, ns = 0;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &a, &b);
		ns = 0;
		for (i = a; i <= b; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0)
					break;
			}
			if (j == i)
				ns++;
		}
		printf("%d\n", ns);
	}
	return 0;
}