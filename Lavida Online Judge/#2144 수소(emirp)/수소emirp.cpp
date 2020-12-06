#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <algorithm>
using namespace std;
int reverse(int n);
int IsPrime(int n);

int main() {
	int test, start, end;

	scanf("%d", &test);

	while (test--) {
		int rev_num = 0, index = 0;
		int prime[100000] = { 0 };
		scanf("%d %d", &start, &end);

		if (start > end) {
			int temp = 0;
			temp = start;
			start = end;
			end = temp;
		}
		for (int i = start; i <= end; i++) {
			if (IsPrime(i)) {
				rev_num = reverse(i);
				//printf("rev_num = %d\n", rev_num);
				if (i != rev_num) {
					if (IsPrime(rev_num)) {
						prime[index++] = i;
					}
				}
			}
		}
		sort(prime, prime + index);
		if (index == 0) printf("0 0 0\n");
		else printf("%d %d %d\n", prime[index - 1], prime[0], index);
	}
	return 0;
}

int IsPrime(int n) { //소수이면 1 아니면 0
	int i, limit;

	if (n <= 1) return 0;
	if (n == 2) return 1;
	if (n % 2 == 0) return 0;

	limit = (int)sqrt((double)n);

	for (i = 3; i <= limit; i += 2) {
		if (n%i == 0) {
			return 0;
		}
	}
	return 1;
}

int reverse(int n) {
	int rev_num = 0;

	while (n) {
		rev_num = (rev_num * 10) + (n % 10);
		n = n / 10;
	}
	return rev_num;
}