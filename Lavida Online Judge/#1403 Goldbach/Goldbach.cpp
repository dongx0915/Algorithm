#include <stdio.h>
#include <math.h>
#include <iostream>
#pragma warning(disable:4996)
const int LIMIT = 1000001;
bool b[LIMIT] = { 1, 1, 0 };

void prime_init() {
	int i, j;
	int sqrtlimit = (int)sqrt((double)LIMIT);
	for (i = 2; i <= sqrtlimit; i++) {
		if (!b[i]) {
			for (j = i * i; j < LIMIT; j = j + i) {
				b[j] = 1;
			}
		}
	}
}

int main() {
	int num, i, cnt;
	prime_init();

	while (1) {
		scanf("%d", &num);
		if (num == 0)
			break;

		for (cnt = 0, i = 3; i <= num; i++) {
			if (i > num - i) break;
			else if (!b[i] && !b[num - i]) cnt++;
		}
		printf("%d\n", cnt);
	}
	return 0;
}