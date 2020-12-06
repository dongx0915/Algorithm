#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char s[1001];
char s_rev[1001];
int len = 0, test, i, j, cnt = 0;

char strrev() {
	for (j = len - 1, i = 0; j >= 0; i++, j--) {
		s_rev[i] = s[j];
	}
	s_rev[len] = '\0';
}

int cnt_m() {
	for (cnt = 0, i = 0; i < len; i++) {
		if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
			cnt++;
	}
	return cnt;
}

int main() {
	scanf("%d", &test);

	while (test--) {
		scanf("%s", s);

		len = strlen(s);

		strrev();

		cnt_m();

		if (strcmp(s, s_rev) == 0)
			printf("Same %d\n", cnt);
		else
			printf("Not_Same %d\n", cnt);
	}

	return 0;
}