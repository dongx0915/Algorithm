#include <stdio.h>

int main() {
	int test, a, b, k, i;
	scanf("%d", &test);

	while (test--)
	{
		scanf("%d %d", &a, &b);
		while(1){
			k = a % b;
			a = b;
			b = k;
			if (k == 0) {
				printf("%d\n", a);
				break;
			}
		}
	}
	return 0;
}