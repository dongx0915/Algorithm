#include <stdio.h>

int main()
{
	int test, hs, hj, n;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		if (n % 2 == 0 && n != 2) {
			hs = 2;
			hj = n - 2;
			printf("%d %d\n", hs, hj);
		}
		else if (n % 2 != 0 || n == 2) {
			printf("NO\n");
		}
	}
	return 0;
}