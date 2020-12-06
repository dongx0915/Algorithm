#include <stdio.h>

int main() {
	int test, ds1, ds2, hj1, hj2, sumd, sumh;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &ds1, &ds2, &hj1, &hj2);
		sumd = (ds1 + ds2);
		sumh = (hj1 + hj2);
		if (sumd > sumh)
			printf("Kim DS wins\n");
		if (sumh > sumd)
			printf("Yoo HJ wins\n");
		if (sumd == sumh)
			printf("Draw\n");

	}
	return 0;
}