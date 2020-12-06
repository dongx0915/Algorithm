#include <stdio.h>
#include <string.h>
int marking(int dis_num, char *stc);
int checkBig(int cnt, char *save_stc);

struct badword {
	char bad_word[1000];
	int score;
};
struct badword badword[100];

int main() {
	int dis_num, stc_cnt;
	char stc[2000];

	scanf("%d %d", &dis_num, &stc_cnt);

	for (int i = 0; i < dis_num; i++) scanf("%s %d", badword[i].bad_word, &badword[i].score);

	for (int i = 0; i < stc_cnt; i++) {
		int cnt = 0, sum = 0, score = 0;
		while (1) {
			char save_stc[20000];
			scanf("%s", stc);
			cnt++;
			if (!strcmp(stc, ".")) break;
	
			strcpy(save_stc, stc);

			score = marking(dis_num, stc); // 0 이면 감점단어 x
			int check = checkBig(cnt, save_stc);

			if (score != 0) sum -= score;
			else if (check == 2) sum -= 2;
			else sum += strlen(stc);
		}
		if (sum < 0) printf("Fail\n");
		else printf("%d\n", sum);
	}

}
//score 가 0 이고 checkBig 도 0이면 둘다 안걸린것
int marking(int dis_num, char *stc) {
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