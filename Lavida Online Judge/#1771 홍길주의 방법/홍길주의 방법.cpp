#include <stdio.h>

int main() {
	int test;
	double num;

	scanf("%d", &test);
	while (test--) {
		scanf("%lf", &num);
		printf("begin\n");
		num /= 2;
		printf("%.1lf\n", num);
		for (int i = 1; i < num; i++) {
			num -= i;
			printf("%.1lf\n", num);

		}
		printf("%.0lf\n", num * 2);
		printf("end\n");
	}
	return 0;
}