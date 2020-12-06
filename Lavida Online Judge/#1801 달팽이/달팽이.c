#include <stdio.h>

int main() {
	long long v, a, b, sum = 0, day;

	scanf("%lld %lld %lld", &a, &b, &v);
	sum = v - a, day = 1;
	while(1) {
		sum += b;
		sum -= a;
		day++;
		if (sum <= 0)
			break;
	}
	printf("%lld\n", day);
	return 0;
}