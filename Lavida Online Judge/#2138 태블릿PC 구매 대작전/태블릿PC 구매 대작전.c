#include <stdio.h>

int main()
{
	int test, pc, s, sum;

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &pc, &s);
		sum = (pc - s);

		if (pc > s) {
			if (sum % 25000 == 0)
				printf("%d\n", sum / 25000);
			else if(sum % 25000 != 0)
				printf("%d\n", (sum / 25000) + 1);
		}
		else if (pc <= s)
			printf("0\n");
	}
	return 0;
}