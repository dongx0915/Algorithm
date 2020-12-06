#include <stdio.h>

int main()
{
	int n, m;
	while (1) {
		scanf("%d %d", &n, &m);

		if (n == 0 && m == 0)
			break;
		else if (n % m != 0) {
			printf("%d\n", n % m);
		}
		else if (n % m == 0) {
			printf("multiple\n");
		}
	}
	return 0;
}