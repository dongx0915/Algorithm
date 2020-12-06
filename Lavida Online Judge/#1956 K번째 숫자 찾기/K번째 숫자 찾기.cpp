#include <stdio.h>
#include <algorithm>
using namespace std;
int num[2000000];

int main() {
	int n, posit;
	scanf("%d %d", &n, &posit);

	for (int i = 0; i < n; i++) scanf("%d", &num[i]);
	sort(num, num + n);
	printf("%d\n", num[posit - 1]);
	return 0;
}