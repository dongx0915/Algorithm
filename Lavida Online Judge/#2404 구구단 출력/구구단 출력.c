#include <stdio.h>

int main() {
	
	int test, i = 1, a;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &a);
		i = 1;
		while (i < 10) {
			printf("%d x %d = %d\n", a, i, a * i);
			i++;
		}
	}
	return 0;
}