#include <stdio.h>

int main()
{
	int X;
	scanf("%d", &X);

	if (X == 100)
		printf("A++\n");
	else if (X >= 97)
		printf("A+\n");
	else if (X >= 93)
		printf("A\n");
	else if (X >= 90)
		printf("A-\n");
	else if (X >= 87)
		printf("B+\n");
	else if (X >= 83)
		printf("B\n");
	else if (X >= 80)
		printf("B-\n");
	else if (X >= 77)
		printf("C+\n");
	else if (X >= 73)
		printf("C\n");
	else if (X >= 70)
		printf("C-\n");
	else if (X >= 67)
		printf("D+\n");
	else if (X >= 63)
		printf("D\n");
	else if (X >= 60)
		printf("D-\n");
	else if (X < 60)
		printf("F\n");

	return 0;
}