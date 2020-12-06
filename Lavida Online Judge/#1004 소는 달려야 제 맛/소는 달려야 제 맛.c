#include <stdio.h>

int main() {
	int js, m, cs;
	double time = 0, dis = 0;

	scanf("%d", &js);
	scanf("%d", &m);
	scanf("%d", &cs);

	time = (double)m / (double)js;
	dis = cs * time;

	printf("%.2lf\n", dis);
	return 0;
}