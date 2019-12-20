#include <stdio.h>
#include <stdlib.h>

typedef int Elem;

typedef struct Heap{
	int size;
	int used;
	Elem *values;
}Heap;

Heap * newHeap(int s){
	Heap *h;

	h = malloc(sizeof(struct Heap));
	h->size = s;
	h->used = 0;
	h->values = malloc(s*sizeof(struct Heap));

	return h;
}

int main(void){
	Heap *h;

	h = newHeap(10);
}