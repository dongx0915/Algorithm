#include <stdio.h>

int main() {
	int test, n, k[100], i, j, temp = 0, sum = 0;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++)
			scanf("%d", &k[i]);

		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (k[i] > k[j]) {
					temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		sum = k[n - 1] - k[0];
		if (sum % 5 == 0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}