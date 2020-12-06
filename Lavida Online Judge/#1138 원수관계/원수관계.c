#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	int test, i, num1[100], num2[100], len1, len2, length, sum;
	char name1[101], name2[101];

	scanf("%d", &test);

	while (test--) {
		scanf("%s %s", name1, name2);
		len1 = strlen(name1);
		len2 = strlen(name2);

		if (len1 > len2)
			length = len1;
		else
			length = len2;

		for (i = 0; i < length; i++) {
			if (i < len1)
				num1[i] = (int)name1[i] - 64;
			else
				num1[i] = 0;
			if (i < len2)
				num2[i] = (int)name2[i] - 64;
			else
				num2[i] = 0;
		}

		for (sum = 0, i = 0; i < length; i++) {
			sum += pow(num1[i] - num2[i], 2);
		}

		printf("%d\n", sum / length);
	}
	return 0;
}