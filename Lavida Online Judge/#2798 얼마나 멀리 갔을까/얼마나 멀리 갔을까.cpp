#include <stdio.h>
#include <math.h>

int main() {
	int test, x, y;
	char posit[101];
	char buffer;
	scanf("%d", &test);
	scanf("%c", &buffer);
	while (test--) {
		int distance = 0, first_x = 0, first_y = 0;
		scanf("%d %d", &x, &y);
		scanf("%s", posit);

		first_x = x; first_y = y;
		for (int i = 0; posit[i] != '\0'; i++) {
			switch (posit[i]){
			case 'N': y++; break;
			case 'E': x++; break;
			case 'S': y--; break;
			case 'W': x--; break;
			case 'M': {
				switch (posit[i + 1]){
				case 'N': x++, y++; break;
				case 'E': x++, y--; break;
				case 'S': x--, y--; break;
				case 'W': x--, y++; break;
				}
				i++;
			}
			}
		}
		int dis_x = 0, dis_y = 0;
		dis_x = first_x - x;
		if (dis_x < 0) dis_x = -dis_x;
		dis_y = first_y - y;
		if (dis_y < 0) dis_y = -dis_y;

		distance = dis_x + dis_y;

		if (distance == 0) printf("same\n");
		else printf("%d %d %d\n", x, y, distance);
	}
	return 0;
}