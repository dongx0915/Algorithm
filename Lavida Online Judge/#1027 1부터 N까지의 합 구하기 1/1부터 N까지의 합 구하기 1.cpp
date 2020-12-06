#include <stdio.h>
//-----------------------------------------
//----------------------------------------
int main(void)
{
	int test;
	scanf("%d", &test);
	while (test--)
	{
		int n, m, sum;
		scanf("%d", &n);
		m = 1;
		sum = 0;

		while (m <= n)
		{
			sum += m;
			m++;
		}

		printf("%d\n", sum);
	}
	return 0;
}