#include <stdio.h>
#include <string.h>

int main() {
	int test, len[100], i, in_cnt, out_cnt;
	char member[100];

	scanf("%d", &test);

	while (test--) {
		in_cnt = 0, out_cnt = 0;

		for (i = 0; i < 8; i++) {
			scanf("%s", member);
			len[i] = strlen(member);
		}

		if (len[0] == 2 && len[1] == 2)
			printf("IN\n");
		else if (len[0] == 3 && len[1] == 3)
			printf("OUT\n");

		else {
			for (i = 2; i < 8; i++) {
				if (len[i] % 2 == 0)
					in_cnt++;
				else
					out_cnt++;
			}

			if (in_cnt == out_cnt)
				printf("AGAIN\n");
			else if (in_cnt > out_cnt)
				printf("IN\n");
			else
				printf("OUT\n");
		}
	}

	return 0;
}