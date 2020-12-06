#include <stdio.h>

int main() {
	int test, m, n[100], i, j, temp = 0, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &m);
		for (i = 0; i < m; i++)
			scanf("%d", &n[i]);
		for (i = 0; i < m - 1; i++) {
			for (j = i + 1; j < m; j++) {
				if (n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		k = n[m - 1] - n[0];
		if (k % 5 == 0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}