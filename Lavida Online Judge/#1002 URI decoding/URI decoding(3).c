#include <stdio.h>
#include <string.h>

int main() {
	int i, j, len = 0;
	char URI[81];

	scanf("%s", URI);

	len = strlen(URI);

	for (i = 0; i < len; i++) {
		if (URI[i] == '%' && URI[i + 1] == '2') {
			switch (URI[i + 2]) {
			case '0':
				URI[i] = ' ';
				for (j = i + 1; j < len; j++) 
					URI[j] = URI[j + 2];
				break;
			case '1':
				URI[i] = '!';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			case '4':
				URI[i] = '$';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			case '5':
				URI[i] = '%';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			case '8':
				URI[i] = '(';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			case '9':
				URI[i] = ')';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			case 'a':
				URI[i] = '*';
				for (j = i + 1; j < len; j++)
					URI[j] = URI[j + 2];
				break;
			}
		}
	}

	printf("%s\n", URI);
	return 0;
}