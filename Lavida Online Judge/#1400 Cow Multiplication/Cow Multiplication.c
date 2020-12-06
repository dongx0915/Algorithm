#include <stdio.h>

int main() {
	int a, b, i, j, cnt_a, cnt_b, sum;
	int na[11], nb[11];

	scanf("%d %d", &a, &b);

	for (cnt_a = 0, i = 0; ; i++, cnt_a++) {
			na[i] = a % 10;
			a = a / 10;
			if (a == 0)
				break;
	}

	for (cnt_b = 0, i = 0; ; i++, cnt_b++) {
		nb[i] = b % 10;
		b = b / 10;
		if (b == 0)
			break;
	}

	for (sum = 0, i = cnt_a; i >= 0; i--)
		for (j = cnt_b; j >= 0; j--) {
			sum += na[i] * nb[j];
		}

	printf("%d\n", sum);

	return 0;
}