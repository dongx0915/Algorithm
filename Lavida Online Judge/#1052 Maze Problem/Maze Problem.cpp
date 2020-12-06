#include <stdio.h>
#include <iostream>
#include <string.h>
#include <queue> 
//큐 선입선출 먼저 저장한 것을 먼저 꺼냄
//front 제일 먼저 들어옴 rear 제일 나중에 들어옴
using namespace std;
int Hillclimbing();
int down, across;
char maze[100][101];
struct cord {
	int x, y, value;
};
cord current;
queue <cord> Q;

int main() {
	int test;
	int i, j;
	scanf("%d", &test);
	while (test--) {
		int found = 0;
		scanf("%d %d", &down, &across);
	
		while (!Q.empty()) {
			Q.pop();
		}
		for (i = 0; i < down; i++) {
				scanf("%s", maze[i]);
			}

		for (i = 0; i < down; i++) {
			for (j = 0; j < across; j++) {
				if (maze[i][j] == 'E') {
					found = 1;
					break;
				}
			}
			if (found) break;
		}

		if (found) {
			current.value = 0;
			current.x = j;
			current.y = i;
			Q.push(current);
			printf("%d\n", Hillclimbing());
		}
		else printf("-1\n");

	}

	return 0;
}

int Hillclimbing() {
	int i, j, count = 0;
	cord temp;
	while (1) {
		if (Q.empty()) {
			return -1;
		}
		temp = Q.front();
		Q.pop();
		i = temp.y;
		j = temp.x;
		count = temp.value;

		if (j + 1 < across) {
			if (maze[i][j + 1] == 'S') return count + 1;
			else if (maze[i][j + 1] == '-') {
				current.x = j + 1;
				current.y = i;
				current.value = count + 1;
				Q.push(current);
				maze[i][j + 1] = '&';
			}
		}

		if (j - 1 >= 0) {
			if (maze[i][j - 1] == 'S') return count + 1;
			else if (maze[i][j - 1] == '-') {
				current.x = j - 1;
				current.y = i;
				current.value = count + 1;
				Q.push(current);
				maze[i][j - 1] = '&';
			}
		}
		if (i + 1 < down) {
			if (maze[i + 1][j] == 'S') return count + 1;
			else if (maze[i + 1][j] == '-') {
				current.x = j;
				current.y = i + 1;
				current.value = count + 1;
				Q.push(current);
				maze[i + 1][j] = '&';
			}
		}

		if (i - 1 >= 0) {
			if (maze[i - 1][j] == 'S') return count + 1;
			else if (maze[i - 1][j] == '-') {
				current.x = j;
				current.y = i - 1;
				current.value = count + 1;
				Q.push(current);
				maze[i - 1][j] = '&';
			}
		}
	}
}