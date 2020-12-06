#include <stdio.h>
#include <stack>
#include <string.h>
using namespace std;

int main() {
	stack <int> stack;
	char command[50];
	int x;

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "SIZE")) printf("%d\n", stack.size());
		
		else if (!strcmp(command, "EMPTY")) {
			if (stack.empty()) printf("TRUE\n");
			else printf("FALSE\n");
		}
		else if (!strcmp(command, "TOP")) {
			if (stack.empty())printf("NULL\n");
			else printf("%d\n", stack.top());
		}
		else if (!strcmp(command, "PUSH")) {
			scanf("%d", &x);
			stack.push(x);
			printf("%d\n", stack.size());
		}
		else if (!strcmp(command, "POP")) {
			if (stack.empty()) printf("EXCEPTION\n");
			else {
				printf("%d\n", stack.top());
				stack.pop();
			}
		}
		else if (!strcmp(command, "QUIT")) {
			if (stack.empty()) printf("GOODBYE\n");
			else printf("REMAIN\n");
			break;
		}
	}

	return 0;
}