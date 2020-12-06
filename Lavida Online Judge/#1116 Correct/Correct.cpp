#include <iostream>
#include <algorithm>
using namespace std;

bool Compare(int ryuju, int herse);

int main() {
	int ryuju, herse;
	int test;

	cin >> test;

	while(test--){
		cin >> ryuju >> herse;
		Compare(ryuju, herse) ? cout << "OK" : cout << "WRONG_ANSWER";
		cout << endl;
	}
	
	return 0;
}

bool Compare(int ryuju, int herse) {
	char arr[100], result[100];
	int zero_cnt = 0, index = 0;

	while (ryuju) {
		if (ryuju % 10 != 0) arr[index++] = (char)((ryuju % 10) + 48);
		else zero_cnt++;

		ryuju /= 10;
	}

	arr[index] = '\0';
	sort(arr, arr + index);

	int res_index = zero_cnt + 1;
	result[0] = arr[0];

	for (int i = 1; i <= zero_cnt; i++) result[i] = '0';
	for (int i = 1; i <= index; i++) result[res_index++] = arr[i];
	result[res_index] = '\0';
	
	if (atoi(result) == herse) return true;
	else return false;

}