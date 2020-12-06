#include <stdio.h>
#include <string.h>
char sequence[1000000];
int saveint[1000000] = { 0 };

int main() {
	int question, start, end, cnt = 0;
	scanf("%s", sequence);

	int len = strlen(sequence);
	scanf("%d", &question);

	for (int i = 0; i < len - 1; i++) {
		if (sequence[i] != sequence[i + 1]) {
			cnt++;
			saveint[i + 1] = cnt;
		}
		else saveint[i + 1] = cnt;
	}

	while (question--) {
		scanf("%d %d", &start, &end);

		if (saveint[start] == saveint[end]) printf("Yes\n");
		else printf("No\n");
	}

	return 0;
}