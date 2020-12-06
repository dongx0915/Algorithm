#include <stdio.h>
#include <string.h>
#include <math.h>
char binaryConversion(char *save);
bool findName(char * find, char *name);

int main() {

	while (1) {
		char find[10], binary[1000];
		char save[1000], name[1000];
		int index = 0, name_index = 0;
		scanf("%s %s", find, binary);

		if (!strcmp(find, "NULL") && !strcmp(binary, "NULL")) break;

		for (int i = 0; binary[i] != NULL; i++) {
			if (i % 8 == 7) {
				save[index++] = binary[i], save[index] = NULL, index = 0;
				name[name_index++] = binaryConversion(save);
			}
			else save[index++] = binary[i];
		}
		name[name_index] = NULL;
		if (findName(find, name)) {
			printf("Found!\n");
		}
		else printf("Not found!\n");
	}
	return 0;
}

char binaryConversion(char *save) {
	int binary = 0;
	for (int i = 0; i < 8; i++) {
		if (save[i] == '1') binary += (int)pow(2, 7 - i);
	}
	return (char)binary;
}

bool findName(char * find, char *name) {
	int find_len = strlen(find),len = strlen(name), i, j;
	char save[200];
	int index = 0;
	for (i = 0; i + find_len <= len; i++) {
		index = 0;
		for (j = i; j < i + find_len; j++) {
			save[index++] = name[j];
		}
		save[index] = NULL;
		if (!strcmp(save, find))	return true;

	}
	return false;
}