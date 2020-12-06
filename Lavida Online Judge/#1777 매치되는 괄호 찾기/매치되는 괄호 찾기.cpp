#include <stdio.h>
#include <stack>
using namespace std;

int main() {
	int test;
	char equation[51];

	scanf("%d", &test);

	while (test--) {
		stack <int> left;
		int leftnum[50] = { 0 }, rightnum[50] = { 0 };
		int index = 0;
		bool matchcnt = true;
		scanf("%s", equation);

		for (int i = 0; equation[i] != '\0'; i++) {
			if (equation[i] == '(') left.push(i);
			else if (equation[i] == ')') {
				if (left.empty()) {
					matchcnt = false;
					break;
				}
				else {
					leftnum[index] = left.top();
					rightnum[index++] = i;
					left.pop();
				}
			}
		}
		if (!left.empty()) printf("not match\n");
		else {
			if (matchcnt) for (int i = 0; i < index; i++) printf("%d %d\n", leftnum[i], rightnum[i]);
			else printf("not match\n");
		}
	}
	return 0;
}