#include <stdio.h>
#include <string.h>

struct machine{
	char name[50];
	int price;
};

int main() {
	machine menu[10];
	int test, menu_cnt, choice_cnt, juice_cnt;
	char juice[20];

	scanf("%d", &test);
	while (test--) {
		scanf("%d", &menu_cnt);
		for (int i = 0; i < menu_cnt; i++) {
			scanf("%s %d", menu[i].name, &menu[i].price);
		}
		scanf("%d", &choice_cnt);
		int sum = 0;
		for (int i = 0; i < choice_cnt; i++) {
			scanf("%s %d", juice, &juice_cnt);
			for (int j = 0; j < menu_cnt; j++) {
				if (!strcmp(menu[j].name, juice)) {
					sum += menu[j].price * juice_cnt;
				}
			}
		}
		printf("%d\n", sum);
	}
	return 0;
}
