#include <stdio.h>
#include <math.h>

int main() {
	int test, i, j, k;
	double sum[10], result;
	char IP[33];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", IP);

		result = 0;
		for (i = 0; i < 4; i++)
			sum[i] = 0;
		for (j = 0, k = 0, i = 0; IP[i] != '\0'; i++, k++) {
			if (IP[i] == '1') {
				result = pow(2, 7 -  k);
				if (k <= 7) 
					sum[j] += result;
			}
			if (k == 7)
				j++, k = -1;
		}
		printf("%.0lf.%.0lf.%.0lf.%.0lf\n", sum[0], sum[1], sum[2], sum[3]);
	}
	return 0;
}