#include <stdio.h>

int main()
{
	int a, b, test;
	char c;

	scanf("%d", &test);
	while (test--)
	{
		scanf("%d %d %c", &a, &b, &c);
		if (c == '+')
			printf("%d\n", a + b);
		else if (c == '-')
			printf("%d\n", a - b);
		else if (c == '*')
			printf("%d\n", a * b);
		else if (c == '/'){
			if (b == 0)
				printf("-9999\n");
			else
				printf("%d\n", a / b);
		}
		else if (c == '/' && a < b)
			printf("%f\n", a / (double)b);
	}
	return 0;
}