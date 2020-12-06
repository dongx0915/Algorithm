#include <stdio.h>

int main() {
	int test, person, sit, i, index = 0, kick_per = 0;
	int sitnum[51] = { 0 }, ticket[51];

	scanf("%d", &test);

	while (test--) {
		scanf("%d %d", &person, &sit);

		kick_per = person;

		for (i = 0; i < sit; i++)
			sitnum[i] = 99;

		for (i = 0; i < person; i++) {
			scanf("%d", &ticket[i]);


			index = ticket[i] - 1;

			if (sitnum[index] == 99) {
				sitnum[index] = ticket[i];
				kick_per--;
			}

			else {
				while (index + 1< sit) {
					if (sitnum[index + 1] == 99) {
						sitnum[index + 1] = ticket[i];
						kick_per--;
						break;
					}
					else 
						index++;
				}
			}
		}
		printf("%d\n", kick_per);
	}
	return 0;
}