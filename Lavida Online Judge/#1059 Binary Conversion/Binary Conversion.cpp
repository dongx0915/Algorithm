#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	int test, len;
	double sum;
	char num[21];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", num);

		len = strlen(num);

		sum = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (num[i] == '1') {
				sum += pow(2, len - 1 - i);
			}
		}
		printf("%.0lf\n", sum);
	}
	return 0;
}