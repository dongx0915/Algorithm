#include <stdio.h>

int main()
{
	int j1, j2, j3, m1, m2, m3, test, mg = 0, ja = 0, j = 0, m = 0;
	scanf("%d", &test);
	while (test--)
	{
		ja = mg = j = m = 0;
		scanf("%d %d %d %d %d %d", &j1, &j2, &j3, &m1, &m2, &m3);
		
		if (j1 % 2 == 1)j++;
		if (j2 % 2 == 1)j++;
		if (j3 % 2 == 1)j++;
		if (m1 % 2 == 1)m++;
		if (m2 % 2 == 1)m++;
		if (m3 % 2 == 1)m++;

		ja = (j1 + j2 + j3);
		mg = (m1 + m2 + m3);

		if (ja > mg)
			printf("Joo-Ahn wins\n");
		else if (ja < mg)
			printf("Min-Gwang wins\n");
		else if (ja == mg) {
			if (j > m)
				printf("Joo-Ahn wins\n");
			else if (j < m)
				printf("Min-Gwang wins\n");
			else if(j == m)
				printf("Draw\n");
		}
	}
	return 0;
}