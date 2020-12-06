#include <stdio.h>
#include <string.h>

int main() {
	int test, x, y, i, len= 0;
	char space[51];

	scanf("%d", &test);

	while (test--) {
		i = 0;
		scanf("%d %d", &x, &y);
		scanf("%s", space);

		len = strlen(space);
		for(i = 0; i < len; i++) {
			if (space[i] == 'L')
				x--;
			else if (space[i] == 'R')
				x++;
			else if (space[i] == 'U')
				y++;
			else
				y--;
		}
		printf("%d %d\n", x, y);
	}
	return 0;
}