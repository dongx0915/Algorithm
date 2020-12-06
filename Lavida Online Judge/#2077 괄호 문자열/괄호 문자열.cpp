#include <stdio.h>
#include <queue>
using namespace std;

int main() {
	int test;
	char PS[51];
	scanf("%d", &test);
	while (test--) {
		queue <int> left, right;
		scanf("%s", PS);

		for (int i = 0; PS[i] != '\0'; i++) {
			if (PS[i] == '(') left.push(i);
			else if (PS[i] == ')') right.push(i);
		}

		while (!left.empty() && !right.empty()) {
			if (left.front() < right.front()) {
				left.pop(), right.pop();
			}
			else break;
		}
		if (left.empty() && right.empty()) printf("YES\n");
		else printf("NO\n");
	}

	return 0;
}