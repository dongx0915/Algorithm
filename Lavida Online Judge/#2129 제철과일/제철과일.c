#include <stdio.h>
#include <stdlib.h>

int main() {
	int num, season[12] = { 0 };
	int start, end;
	char fruit[11];

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%s %d %d", fruit, &start, &end);
		for (int j = start - 1; j <= end - 1; j++) {
			season[j]++;
		}
	}

	for (int i = 0; i < 12; i++) {
		printf("%d월 : %d가지\n", i + 1, season[i]);
	}

	return 0;
}