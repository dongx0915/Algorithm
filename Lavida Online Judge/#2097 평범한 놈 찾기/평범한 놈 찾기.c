#include <stdio.h>

int main() {
	int test, n, s[100] , i, j = 0, sum;
	double avg, temp = 0, k[100] = { 0 }, w;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++)
			scanf("%d", &s[i]);
		for (sum=0,i = 0; i < n; i++) {
			sum += s[i];
		}
		avg =sum / (double)n;
		for (i = 0; i < n; i++) {
			k[i] = avg - (double)s[i];
			if (k[i] < 0) {
				k[i] = -k[i];
			}
		}
		w = k[0];
		for (i = 1; i < n; i++) {
			if (k[i] < w) {
				w = k[i];
				j = i;
			}
		}
		printf("%d\n", s[j]);
	}
	return 0;
}