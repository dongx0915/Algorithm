#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct member{
	char name[16];
	int age;
	char posit[21];
	int number;
};

int main() {
	int test, i, sum;
	int min, max, min_number = 0, max_number = 0, min_i = 0, max_i = 0;
	struct member pmem[16];

	scanf("%d", &test);
	//pmem = (struct member *)malloc(sizeof(member) * test);

	for (min = 99, max = -1, sum = 0, i = 0; i < test; i++) {
		scanf("%s %d %s %d", pmem[i].name, &pmem[i].age, pmem[i].posit, &pmem[i].number);
		sum += pmem[i].age;

		if (min >= pmem[i].age) {
			min = pmem[i].age;
			min_i = i;
		}

		if (max <= pmem[i].age) {
			max = pmem[i].age;
			max_i = i;
		}
	}

	 sum /= test;

	printf("average age : %d\n", sum);
	printf("the oldest : %s %s %d\n", pmem[max_i].name, pmem[max_i].posit, pmem[max_i].number);
	printf("the youngest : %s %s %d\n", pmem[min_i].name, pmem[min_i].posit, pmem[min_i].number);

	return 0;
}