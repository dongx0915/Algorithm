#include <stdio.h>

int num[100];

int Findint(int n, int find_num) {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		if (num[i] == find_num) cnt++;
	}
	return cnt;
}

int main() {
	int test, n, find_num, num_cnt = 0;
	int i, j;
	scanf("%d", &test);
	while (test--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++) {
			scanf("%d", &num[i]);
		}

		scanf("%d", &find_num);
		
		num_cnt = Findint(n, find_num);

		if (num_cnt == 0) printf("None\n");
		else printf("%d\n", num_cnt);
	}

	return 0;
}