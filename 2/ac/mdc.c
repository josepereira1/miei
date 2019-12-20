#include <stdio.h>

int main(void){
	int a, b, a0, b0;
	
	printf("mdc:\nfirst number:\n");scanf("%d",&a);
	printf("second number\n");scanf("%d", &b);

	a0 = a; b0 = b;

	while(a != b){
		if(a < b){
			b = b-a;
		}else{
			a = a-b;
		}
	}

	printf("mdc(%d,%d) = %d\n", a0,b0, a);

	return 0;
}