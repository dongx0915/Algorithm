#include <stdio.h>

int main() {
	int test, x, y;
	char posit[51];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &x, &y);
		scanf("%s", posit);

		for (int i = 0; posit[i] != '\0'; i++) {
			switch (posit[i]){
			case 'L': x--; break;
			case 'R': x++; break;
			case 'U': y++; break;
			case 'D': y--; break;
			}
		}
		printf("%d %d\n", x, y);
	}
	return 0;
}