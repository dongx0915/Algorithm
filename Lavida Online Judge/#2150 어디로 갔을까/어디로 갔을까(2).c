#include <stdio.h>

int main() {
	int test, x, y, i;
	char space[81];

	scanf("%d", &test);

	while (test--) {
		i = 0;
		scanf("%d %d", &x, &y);
		scanf("%s", space);

		while (space[i] != NULL) {

			if (space[i] == '1')
				y++;
			else if (space[i] == '2')
				x++, y++;
			else if (space[i] == '3')
				x++;
			else if (space[i] == '4')
				x++, y--;
			else if (space[i] == '5')
				y--;
			else if (space[i] == '6')
				x--, y--;
			else if (space[i] == '7')
				x--;
			else
				x--, y++;
			i++;

		}
		printf("%d %d\n", x, y);
	}
	return 0;
}