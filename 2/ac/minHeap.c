#include<stdio.h>
#include<stdlib.h>

#define TAMANHO 15

typedef struct pqueue
{
	int quantos;
	int valores[TAMANHO];
	
}*PQueue;

PQueue init(){
	PQueue q = (PQueue) malloc(sizeof(struct pqueue));
	q->quantos = 0;
	return q;
}

int empty(PQueue q){
	if(q->quantos == 0)return 1;
	else return 0;
}

void swap(int* array, int a, int b){
	int tmp;
	tmp  = array[b];
	array[b] = array[a];
	array[a] = tmp;
}

void bubbleUp(int h[], int i){
	while(i>0 && h[i] < h[(i-1)/2]){
		swap(h,i,(i-1)/2);i=(i-1)/2;
	}
}

void bubbleDown(int h[], int N){
	int f, i = 0;
	while(2*i+1 < N){
		f = 2*i+1;
		if(f+1<N && h[f+1]<h[f])f=2*i+2;
		if(h[f]<h[i]){
			swap(h,i,f);i=f;
		}else break;
	}
}

int add(PQueue q, int x){
	if(q->quantos == TAMANHO)return 0;
	else{
		q->valores[q->quantos] = x;
		bubbleUp(q->valores, q->quantos);
		q->quantos++;
	}
	return 1;
}

int remover(PQueue q, int *x){
	int r = 0;
	if(q->quantos == 0)r = 1;
	else{
		*x = q->valores[0];
		q->quantos--;
		q->valores[0] = q->valores[q->quantos];
		bubbleDown(q->valores,q->quantos);
	}
	return r;
}

void printMinHeap(PQueue q){
	for(int i = 0;i < q->quantos;i++)printf("valores[%d]=%d\n", i, q->valores[i]);
		printf("\n");
}


int main(void){
	PQueue q = init();

	/*int* v;

	v = (int*) malloc(10*sizeof(int));

	for(int i = 0; i < 10; i++){
		v[i] = i;
		printf("v[%d]=%d\n", i, v[i]);
	}

	swap(v,1,2);

	for(int i = 0; i < 10; i++){
		printf("v[%d]=%d\n", i, v[i]);
	}*/

	printMinHeap(q);
	add(q,20);
	add(q,23);
	add(q,2);
	add(q,12);
	add(q,32);
	printMinHeap(q);
	int a = 2;
	remover(q,&a);
	printMinHeap(q);
	return 0;
}

