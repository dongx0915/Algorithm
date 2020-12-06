#include <stdio.h>

int main() {
	int n[7], i, sum;
	double avg = 0;

	for (sum = 0, i = 0; i < 7; i++) {
		scanf("%d", &n[i]);
		sum += n[i];
	}
	avg = (double)sum / 7.0;

	printf("%.2lf\n", avg);

	return 0;
}