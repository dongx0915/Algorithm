#include <stdio.h>

int main() {
	int s1, s2, s3, s4, n1, n2, n3, n4;
	scanf("%d %d %d %d %d %d %d %d", &s1, &n1, &s2, &n2, &s3, &n3, &s4, &n4);

	printf("%d %d\n", (n1 + n2 + n3 + n4), (s1 + s2 + s3 + s4));
	return 0;
}