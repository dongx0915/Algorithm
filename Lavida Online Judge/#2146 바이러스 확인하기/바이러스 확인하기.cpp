#include <stdio.h>
#include <string.h>
#include <math.h>	
char binaryConversion(char *save);
bool findSHBaek(char *name);

int main() {
	int test;
	scanf("%d", &test);
	
	while (test--) {
		char birus[200], save[200], name[200];
		int index = 0, name_index = 0;
		scanf("%s", birus);

		for (int i = 0; birus[i] != NULL; i++) {
			if (i % 8 == 7) {
				save[index++] = birus[i], save[index] = NULL, index = 0;
				name[name_index++] = binaryConversion(save);
			}
			else save[index++] = birus[i];
		}
		name[name_index] = NULL;
		if (findSHBaek(name)) printf("VIRUS_ALERT!\n");
		else printf("NORMAL\n");
	}
	return 0;
}

char binaryConversion(char *save){
	int binary = 0;
	for (int i = 0; i < 8; i++) {
		if (save[i] == '1') binary += (int)pow(2, 7 - i);
	}
	return (char)binary;
}

bool findSHBaek(char *name) {
	int len = strlen(name), i, j;
	char save[200];

	for (i = 0; i + 6 <= len; i++) {
		int index = 0;
		for (j = i; j < i + 6; j++) {
			save[index++] = name[j];
		}
		save[index] = NULL;
		if (!strcmp(save, "SHBaek"))	return true;

	}
	return false;
}