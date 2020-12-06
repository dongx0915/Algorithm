#include <stdio.h>
#include <algorithm>
using namespace std;

int FindLength(int length[], int num) {
	sort(length, length + num);

	for (int i = 1; i < num - 1; i++) {
		if (length[num - i] <= (length[num - i - 1] + length[num - i - 2]))
			return length[num - i] + length[num - i - 1] + length[num - i - 2];
	}
	return 0;
}

int main() {
	int test, num, length[10000], i;

	scanf("%d", &test);

	while (test--) {
		scanf("%d", &num);

		for (i = 0; i < num; i++)
			scanf("%d", &length[i]);

		printf("%d\n", FindLength(length, num));
	}
	return 0;
}