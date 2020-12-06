#include <stdio.h>
#include <string.h>

int main() {
	int test, i, k, len = 0, cnt = 0;
	char text[101], sub[101];

	scanf("%d", &test);
	while(test--){
		scanf("%s %s", text, sub);

		len = strlen(sub);

		for (cnt = 0, k = 0, i = 0; text[i] != '\0'; i++) {
			if (sub[k] == text[i]) {
				k++;
				cnt++;
			}
		}

		if (cnt == len)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}