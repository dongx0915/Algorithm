#include <stdio.h>

int main() {
	int test, m, k;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &m);
		for (k =0; m > 1; k++) {
			if (m % 2 != 0) 
				m = (m * 3) + 1;
			else if (m % 2 == 0) 
				m /= 2;
			else if(m == 1)
				break;
		}
		printf("%d\n", k);
	}
	return 0;
}