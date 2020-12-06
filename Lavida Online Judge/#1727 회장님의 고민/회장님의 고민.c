#include <stdio.h>

int main() {
	int x1, x2, y1, y2, z1, z2, i, j, test, num, cnt = 0;
	double L[3], k[3], temp = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &x1, &x2);
		scanf("%d %d", &y1, &y2);
		scanf("%d %d", &z1, &z2);

		L[0] = (double)x2 / (double)x1;
		L[1] = (double)y2 / (double)y1;
		L[2] = (double)z2 / (double)z1;

		k[0] = L[0];
		k[1] = L[1];
		k[2] = L[2];

		for (i = 0; i < 2; i++) {
			for (j = i + 1; j < 3; j++) {
				if (k[i] > k[j]) {
					temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}

		for (cnt = 0, num = 0, i = 0; i < 3; i++) {
			if (cnt == 0 && k[2] == L[i]) {
				num = i + 1;
				cnt++;
			}
		}

		printf("%d\n", num);
	}
	return 0;
}