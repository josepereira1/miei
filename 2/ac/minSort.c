#include <stdio.h>
#include <stdlib.h>

void swap (int v[], int a, int b){
	int tmp;
	tmp = v[a];
	v[a] = v[b];
	v[b	] = tmp;
}

void minSort(int v[], int N){
	int i, j,m;
	for(i=0;i<N-1;i++){
		m =i;
		for(j = i+1;j<N;j++){
			if(v[m]>v[j]) m = j;
			if(i!=m)swap(v,i,m);
		}
	}
}

void printArray(int v[], int N){
	int i;
	for(i=0;i<N;i++)
		printf("%d ", v[i]);
}
int main(void){
	int v[5] = {5,4,3,2,1};
	minSort(v, 5);
	printArray(v,5);
	return 0;
}