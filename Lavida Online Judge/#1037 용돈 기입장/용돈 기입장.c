#include <stdio.h>

int main()
{
	int test, n, m, c, k;
	scanf("%d", &test);

	while(test--){
		scanf("%d", &n);
		c = n;
		k = 0;
		while(n > 0){
			scanf("%d", &m);
			k = k + m;
			n--;
		}
		printf("%d %d\n", k, k/c);
	}
	
	
	return 0;
}