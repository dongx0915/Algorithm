#include <stdio.h>
#include <string.h>
#pragma warning(disable:4996)
void compute(char num1[], char num2[], char save[]);
void saveChar(int result, int length, char *save, int index);
void fillChar(int len1, int len2, char *num2);

int main() {
	int test;
	scanf("%d", &test);

	while (test--) {
		char num1[10010], num2[10010];
		char save[10010];
		scanf("%s %s", num1, num2);

		compute(num1, num2, save);
	}
	return 0;
}

void compute(char num1[], char num2[], char save[]) {
	int len1 = strlen(num1), len2 = strlen(num2);
	int a = 0, b = 0, sum = 0, length = 0, carry = 0, result = 0;

	if (len1 == len2) length = len1;
	else if (len1 > len2) {
		length = len1;
		fillChar(len1, len2, num2);
	}
	else {
		length = len2;
		fillChar(len2, len1, num1);
	}

	save[length + 1] = NULL;

	for (int i = length - 1; i >= 0; i--) {
		a = num1[i] - '0', b = num2[i] - '0';
		sum = a + b + carry;
		carry = sum / 10;
		saveChar(sum, length, save, i + 1);
	}
	if (carry != 0) {
		save[0] = (char)(carry + 48);
		printf("%s", save);
	}
	else {
		for (int i = 1; save[i] != '\0'; i++) {
			printf("%c", save[i]);
		}
	}
	printf("\n");
	return;
}

void saveChar(int sum, int length, char *save, int index) {
	int rest = sum % 10;
	//static int index = length;

	save[index--] = (char)(rest + 48);

	return;
}

void fillChar(int len1, int len2, char *num2) {
	char zero[10000];
	int i;

	for (i = 0; i < (len1 - len2); i++) {
		zero[i] = '0';
	}
	zero[i] = '\0';
	strcat(zero, num2);
	strcpy(num2, zero);

	return;
}