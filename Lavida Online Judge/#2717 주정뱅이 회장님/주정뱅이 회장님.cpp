#include <stdio.h>

int main() {
	int n;
	double alchol, sum = 0;

	scanf("%d", &n);

	for (int k = 0; k < 5; k++) {
		double max = 0;
		for (int i = 0; i < n; i++) {
			scanf("%lf", &alchol);
			if (max < alchol) max = alchol;
		}
		sum += max;
	}
	printf("%.3lf\n", sum);
	return 0;
}