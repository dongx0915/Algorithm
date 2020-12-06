#include <stdio.h>

void top(int n) {
	for (int i = 0; i < n / 2; i++) {
		for (int j = n / 2; j > i; j--)
			printf(" ");
		for (int k = 0; k < 2 * i + 1; k++) {
			if (k == 0 || k == 2 * i)
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
	for (int i = n / 2; i > 0; i--) {
		for (int j = n / 2; j >= i; j--)
			printf(" ");
		for (int k = 0; k < 2 * i - 1; k++) {
			if (k == 0 || k == 2 * i - 2)
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