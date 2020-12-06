#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, n, num[50], save[50], save_i[50];
	int i, j, cnt, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		cnt = n;
		for (i = 0; i < n; i++) {
			scanf("%d", &num[i]);
			save[i] = num[i];
		}

		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (num[i] == save[j]) {
					save[j] = 0;
				}
			}
		}

		sort(save, save + n);
		for (i = 0; i < n; i++) {
			if (save[i] == 0) continue;
			else {
				printf("%d", save[i]);
				if (i != n - 1)
					printf(" ");
			}
		}
		printf("\n");
	}
	return 0;
}