#include <stdio.h>

int main() {
	int cnt, first, end, cnt2;
	int num[1000];

	scanf("%d", &cnt);
	for (int i = 0; i < cnt; i++) scanf("%d", &num[i]);
	
	scanf("%d", &cnt2);

	while (cnt2--) {
		int sum = 0;
		scanf("%d %d", &first, &end);

		for (int i = first - 1; i < end; i++) 	sum += num[i];

		printf("%d\n", sum);
	}
	return 0;
}