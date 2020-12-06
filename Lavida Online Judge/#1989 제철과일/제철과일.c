#include <stdio.h>
#include <stdlib.h>

typedef struct Fruit {
	int start;
	int end;
	char fruit[20];
}fruit;

int main() {
	int num, count[12] = { 0 }, i, j;
	fruit *pf;

	scanf("%d", &num);

	pf = (fruit *)malloc(num * sizeof(fruit));

	for (i = 0; i < num; i++) {
		scanf("%s %d %d", pf[i].fruit, &pf[i].start, &pf[i].end);

		for (j = pf[i].start; j <= pf[i].end; j++) {
			count[j - 1]++;
		}
	}

	for (i = 0; i < 12; i++)
		printf("%d월 : %d가지\n", i + 1, count[i]);

	return 0;
}