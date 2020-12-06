#include <stdio.h>

int main() {
	int test, x, y;
	char posit[100];
	
	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &x, &y);
		scanf("%s", posit);

		for (int i = 0; posit[i] != '\0'; i++) {
			switch (posit[i]){
			case '1': y++; break;
			case '2': x++, y++; break;
			case '3': x++; break;
			case '4': x++, y--; break;
			case '5': y--; break;
			case '6': x--, y--; break;
			case '7': x--; break;
			case '8': x--, y++; break;
			}
		}
		printf("%d %d\n", x, y);
	}
	return 0;
}