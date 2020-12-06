#include <stdio.h>

int main() {
	int test, chocolate;
	scanf("%d", &test);

	while (test--) {
		int get = 0;
		scanf("%d", &chocolate);

		get = chocolate / 2;
		if (chocolate == get + 1) printf("T_T\n");
		else printf("%d\n", get + 1);
	}
	return 0;
}