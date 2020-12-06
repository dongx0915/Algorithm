#include <stdio.h>

int main() {
	long long n, m, i;
	char str, null;

	scanf("%lld %lld", &n, &m);
	scanf("%c", &null);

	for (i = 0; i < n; i++) {
		scanf("%c", &str);
		if(i >= m - 1)
		printf("%c", str);
	}
	printf("\n");

	return 0;
}