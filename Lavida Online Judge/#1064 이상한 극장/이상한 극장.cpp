#include <stdio.h>

int main() {
	int test, person, seat_cnt, ticket[50], kick_person;
	int i, j;
	scanf("%d", &test);

	while (test--) {
		int seat[50] = { 0 }, index = 0;

		scanf("%d %d", &person, &seat_cnt);
		for (i = 0; i < person; i++) scanf("%d", &ticket[i]);
	
		kick_person = person;

		for (i = 0; i < person; i++) {
			index = ticket[i] - 1;

			if (seat[index] == 0) {
				seat[index] = -1;
				kick_person--;
			}
			else {
				while (index + 1 < seat_cnt) {
					if (seat[index + 1] == 0) {
						seat[index + 1] = -1;
						kick_person--;
						break;
					}
					else index++;
				}
			}

		}
		printf("%d\n", kick_person);
	}
	return 0;
}