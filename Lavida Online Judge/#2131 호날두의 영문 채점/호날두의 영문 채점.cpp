#include <stdio.h>
#include <string.h>
void scanword(int word_cnt);
void marking(int word_cnt, int st_cnt);
int check(int word_cnt, char *sentence);
char save[1000];

typedef struct {
	char badword[100];
	int score;
}Deduct;
Deduct deduct[100];

int main() {
	int test, word_cnt, st_cnt;
	char sentence[100];

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &word_cnt, &st_cnt);
		scanword(word_cnt);
		marking(word_cnt, st_cnt);
	}
	return 0;
}

int check(int word_cnt, char *sentence) { //같으면 점수리턴, 다르면 0 리턴
	for (int i = 0; i < word_cnt; i++) {
		if (!strcmp(deduct[i].badword, sentence)) {
			return deduct[i].score;
		}
	}
	return 0;
}

void scanword(int word_cnt) {
	char buffer;

	for (int i = 0; i < word_cnt; i++) {
		scanf("%s %d", deduct[i].badword, &deduct[i].score);
		for (int j = 0; deduct[i].badword[j] != '\0'; j++) {
			if (deduct[i].badword[j] >= 'A' && deduct[i].badword[j] <= 'Z') deduct[i].badword[j] += 32;
		}
	}		
}

void marking(int word_cnt, int st_cnt) {
	char sentence[1000];

	for (int i = 0; i < st_cnt; i++) {
		int sum = 0, index = 0;
		while (1) {
			scanf("%s", sentence);
			if (!strcmp(sentence, ".")) break;
			for (int i = 0; sentence[i] != '\0'; i++) {
				if (sentence[i] >= 'A' && sentence[i] <= 'Z') sentence[i] += 32;
			}

			int check_score = check(word_cnt, sentence);
			if (check_score == 0) sum += (strlen(sentence) % 10);
			else sum -= check_score;
		}
		printf("%d\n", sum);
	}
}