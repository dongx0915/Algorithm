#include <stdio.h>
#include <math.h>

int main() {
	int test, tp;
	char s;
	double tf = 0, tc = 0;

	scanf("%d", &test);

	while(test--){
		scanf("%c", &s);
		scanf("%c", &s);
		scanf("%d", &tp);

			if (s == 'C') {
				tf = (9.0 * (double)tp / 5.0) + 32.0;
				tf = floor(tf);
				printf("%d\n", (int)tf);
			}
			else if (s == 'F') {
				tc = (5.0 / 9.0) * ((double)tp - 32.0);
				tc = floor(tc);
				printf("%d\n", (int)tc);
			}
		}

	return 0;
}