#include <stdio.h>

int main() {
	int test, m[1000], i, j, n, temp = 0, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		for(i = 0; i < n; i++){
			scanf("%d", &m[i]);
		}
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (m[i] > m[j]) {
					temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
			}
		}
		k = m[i] - m[0];
		if (k != 0) {
			if (m[i] % k == 0 && m[0] % k == 0)
				printf("YES\n");
			else
				printf("NO\n");
		}
		else
			printf("NO\n");
	}
	return 0;
}