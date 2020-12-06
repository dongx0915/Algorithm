#include <stdio.h>

int main() {
	int ps[100], sum, i;
	double avg;

	for(i = 0; i < 7; i++){
		scanf("%d", &ps[i]);
	}
	for (sum = 0, i = 0; i < 7; i++) {
		sum += ps[i];
	}

	avg = (double)sum / (double)7;

	printf("%d\n", sum);
	printf("%.0lf\n", avg);

	return 0;
}