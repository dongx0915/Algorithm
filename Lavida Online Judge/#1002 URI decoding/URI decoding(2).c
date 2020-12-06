#include <stdio.h>
#include <string.h>

int main() {
	int i, j, len = 0, cnt;
	char URI[81];

	scanf("%s", URI);

	len = strlen(URI);

	for (cnt = 0, i = 0; i < len; i++) {
		cnt = 0;
		if (URI[i] == '%' && URI[i + 1] == '2') {
			switch (URI[i + 2]) {
			case '0':
				URI[i] = ' ';
				break;
			case '1':
				URI[i] = '!';
				break;
			case '4':
				URI[i] = '$';
				break;
			case '5':
				URI[i] = '%';
				break;
			case '8':
				URI[i] = '(';
				break;
			case '9':
				URI[i] = ')';
				break;
			case 'a':
				URI[i] = '*';
				break;
			default:
				cnt++;
				break;
			}
			if(cnt == 0){
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
			}
		}
	}

	printf("%s\n", URI);
	return 0;
}