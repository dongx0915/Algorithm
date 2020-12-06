#include <stdio.h>
#include <string.h>
#include <queue>
using namespace std;

struct vps {
	char PS[51];
	int num;
};

int main() {
	int test;
	vps vps;
	scanf("%d", &test);
	while (test--) {
		queue <struct vps> left;
		queue <struct vps> right;
		scanf("%s", vps.PS);

		while (!left.empty()) left.pop();
		while (!right.empty()) right.pop();

		for (int i = 0; vps.PS[i] != '\0'; i++) {
			if (vps.PS[i] == '(') {
				vps.num = i;
				left.push(vps);
			}
			else if (vps.PS[i] == ')') {
				vps.num = i;
				right.push(vps);
			}
		}

		while (!left.empty() && !right.empty()) {
			struct vps leftfront = left.front(), rightfront = right.front();
			if (leftfront.num < rightfront.num) {
				left.pop();
				right.pop();
			}
			else break;
		}
		if (left.empty() && right.empty()) printf("YES\n");
		else printf("NO\n");
	}

	return 0;
}