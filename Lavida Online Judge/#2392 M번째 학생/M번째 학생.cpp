#include <stdio.h>

int main() {
	int n, score[10000];
	int student;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &score[i]);

	scanf("%d", &student);

	printf("%d\n", score[student - 1]);
	return 0;
}