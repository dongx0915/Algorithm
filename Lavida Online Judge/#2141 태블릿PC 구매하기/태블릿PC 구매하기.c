#include <stdio.h>

int main() {
	int test, pc;
	double sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &pc);
		sum = (pc / (double)30000);
		if ((pc > 30000) && sum <= 50){
			if ((pc % 30000) == 0)
				printf("%d\n", (int)sum);
			else if ((pc % 30000) != 0)
				printf("%d\n",(int)(sum + 1));
		}
		if (sum > 50)
			printf("No\n");
		if (pc <= 30000)
			printf("0\n");
	}
	return 0;
}