#include <stdio.h>

typedef struct {
	char name[16], posit[21];
	int age, number;
}Information;

int main() {
	int test, avg_age = 0;
	Information inform[15];
	scanf("%d", &test);
	
	int max = 0, min = 101, max_i = 0, min_i = 0;

	for (int i = 0; i < test; i++) {
		scanf("%s %d %s %d", inform[i].name, &inform[i].age, inform[i].posit, &inform[i].number);
		avg_age += inform[i].age;

		if (max <= inform[i].age) max = inform[i].age, max_i = i;
		if (min >= inform[i].age) min = inform[i].age, min_i = i;
	}

	printf("average age : %d\n", avg_age / test);
	printf("the oldest : %s %s %d\n", inform[max_i].name, inform[max_i].posit, inform[max_i].number);
	printf("the youngest : %s %s %d\n", inform[min_i].name, inform[min_i].posit, inform[min_i].number);

	return 0;
}