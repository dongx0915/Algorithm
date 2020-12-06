#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	int test, len, i;
	double sum, result;
	char num[21];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", num);

		len = strlen(num);
		
		for (result = 0, sum = 0, i = 0; i < len; i++) {
			if (num[i] == '1') {
				result = pow(2, len - 1 - i);
				sum += result;
			}
		}
		printf("%.0lf\n", sum);
	}

	return 0;
}