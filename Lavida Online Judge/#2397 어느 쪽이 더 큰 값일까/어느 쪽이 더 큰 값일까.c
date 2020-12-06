#include <stdio.h>
#include <math.h>

int main() {
	int test, a, b, c, d;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &a, &b, &c, &d);

		if (pow(a, b) == pow(c, d))
			printf("SAME\n");
		else if (pow(a, b) > pow(c, d))
			printf("%d^%d\n", a, b);
		else
			printf("%d^%d\n", c, d);
	}
	return 0;
}