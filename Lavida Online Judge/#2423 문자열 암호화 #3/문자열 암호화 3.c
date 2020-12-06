#include <stdio.h>

int main() {
	int test, i;
	char str[101];

	scanf("%d", &test);

	while (test--) {
		scanf("%s", str);

		for (i = 0; str[i] != '\0'; i++) {
			switch (str[i]) {
			case 'a': 
				str[i] = '!';
				break;
			case 'e':
				str[i] = '#';
				break;
			case 'i' :
				str[i] = '$';
				break;
			case 'o':
				str[i] = '%';
				break;
			case 'u':
				str[i] = '&';
				break;
			default :
				if (str[i] >= 97 && str[i] <= 109)
					str[i] -= 5;
				else if (str[i] >= 109 && str[i] <= 122)
					str[i] += 3;
				break;
			}

			if (str[i] >= 65 && str[i] <= 90)
				str[i] = str[i] - 20;
		}
			printf("%s\n", str);
	}
	return 0;
}