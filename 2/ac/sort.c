#include <stdio.h>

void showArray(int v[], int N){
	int i =0;
	while(i<N){
		printf("%d ",v[i]);
		i++;
	}
	printf("\n");
}
void swap(int *v, int a, int b){
	int tmp;

	tmp = v[a];
	v[a] = v[b];
	v[b] = tmp;
}

/* código não funcional */
void bubbleSort(int v[], int N){
	int i, j, ok;
	i=0;ok=0;

	while(!ok){
		for(j=N-1;j>i;j--){
			swap(v,j-1,j);
			ok=0;
		}
	i++;
	}
}
/* código funcional */
void iSort(int v[], int N){
	int i, t;
	if(N>0){
		iSort(v+1,N-1);
		i = 0; t = v[0];
		while(i < N -1 && v[i+1] < t){
			v[i] = v[i+1];
			i++;
		}
		if(i >0)v[i] = t;
	}
}

int main(void){
	int v[5] = {5,4,3,2,1};
	showArray(v,5);
	/* bubbleSort(v, 5); */
	iSort(v,5);
	showArray(v,5);
	return 0;
}
