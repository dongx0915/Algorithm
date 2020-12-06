#include <stdio.h>
#include <math.h>

int main() {
	int test, n, i;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);

		if (n < 0 || n > 30)
			printf("Impossible\n");
		else
			printf("%.0f\n", pow(2, n));
	}
	return 0;
}