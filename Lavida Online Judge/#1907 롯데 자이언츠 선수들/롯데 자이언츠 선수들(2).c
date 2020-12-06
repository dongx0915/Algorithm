#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Member {
	int age;
	char name[16];
	char posit[21];
};

int main() {
	int test , i, j, sum, temp = 0;
	char name_tmp[16], pos_tmp[21];
	struct Member *pmem;

	scanf("%d", &test);

	pmem = (struct Member *)malloc(test * sizeof(struct Member));

	for (sum = 0, i = 0; i < test; i++) {
		scanf("%s %d %s", pmem[i].name, &pmem[i].age, pmem[i].posit);
		sum += pmem[i].age;
	}

	for (i = 0; i <= test; i++) {
		for (j = i + 1; j <= test - 1; j++) {
			if (pmem[i].age > pmem[j].age) {
				temp = pmem[i].age;
				pmem[i].age = pmem[j].age;
				pmem[j].age = temp;

				strcpy(name_tmp, pmem[i].name);
				strcpy(pmem[i].name, pmem[j].name);
				strcpy(pmem[j].name, name_tmp);

				strcpy(pos_tmp, pmem[i].posit);
				strcpy(pmem[i].posit, pmem[j].posit);
				strcpy(pmem[j].posit, pos_tmp);
			}
		}
	}

	printf("average age : %d\n", sum / test);
	printf("the oldest : %s %s\n", pmem[test - 1].name, pmem[test - 1].posit);
	printf("the youngest : %s %s\n", pmem[0].name, pmem[0].posit);
	return 0;
}