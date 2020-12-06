#include <stdio.h>

int main()
{
	int test, n, i;

	scanf("%d", &test);

	while (test--)
	{
		scanf("%d", &n);
		i = 1;
		while (i <= 9)
		{
			printf("%d x %d = %d\n", n, i, n*i);
			i++;
		}
	}
	return 0;
}