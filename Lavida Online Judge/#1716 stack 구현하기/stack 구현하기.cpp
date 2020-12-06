#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stack>
using namespace std;

int main() {
	stack <int> mstack;
	int num;
	char command[10];

	while (1) {
		scanf("%s", command);
		
		if (!strcmp(command, "POP")) {
			if (mstack.empty())
				printf("ERROR\n");
			else {
				printf("%d\n", mstack.top());
				mstack.pop();
			}
		}
		else if (!strcmp(command, "PUSH")) {
			scanf("%d", &num);
			mstack.push(num);
		}
		else if (!strcmp(command, "SIZE")) {
			printf("%d\n", mstack.size());
		}
		else if (!strcmp(command, "CLEAR")) {
			while (!mstack.empty()) {
				mstack.pop();
			}
		}
		else if (!strcmp(command, "END")) {
			break;
		}
	}
	return 0;
}