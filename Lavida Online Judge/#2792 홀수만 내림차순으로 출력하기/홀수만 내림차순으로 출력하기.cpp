#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, n, i, j, cnt;
	int num[100];

	scanf("%d", &test);
	while (test--) {
		int save_num[100];
		scanf("%d", &n);

		for (cnt = 0, i = 0; i < n; i++) {
			scanf("%d", &num[i]);
			if (num[i] > 0 && num[i] % 2 != 0) {
				save_num[cnt] = num[i];
				cnt++;
			}
		}

		sort(save_num, save_num + cnt);
		if (cnt == 0) printf("None\n");
		else {
			for (i = cnt - 1; i >= 0; i--) {
				printf("%d ", save_num[i]);
			}
			printf("\n");
		}
	}
	return 0;
}