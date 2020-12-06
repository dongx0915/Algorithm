#include <stdio.h>

int main() {
	int test, n[1000], m, i, j, temp = 0;
	scanf("%d", &test);

	while (test--)
	{
		scanf("%d", &m);
		temp = 0;
		for (i = 0; i < m; i++) {
			scanf("%d", &n[i]);
		}
		for (i = 0; i < m-1; i++) {
			for (j = i + 1; j < m; j++) {
				if (n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		if ((n[m-1] - n[0]) % 5 == 0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}