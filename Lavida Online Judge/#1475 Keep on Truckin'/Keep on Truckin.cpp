#include <stdio.h>
#define WHEELER 168
void Crash(int heightp[]);

int main() {
	int height[3];

	scanf("%d %d %d", &height[0], &height[1], &height[2]);
	Crash(height);
}

void Crash(int height[]) {
	for (int i = 0; i < 3; i++) {
		if (WHEELER >= height[i]) {
			printf("CRASH %d\n", height[i]);
			return;
		}
	}
	printf("NO CRASH\n");
}