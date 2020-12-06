#include <stdio.h>

int main() {
	int test, temp, change_temp;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &temp);
		change_temp = temp * 103;
		printf("%d\n", change_temp);
	}
	return 0;
}