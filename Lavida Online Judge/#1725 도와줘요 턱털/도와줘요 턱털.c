#include <stdio.h>

int main() {
	int x, y, test;

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &x, &y);

		if (x >= 200 && x <= 300 && y >= 100 && y <= 200)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}