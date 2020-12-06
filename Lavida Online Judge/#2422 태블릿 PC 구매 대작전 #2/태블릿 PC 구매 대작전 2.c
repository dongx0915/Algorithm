#include <stdio.h>

int main() {
	int test, pc, save, k, i, sum, day;
	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &pc, &save);
		k = pc - save;
		if (k <= 0)
			printf("0\n");
		else {
			for(i = 1, day = 0, sum = 0; sum < k; i++) {
				if (i % 6 == 0 || i % 7 == 0) {
					day++;
					sum += 56000;
					if (i == 7)
						i = 0;
				}
				else {
					day++;
					sum += 21000;
				}
			}
			printf("%d\n", day);
		}
	}
	return 0;
}