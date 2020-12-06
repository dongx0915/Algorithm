#include <stdio.h>
#include <string.h>
#include <queue>
using namespace std;

int main() {
	int x;
	char command[10];
	queue <int> queue;

	while (1) {
		scanf("%s", command);
		if (!strcmp(command, "PUSH")) {
			scanf("%d", &x);
			queue.push(x);
		}
		else if (!strcmp(command, "POP")) {
			if (queue.empty()) printf("EMPTY\n");
			else {
				printf("%d\n", queue.front());
				queue.pop();
			}
		}
		else if (!strcmp(command, "SIZE")) printf("%d\n", queue.size());
		else if (!strcmp(command, "CLEAR")) {
			while (!queue.empty()) {
				queue.pop();
			}
		}
		else if (!strcmp(command, "END")) break;
	}
	return 0;
}