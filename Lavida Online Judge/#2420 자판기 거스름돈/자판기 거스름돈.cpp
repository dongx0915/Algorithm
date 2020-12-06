#include <stdio.h>
#include <string.h>
int payment(int sum);
int givechange(int change);

int money[4] = { 50000, 10000, 5000, 1000 };
int rest_money[4] = { 500, 100, 50, 10 };

struct machine {
	char name[50];
	int price;
};


int main() {
	machine menu[10];
	int test, choice_cnt, menu_cnt, sum, i, j;
	char juice[30];

	scanf("%d", &test);
	while (test--) {
		scanf("%d %d", &menu_cnt, &choice_cnt);
		for (i = 0; i < menu_cnt; i++) {
			scanf("%s %d", menu[i].name, &menu[i].price);
		}

		for (sum = 0, i = 0; i < choice_cnt; i++) {
			scanf("%s", juice);
			for (j = 0; j < menu_cnt; j++) {
				if (!strcmp(menu[j].name, juice)) {
					sum += menu[j].price;
					break;
				}
			}
		}

		int save_sum = sum;
		int pay = payment(sum), change = pay - save_sum;

		printf("%d %d %d %d\n", save_sum, pay, change, givechange(change));
	}
	return 0;
}


int payment(int sum) {
	int pay = 1000;
	while (pay < sum) pay += 1000;

	return pay;
}

int givechange(int change) {
	int coin = 0;

	for (int i = 0; i < 4; i++) {
		if (change == 0) break;
		else {
			coin += change / rest_money[i];
			change %= rest_money[i];
		}
	}
	return coin;
}