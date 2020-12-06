#include <stdio.h>
#include <algorithm>
using namespace std;
void eraseOverlap(int array[], int num);
void printArray(int array[], int num);
int Array[50];

int main() {
	int test, num;

	scanf("%d", &test);
	while (test--) {
		scanf("%d", &num);
		for (int i = 0; i < num; i++) scanf("%d", &Array[i]);
		sort(Array, Array + num);

		eraseOverlap(Array, num);
		printArray(Array, num);
	}
	return 0;
}

void eraseOverlap(int array[], int num) {
	for (int i = 0; i < num - 1; i++) {
		for (int j = i + 1; j < num; j++) {
			if (array[i] == array[j]) array[j] = 0;
		}
	}
}

void printArray(int array[], int num) {
	for (int i = 0; i < num; i++) {
		if (array[i] == 0) continue;
		else {
			printf("%d", array[i]);
			if (i != num - 1) printf(" ");
		}
	}
	printf("\n");
}