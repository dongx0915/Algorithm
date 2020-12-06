#include <stdio.h>

int main() {
	int test, ki = 0, a, b;
	double rm = 0, k, ad, bd;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &a, &b);
		ad = (double)a;
		bd = (double)b;

		for (k = 0; bd > ad; ) {
			bd = bd / ad;
			k++;
		}
		if ( bd != 0)
			k += 0.5;

		ki = k;
		if (k > ki)
			printf("%d\n", ki);
		else if (k == ki)
			printf("%d\n", ki - 1);
	}

	return 0;
}