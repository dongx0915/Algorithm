#include <stdio.h>

int main() {
	int test, len, multi, sum, element[100];
	int i, j, k, cnt;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &len, &multi);

		for (i = 0; i < len; i++) scanf("%d", &element[i]);

		for (cnt = 0, i = 0; i < len; i++) {
			for (k = i; k < len; k++) {
				for (sum = 0, j = i; j <= k; j++) {
					sum += element[j];
				}
				if ((sum % multi) == 0) cnt++;
			}
		}
		
		printf("%d\n", cnt);
	}
	return 0;
}