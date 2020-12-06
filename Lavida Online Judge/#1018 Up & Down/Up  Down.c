#include <stdio.h>
#include <string.h>

int main() {
	int num[100], person[100];
	int i, j, len = 0, cnt;
	char answer[6];

	scanf("%d %s", &num[0], answer);
	len = strlen(answer);

	for (j = 0, i = 1; ; i++) {
		scanf("%d %s", &num[i], answer);

		switch (len) {
		case 2:
			if (num[i - 1] > num[i]) {
				person[j] = i + 1;
				j++;
			}
			break;
		case 4:
			if (num[i - 1] < num[i]) {
				person[j] = i + 1;
				j++;
			}
			break;
		}

		len = strlen(answer);
		if (len == 5) {
			person[j] = i + 1;
			j++;
			break;
		}
	}
	cnt = j;
	for (j = 0; j < cnt; j++) {
		if (j == cnt - 1)
			printf("%d\n", person[j]);
		else
			printf("%d ", person[j]);
	}
	return 0;
}