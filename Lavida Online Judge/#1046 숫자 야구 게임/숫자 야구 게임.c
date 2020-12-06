#include <stdio.h>

int main() {
	int test, stk_cnt = 0, bal_cnt = 0, i ,j;
	char sol[10], answer[10];

	scanf("%d", &test);

	while (test--) {
		scanf("%s %s", sol, answer);
		stk_cnt = 0, bal_cnt = 0;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (answer[i] == sol[j]) {
					if (i == j)
						stk_cnt++;
					else
						bal_cnt++;
				}
			}
		}
		printf("%dS %dB\n", stk_cnt, bal_cnt);
	}

	return 0;
}