#include <stdio.h>
#include <math.h>
#pragma warning(disable:4996)
const int LIMIT = 100001;
bool b[LIMIT] = { 1, 1, 0 };

void prime_init() {
	int i, j;
	int  sqrtlimit = (int)sqrt((double)LIMIT);

	for (i = 2; i <= sqrtlimit; i++) {
		if (!b[i]) {
			for (j = i * i; j < LIMIT; j = j + i) {
				b[j] = 1;
			}
		}
	}
}

int main() {
	int test, n1, n2, prime_cnt, i;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &n1, &n2);
		if (n1 > n2) {
			int temp;
			temp = n1;
			n1 = n2;
			n2 = temp;
		}
		prime_init();

		for (prime_cnt = 0, i = n1; i <= n2; i++) {
			if (b[i] == 0)
				prime_cnt++;
		}

		printf("%d\n", prime_cnt);
	}
	return 0;
}