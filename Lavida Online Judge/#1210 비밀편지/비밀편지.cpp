#include <stdio.h>	
#include <string.h>
bool decoding(char *code);

struct password {
	char alpha[7];
};
password p[8] = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };
char answer[11];
int ans_index = 0;

int main() {
	int word, index = 0, word_cnt = 0;
	char code[100];
	char save_code[7];

	scanf("%d", &word);
	scanf("%s", code);

	for (int i = 1; i <= word * 6; i++) {
		if (i % 6 == 0) {
			save_code[index] = code[i - 1], index = 0, word_cnt++;

			if (!decoding(save_code)) {
				printf("%d\n", word_cnt);
				return 0;
			}
		}
		else save_code[index++] = code[i - 1];
	}
	
	for (int i = 0; i < ans_index; i++) printf("%c", answer[i]);
	printf("\n");
	return 0;
}

bool decoding(char *save_code) {
	int found = 0;

	for (int i = 0; i < 8; i++) {
		int same_cnt = 0;
		for (int j = 0; j < 6; j++) {
			if (save_code[j] == p[i].alpha[j]) same_cnt++;
		}
		if (same_cnt >= 5) {
			answer[ans_index++] = 'A' + i;
			found = 1;
			break;
		}
	}

	if (found == 0) return false;
	else return true;
}