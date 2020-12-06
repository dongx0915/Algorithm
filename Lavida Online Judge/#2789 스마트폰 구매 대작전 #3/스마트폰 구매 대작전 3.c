#include <stdio.h>

int main() {
	int test, sum, day, money, pc, i;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &pc);

		for (day = 0, sum = 0, i = 1; sum < pc; i++) {
			if (i <= 5) {
				sum += 27000;
				day++;
			}
			else {
				if (i == 6) {
					sum += 54000;
					day++;
				}
				else if (i == 7) {
					sum += 72000;
					day++;
					i = 0;
				}
			}
		}
		printf("%d\n", day);
	}
	return 0;
}