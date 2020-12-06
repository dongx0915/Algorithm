#include <stdio.h>

void top(int n) {
	int i, j;
	n = n / 2;

	for (i = 0; i < n; i++) {
		for (j = n; j > i; j--)
			printf(" ");
		for (j = 0; j < 2 * i + 1; j++) {
			if (j == 0 || j == 2 * i)
				printf("$");
			else
				printf(" ");
		}
		printf("\n");
	}
}

void middle(int n) {
	for (int i = 0; i < n; i++) {
		if (i == 0 || i == n - 1)
			printf("$");
		else
			printf(" ");
	}
	printf("\n");
}

void bottom(int n) {
	int i, j;
	n = n / 2;

	for (i = n; i > 0; i--) {
		for (j = n; j >= i; j--)
			printf(" ");
		for (j = 0; j < 2 * i - 1; j++) {
			if (j == 0 || j == 2 * i - 2)
				printf("$");
			else
				printf(" ");
		}
		printf("\n");
	}
}


int main() {
	int test, n;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		if (n % 2 == 0)
			n++;
		top(n);
		middle(n);
		bottom(n);
	}
	return 0;
}