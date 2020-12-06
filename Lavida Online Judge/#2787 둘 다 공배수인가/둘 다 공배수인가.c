#include <stdio.h>

int main() {
	int m, n, d1, d2, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &m, &n, &d1, &d2);
		if (m % d1 == 0 && m % d2 == 0)
			printf("YES\n");
		if (m % d1 != 0 || m % d2 != 0)
			printf("NO\n");
	}
	return 0;
}