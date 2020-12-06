#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stack>
using namespace std;

struct stack_item {
	char URL[71];
};

int main() {
	stack <stack_item> back;
	stack <stack_item> forward;
	char command[10];
	struct stack_item page;

	strcpy(page.URL, "http://www.acm.org/");

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "BACK")) {
			if (back.empty()) printf("Ignored\n");
			else {
				forward.push(page);

				strcpy(page.URL, back.top().URL);
				back.pop();
				printf("%s\n", page.URL);
			}
		}
		else if (!strcmp(command, "FORWARD")) {
			if (forward.empty()) printf("Ignored\n");
			else {
				back.push(page);
				strcpy(page.URL, forward.top().URL);
				forward.pop();
				printf("%s\n", page.URL);
			}
		}
		else if (!strcmp(command, "VISIT")) {
			back.push(page);
			//strcpy(page.URL, back.top().URL);
			scanf("%s", page.URL);
			printf("%s\n", page.URL);
			while (!forward.empty()) {
				forward.pop();
			}
		}
		else if (!strcmp(command, "QUIT")) {
			break;
		}
	}
	return 0;
}