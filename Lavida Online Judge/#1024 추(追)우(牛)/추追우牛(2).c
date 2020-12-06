#include <stdio.h>

int main() {
	int test, x, y, i;
	char space[51];

	scanf("%d", &test);

	while (test--) {
		i = 0;
		scanf("%d %d", &x, &y);
		scanf("%s", space);

		while (space[i] != NULL) {

			if (space[i] == 'L')
				x--;
			else if (space[i] == 'R')
				x++;
			else if (space[i] == 'U')
				y++;
			else
				y--;
			i++;

		}
		printf("%d %d\n", x, y);
	}
	return 0;
}