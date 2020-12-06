#include <stdio.h>
#include <math.h>

int main()
{
	int a, b, c, d, test;
	scanf("%d", &test);

	while (test--)
	{
		scanf("%d %d %d %d", &a, &b, &c, &d);
		if (pow(a, b) > pow(c, d))
		{
			printf("%d^%d\n", a, b);
		}
		else if (pow(a, b) < pow(c, d))
		{
			printf("%d^%d\n", c, d);
		}
		else if (pow(a, b) == pow(c, d))
		{
			printf("SAME\n");
		}
	}
	return 0;
}