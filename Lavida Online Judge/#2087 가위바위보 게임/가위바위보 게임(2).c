#include <stdio.h>

int main() {
	int ej, jh;

	while (1) {
		scanf("%d %d", &ej, &jh);

		if (ej == 0 && jh == 0)
			break;

		if (ej == 1) {
			if (jh == 1)
				printf("draw!\n");
			else if (jh == 2)
				printf("JJH wins!\n");
			else
				printf("PEJ wins!\n");
		}

		else if (ej == 2) {
			if (jh == 1)
				printf("PEJ wins!\n");
			else if (jh == 2)
				printf("draw!\n");
			else
				printf("JJH wins!\n");
		}

		else {
			if (jh == 1)
				printf("JJH wins!\n");
			else if (jh == 2)
				printf("PEJ wins!\n");
			else
				printf("draw!\n");
		}

	}

	return 0;
}