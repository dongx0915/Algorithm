#include <stdio.h>

int main()
{ 
	int test, a, b, c, d, root, sum;

	scanf("%d", &test);

	while(test--){
		scanf("%d %d %d %d", &a, &b, &c, &d);
		root = a*c - b*d;
		sum = a*d + b*c;
		printf("%d %d\n", root, sum);
	}

	return 0;
}