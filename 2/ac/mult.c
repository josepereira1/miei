#include <stdio.h>

int main(void){
	int m = 0, i = 0, j, x = 3, y=2;

	while(i<x){
		j=0;
		while(j<y){
			j=j+1;m=m+1;
		}
		i=i+1;
	}
	printf("%d\n",m);

	return 0;
}