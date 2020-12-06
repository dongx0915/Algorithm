#include <stdio.h>

int main() {
	int test, n;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		if (n <= 2)
			printf("-1\n");
		else
			printf("%d\n", n - 2);
	}
	return 0;
}