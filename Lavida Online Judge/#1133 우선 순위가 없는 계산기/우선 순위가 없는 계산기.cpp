#include <stdio.h>
#include <stdlib.h>
#include <queue>
using namespace std;
#define MAX 2147483647

bool calculator(void);
queue <int> queue_num;
queue <char> queue_oper;
long long current = 0;

int main() {
	int num;
	char _operator;

	while (1) {
		scanf("%d%c", &num, &_operator);
		queue_num.push(num), queue_oper.push(_operator);
	
		if (_operator == '=') break;
	}

	current = queue_num.front();
	queue_num.pop();

	if (calculator()) printf("%lld\n", current);
	else printf("ERROR\n");

	return 0;
}

bool calculator() {
	while (1) {
		switch (queue_oper.front()) {
		case '+': current += queue_num.front(); break;
		case '-': current -= queue_num.front(); break;
		case '*': current *= queue_num.front(); break;
		case '/': {
			if (queue_num.front() == 0) return false;
			else current /= queue_num.front();
		}break;
		case '=': return true; break;
		}
		if (abs(current) > MAX) return false;
		queue_num.pop(), queue_oper.pop();
	}
}