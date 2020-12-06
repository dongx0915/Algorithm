#include <stdio.h>

int main()
{
	int m, w, ym, yw, test;
	scanf("%d", &test);
	
	while(test--)
	{
		scanf("%d %d %d %d", &m, &w, &ym, &yw);
		if(w > 0 && yw == 0){
			printf("%d\n", w);
		}
		else if(yw > 0 && w == 0){
			printf("%d\n", yw);
		}
		else if(w > 0 && yw > 0){
			printf("%d\n", w + yw);
		}
		else if(w == 0 && yw == 0 && ym > 0){
			printf("1\n");
		}
		else if(w == 0 && yw == 0 && yw == 0){
			printf("Not Attended\n");
		}
	}
	return 0;
}