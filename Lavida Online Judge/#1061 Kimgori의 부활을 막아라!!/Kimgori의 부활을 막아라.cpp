#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int test, i, person, num;
	int name[21];

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &person, &num);

		for (i = 0; i < person; i++)
			scanf("%d", &name[i]);

		sort(name, name + person);

		printf("%d\n", name[num - 1]);
	}
	return 0;
}