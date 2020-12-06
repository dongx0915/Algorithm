#include <stdio.h>
#include <string.h>

int main() {
	int i, test, name1_len, name2_len, Long, Short, sum;
	int save[51] = { 0 };
	char name1[51], name2[51], longer[51], shorter[51];

	scanf("%d", &test);

	while (test--) {
		scanf("%s %s", name1, name2);

		name1_len = strlen(name1);
		name2_len = strlen(name2);

		if (name1_len > name2_len) {
			Long = name1_len;
			Short = name2_len;
			strcpy(longer, name1);
			strcpy(shorter, name2);
		}

		else {
			Long = name2_len;
			Short = name1_len;
			strcpy(longer, name2);
			strcpy(shorter, name1);
		}

		for (sum = 0, i = 0; i < Long; i++) {
			if (i < Short)
				save[i] = ((longer[i] - 64) - (shorter[i] - 64)) * 2;
			else
				save[i] = (longer[i] - 64) * 2;

			if (save[i] < 0)
				save[i] = -save[i];
			sum += save[i];
		}

		printf("%d\n", sum / Short);
	}

	return 0;
}