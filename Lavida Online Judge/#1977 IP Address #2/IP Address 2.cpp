#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct IP {
	int IPaddress[8] = { 0 };
};
IP conversion[4];
void BinaryConversion(char *save, int cnt);
void resetStruct();

int main() {
	int test;
	char address[100], save[100];

	scanf("%d", &test);
	while (test--) {
		resetStruct();
		scanf("%s", address);
		int index = 0;

		for (int i = 0, cnt = 0; ; i++) {
			if (address[i] == '.' || address[i] == '\0') {
				save[index] = '\0';
				BinaryConversion(save, cnt++);
				index = 0;
			}
			else save[index++] = address[i];

			if (address[i] == '\0') break;
		}
		printf("\n");
	}
	return 0;
}

void BinaryConversion(char *save, int cnt) {
	int num = atoi(save);
	int i = 1;
	while (num > 0) {
		conversion[cnt].IPaddress[8 - i++] = num % 2;
		num = num / 2;
	}
	for (int i = 0; i < 8; i++) printf("%d", conversion[cnt].IPaddress[i]);
}

void resetStruct() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 8; j++) {
			conversion[i].IPaddress[j] = 0;
		}
	}
}