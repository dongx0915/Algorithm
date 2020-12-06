#include <stdio.h>

int main() {
	int m, n[1000], i, j, temp = 0, k = 0;
	while (1) {
		scanf("%d", &m);
		if (m == 0)
			break;
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
		if (k % 2 == 0)
			printf("Yes\n");
		else
			printf("No\n");
	}
	return 0;
}