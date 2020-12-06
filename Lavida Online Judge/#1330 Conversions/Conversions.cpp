#include <stdio.h>
#include <string.h>

int main() {
	int test;
	double weight;
	char type[10];

	scanf("%d", &test);
	int cnt = test;
	while (test--) {
		scanf("%lf %s", &weight, type);
		printf("%d ", cnt - test);
		if (!strcmp(type, "kg")) {
			printf("%.4lf lb\n", weight * 2.2046);
		}
		else if (!strcmp(type, "l")) {
			printf("%.4lf g\n", weight * 0.2642);
		}
		else if (!strcmp(type, "lb")) {
			printf("%.4lf kg\n", weight * 0.4536);
		}
		else if (!strcmp(type, "g")) {
			printf("%.4lf l\n", weight * 3.7854);
		}
	}
	return 0;
}