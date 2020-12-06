#include <stdio.h>
#include <string.h>

struct machine{
	char menu[50];
	int price;
};

int main() {
	machine menu[10];
	int test, juice, count;
	char choice[50];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &juice, &count);

		for (int i = 0; i < juice; i++) {
			scanf("%s %d", menu[i].menu, &menu[i].price);
		}
		int sum = 0;
		for (int i = 0; i < count; i++) {
			scanf("%s", choice);
			for (int j = 0; j < count; j++) {
				if (!strcmp(menu[j].menu, choice)) {
					sum += menu[j].price;
				}
			}
		}
		printf("%d\n", sum);
	}
}
