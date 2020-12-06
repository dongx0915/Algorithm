#include <stdio.h>

int main()
{
	int s1, s2, c1, c2, test;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d %d %d", &s1, &s2, &c1, &c2);
		if ((s1 == s2) && (c1 != c2))
			printf("Park wins\n");
		else if ((s1 != s2) && (c1 == c2))
			printf("Shin wins\n");
		else if ((s1 == s2) && (c1 == c2)) {
			if (s1 > c1)
				printf("Park wins\n");
			if (s1 < c1)
				printf("Shin wins\n");
			if (s1 == c1)
				printf("draw\n");
		}

		else if ((s1 != s2) && (c1 != c2)){
			if ((s1 + s2) > (c1 + c2))
				printf("Park wins\n");
			else if ((s1 + s2) < (c1 + c2))
				printf("Shin wins\n");
			else if ((s1 + s2) == (c1 + c2))
				printf("draw\n");
		}
	}
	return 0;

}
