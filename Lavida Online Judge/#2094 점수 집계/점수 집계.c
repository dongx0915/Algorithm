#include <stdio.h>

int main() {
	int test, n[100], i, j, temp, k = 0;
	scanf("%d", &test);

	while (test--) {
		for (i = 0; i < 5; i++)
			scanf("%d", &n[i]);
		for (i = 0; i < 4; i++) {
			for (j = i + 1; j < 5; j++) {
				if (n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		k = n[3] - n[1];
		if (k >= 4)
			printf("KIN\n");
		else
			printf("%d\n", (n[1] + n[2] + n[3]));
	}
	return 0;
}