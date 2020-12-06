#include <stdio.h>
bool checkDouble(int dot_i, char *num);

int main() {
	int test;
	char num[1000];

	scanf("%d", &test);
	while (test--) {
		int dot_i = 0;
		scanf("%s", num);

		for (int i = 0; num[i] != '\0'; i++) {
			if (num[i] == '.') {
				dot_i = i;
				break;
			}
		}

		if (dot_i == 0) printf("YES\n");
		else {
			if (checkDouble(dot_i, num)) printf("YES\n");
			else printf("NO\n");
		}
	}

	return 0;
}

bool checkDouble(int dot_i, char *num) {
	for (int i = dot_i + 1; num[i] != '\0'; i++) {
		if (num[i] - '0' != 0) return false;
	}
	return true;
}