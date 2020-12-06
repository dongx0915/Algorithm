#include <stdio.h>
#include <string.h>
#include <queue> 
//큐 선입선출 먼저 저장한 것을 먼저 꺼냄
//front 제일 먼저 들어옴 rear 제일 나중에 들어옴
using namespace std;

int main() {
	int test, ID, command;
	char order[4];

	scanf("%d", &test);
	while (test--) {
		queue <int> queue;
		scanf("%d", &command);
		while (command--) {
			scanf("%s", order);

			if (!strcmp(order, "In")) {
				scanf("%d", &ID);
				queue.push(ID);
			}
			else if (!strcmp(order, "Out")) {
				if (queue.empty()) printf("Empty\n");
				else {
					printf("%d\n", queue.front());
					queue.pop();
				}
			}
		}
	}
	return 0;
}