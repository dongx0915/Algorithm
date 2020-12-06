#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>



int IsPrime(int a, int b) {
	int i, j, prime = 0;

	for (i = a; i <= b; i++) {
		for (j = 2; j < i; j++) {
			if (i % j == 0)
				break;
		}
		if (j == i)
			prime++;
	}
	printf("%d\n", prime);
	return 0;
}

int main() {
	int test, a, b;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &a, &b);

		IsPrime(a, b);
	}
	return 0;
}