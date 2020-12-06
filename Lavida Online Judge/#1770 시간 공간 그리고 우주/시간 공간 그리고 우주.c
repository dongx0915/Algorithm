#include <stdio.h>

int main() {
	int test, h, m;
	double h1, m1;
	scanf("%d", &test);

	while (test--) {
		scanf("%d : %d", &h, &m);
		h1 = ((h * 60) * 0.5) + (m * 0.5);
		m1 = (m * 6);

		printf("%.1f %.1f\n", h1, m1);
	}
	return 0;
}