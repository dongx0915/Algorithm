#include <stdio.h>
#include <math.h>
#pragma warning(disable:4996)

int isPrime(unsigned int x) { // x가 소수이면 1리턴 아니면 0
	unsigned limit, i;

	if (x == 2) return 1; // 2는 소수
	if (x <= 1 || x % 2 == 0) return 0;

	limit = (int)sqrt((double)x);

	for (i = 3; i <= limit; i += 2) {
		if (x % i == 0) return 0;
	}
	return 1;
}

int main() {
	int test, num;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);
		if (isPrime(num) == 1)
			printf("Prime\n");
		else
			printf("Not Prime\n");
	}
	return 0;
}