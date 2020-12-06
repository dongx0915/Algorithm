#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	char s[1001], s_rev[1001];
	int test, i, j, len = 0, cnt = 0;

	scanf("%d", &test);

	while (test--) {
		scanf("%s", s);
		len = strlen(s);

		for (j = len - 1, i = 0; j >= 0; i++, j--) {
			s_rev[i] = s[j];
		}

		for (cnt = 0, i = 0; i < len; i++) {
			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
				cnt++;
		}
		s_rev[len] = '\0';

		if (strcmp(s, s_rev) == 0)
			printf("Same %d\n", cnt);
		else
			printf("Not_Same %d\n", cnt);
	}

	return 0;
}