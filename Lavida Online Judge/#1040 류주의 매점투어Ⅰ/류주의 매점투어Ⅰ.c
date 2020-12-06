#include <stdio.h>

int main()
{
	int money, sum, sum2, sum3, sum4, sum5, test;
	
	scanf("%d", &test);
	while(test--){
	
	scanf("%d", &money);
	
	sum = money / 10000;
	sum2 = (money % 10000) / 5000;
	sum3 = (money % 5000) / 1000;
	sum4 = (money % 1000)/ 500;
	sum5 = (money % 500) / 100;
	printf("%d %d %d %d %d\n", sum, sum2, sum3, sum4, sum5);
	}
	return 0;
}