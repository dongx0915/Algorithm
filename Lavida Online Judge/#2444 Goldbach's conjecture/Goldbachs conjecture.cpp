#include <stdio.h>
#include <math.h>
#include <iostream>
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
	int num, i;
	prime_init();

	while (1) {
		scanf("%d", &num);
		if (num == 0)
			break;

		for (i = 3; i <= num; i++) {
			if (!b[i] && !b[num - i]) break;
		}
		printf("%d = %d + %d\n", num, i, num - i);
	}
	return 0;
}