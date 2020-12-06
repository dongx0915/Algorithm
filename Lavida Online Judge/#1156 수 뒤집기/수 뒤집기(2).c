#include <stdio.h>

int Reverse(int n) {
	int temp, r;

	temp = n, r = 0;
	while (temp != 0) {
		r = (r * 10) + (temp % 10);
		temp = temp / 10;
	}

	return r;
}

int TrueFalse(int save[], int cnt) {
	int i;

	for (i = 0; i < cnt / 2; i++) {
		if (save[i] != save[cnt - 1 - i])
			return 0;
	}
	return 1;
}



int main() {
	int test, n, rev_n, sum, cnt, i , j;
	int save[100], save_sum;
	scanf("%d", &test);

	while (test--) {
		scanf("%d", &n);
		sum = 0, cnt = 0;
		rev_n = Reverse(n);

		sum = n + rev_n;
		save_sum = sum;

		while (save_sum != 0) {
			save_sum = save_sum / 10;
			cnt++;
		}

			for (i = 0; i < cnt; i++) {
				save[i] = sum % 10;
				sum = sum / 10;
			}

			if (TrueFalse(save, cnt))
				printf("YES\n");
			else
				printf("NO\n");
	}
	return 0;
}