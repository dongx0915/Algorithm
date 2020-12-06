#include <stdio.h>

int main() {
	int test, ds1, ds2, hj1, hj2, sumd, sumh;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &ds1, &ds2, &hj1, &hj2);
		if (ds1 == ds2 && hj1 == hj2) {
			if (ds1 > hj1)
				printf("Yoo HJ wins\n");
			if (ds1 < hj1)
				printf("Kim DS wins\n");
			if (ds1 == hj1)
				printf("Draw\n");
		}
		if (ds1 == ds2 && hj1 != hj2)
			printf("Kim DS wins\n");
		if (ds1 != ds2 && hj1 == hj2)
			printf("Yoo HJ wins\n");
		
		sumd = ds1 - ds2;
		sumh = hj1 - hj2;

		if (ds1 != ds2 && hj1 != hj2) {
			if (ds2 > ds1)
				sumd = ds2 - ds1;
			if (hj2 > hj1)
				sumh = hj2 - hj1;
			if (sumd > sumh)
				printf("Yoo HJ wins\n");
			if (sumd < sumh)
				printf("Kim DS wins\n");
			if (sumd == sumh)
				printf("Draw\n");
		}
	}
	return 0;
}