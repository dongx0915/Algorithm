#include <stdio.h>

int main() {
	int ps, d[10], i, j, temp = 0, price[1000] = { 0 }, k, s, temp_p = 0;
	scanf("%d", &ps);

	for (k = 0; k < ps; k++) {
		for (i = 0; i < 3; i++) {
			scanf("%d", &d[i]);
		}
		for (i = 0; i < 2; i++) {
			for (j = i + 1; j < 3; j++) {
				if (d[i] > d[j]) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
				}
			}
		}
		if (d[0] == d[2])
			price[k] = 10000 + (d[0] * 1000);
		else if (d[0] == d[1] || d[1] == d[2])
			price[k] = 1000 + (d[1] * 100);
		else if (d[0] != d[1] && d[1] != d[2])
			price[k] = d[2] * 100;
	}
	s = price[0];
	for (k = 0; k < ps; k++) {
		if (price[k]>s) {
			s = price[k];
		}
	}
	printf("%d\n", s);
	return 0;
}