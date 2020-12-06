#include <stdio.h>
bool overlap(int music[], int num);
bool ascending(int music[], int num);

int main() {
	int test, num;
	int music[100], i, j;

	scanf("%d", &test);
	while (test--) {
		scanf("%d", &num);
		for (i = 0; i < num; i++) scanf("%d", &music[i]);

		if (overlap(music, num) && ascending(music, num)) printf("GOOD\n");
		else printf("BAD\n");
	}
	return 0;
}

bool overlap(int music[], int num){ //문제가 있으면 0 없으면 1
	
	for (int i = 0; i < num - 1; i++) {
		for (int j = i + 1; j < num; j++) {
			if (music[i] == music[j]) {
				if (j - i <= 6 || j - i == 1) return false;
			}
		}
	}
	return true;
}

bool ascending(int music[], int num) {
	int cnt = 0;
	for (int i = 0; i < num - 1; i++) {
		if ((music[i] + 1) == music[i + 1]) cnt++;
		else cnt = 0;
		if (cnt >= 3) return false;
	}
	return true;
}