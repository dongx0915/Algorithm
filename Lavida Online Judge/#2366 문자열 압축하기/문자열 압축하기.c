#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	int test, i, j, k, cnt, len = 0, copynum[100], cnt_len = 0;
	char str[20], copystr[100];

	scanf("%d", &test);

	for (j = 1; j <= test; j++) {
		scanf("%s", str);
		len = strlen(str);
		cnt_len = 0;
		printf("#testcase%d\n", j);
		printf("%s %d\n", str, len);

		for (k = 0, cnt = 1, i = 0; i < len; i++) {
			if (str[i] == str[i + 1])
				cnt++;
			else {
				copystr[k] = str[i];
				copynum[k + 1] = cnt;
				if (cnt >= 10)
					cnt_len++;
				k += 2;
				cnt = 1;
			}
		}
		if((k + cnt_len) >= len)
			printf("%s %d\n", str, len);
		else {
			for (i = 0; i < k; i += 2) {
				printf("%c%d", copystr[i], copynum[i + 1]);
			}
			printf(" %d\n", k + cnt_len);
		}
	}

	return 0;
}