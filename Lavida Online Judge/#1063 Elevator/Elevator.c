#include <stdio.h>
#include <string.h>

int main() {
	int test, elv1, elv2, floor, abs_elv1 = 0, abs_elv2 = 0, len;
	char botton[5];

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &elv1, &elv2);
		scanf("%d %s", &floor, botton);
		len = 0;
		len = strlen(botton);

		abs_elv1 = floor - elv1;
		abs_elv2 = floor - elv2;

		if (abs_elv1 < 0)
			abs_elv1 = -abs_elv1;
		if (abs_elv2 < 0)
			abs_elv2 = -abs_elv2;

		if (abs_elv1 == abs_elv2) {
			if (len == 2) {
				if (elv1 < elv2)
					printf("%d\n", elv1);
				else
					printf("%d\n", elv2);
			}
			else if (len == 4) {
				if (elv1 > elv2)
					printf("%d\n", elv1);
				else
					printf("%d\n", elv2);
			}

		}

		else if (abs_elv1 < abs_elv2)
			printf("%d\n", elv1);
		else
			printf("%d\n", elv2);
	}
	return 0;
}