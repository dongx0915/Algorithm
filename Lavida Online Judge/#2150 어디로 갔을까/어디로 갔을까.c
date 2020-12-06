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

			switch (space[i]){
			case '1':
				y++;
				break;
			case '2':
				x++, y++;
				break;
			case '3':
				x++;
				break;
			case '4':
				x++, y--;
				break;
			case '5':
				y--;
				break;
			case '6':
				x--, y--;
				break;
			case '7':
				x--;
				break;
			case '8':
				x--, y++;
				break;
			}
			i++;
		}
		printf("%d %d\n", x, y);
	}
	return 0;
}