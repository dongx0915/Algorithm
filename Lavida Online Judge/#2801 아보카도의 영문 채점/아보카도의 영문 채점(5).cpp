#include <stdio.h>
#include <string.h>
int marking(int dis_num, char *stc);
int checkBig(int cnt, char *save_stc);

struct badword {
	char bad_word[50];
	int score;
};
struct badword badword[100];

int main() {
	int dis_num, stc_cnt;
	char stc[1000];

	scanf("%d %d", &dis_num, &stc_cnt);

	for (int i = 0; i < dis_num; i++) {
		scanf("%s %d", badword[i].bad_word, &badword[i].score);
	}

	for (int i = 0; i < stc_cnt; i++) {
		int cnt = 0, sum = 0, score = 0;
		while (1) {
			char save_stc[1000];
			scanf("%s", stc);
			cnt++;
			if (!strcmp(stc, ".")) break;
	
			strcpy(save_stc, stc);
			score = marking(dis_num, stc);
			int check = checkBig(cnt, save_stc);

			if (score == 0 && check == 0) {
				sum += strlen(stc);
			}
			else {
				if (score != 0) sum -= score;
				else {
					if (check == 2) sum -= 2;
				}
			}
		}
		if (sum < 0) printf("Fail\n");
		else printf("%d\n", sum);
	}

}
//score 가 0 이고 checkBig 도 0이면 둘다 안걸린것
int marking(int dis_num, char *stc) {
	int cnt = 0, first = 1, before = 0;
		//for (int i = 0; stc[i] != NULL; i++) {
		//	if (stc[i] >= 'A' && stc[i] <= 'Z') stc[i] += 32;
		//}

		for (int i = 0; i < dis_num; i++) {
			if (!strcmp(stc, badword[i].bad_word)) {
				return badword[i].score; // 감점 단어이면 점수 리턴
			}
		}
		return 0; // 감점단어가 아니면 리턴 0
}

int checkBig(int cnt, char *save_stc) {  // 대문자 검사 걸리면 리턴 2 안걸리면 리턴 0
	if (cnt == 1) {
		if (!(save_stc[0] >= 'A' && save_stc[0] <= 'Z')) {
			return 2;
		}
	}
	else {
		if (save_stc[0] >= 'A' && save_stc[0] <= 'Z') {
			return 2;
		}
	}

	return 0;
}