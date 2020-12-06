#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define SIZE 8
void printAnswer(char *spot);
void initBoard();
int IntBoard1[SIZE][SIZE] = { 0 };
char CharBoard[SIZE][SIZE];
int intBoard2[SIZE][SIZE];

int main() {
	int i, j, k, x, y, test;
	char spot[3];
	scanf("%d", &test);
	initBoard();
	while (test--) {
		scanf("%s", spot);
		if (spot[0] >= 'a' && spot[0] <= 'z') {
			y = spot[0] - 96;
			x = (((int)spot[1]) - 49) * 8;
			printf("%d\n", x + y);
		}
		else printAnswer(spot);
			
	}
}

void initBoard() {
	int i, j, cnt = 1;
	for (i = SIZE - 1; i >= 0; i--) {
		for (j = 0; j < SIZE; j++) {
			IntBoard1[i][j] = cnt++;
		}
	}

	for (j = 0; j < SIZE; j++) {
		cnt = 1;
		for (i = SIZE - 1; i >= 0; i--) {
			CharBoard[i][j] = 'a' + cnt - 1;
			intBoard2[i][j] = cnt++;
		}
	}
}

void printAnswer(char *spot) {
	int i, j, k;
	int len = strlen(spot);
	int num1 = ((int)spot[0] - 49), num2 = ((int)spot[1] - 49);
	int charToint = atoi(spot);

	for (k = 1, i = 1, j = 8; i <= 64; i += 8, j += 8, k++) {
		if (charToint <= 8) {
			printf("%c1\n", (num1 + 97));
			return;
		}
		else {
			if (charToint >= i && charToint <= j) {
				if((charToint % 8) == 0) printf("%c%d\n", (charToint % 8) + 104, k);
				else printf("%c%d\n", (charToint % 8) + 96, k);
				return;
			}
			else continue;
		}
	}
}