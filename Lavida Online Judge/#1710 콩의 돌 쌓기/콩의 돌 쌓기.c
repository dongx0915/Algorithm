#include <stdio.h>

int main() {
	int i, day, sum;
	scanf("%d", &day);

	for (sum = 0, i = 1; i <= day; i++) {
		sum += i;
	}
	printf("%d\n", sum);
	return 0;
}