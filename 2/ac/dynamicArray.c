#include <stdio.h>
#include <stdlib.h>


typedef struct celula{
	int *elem;
}Array;

int main(void){
	Array *v;

	v = malloc(sizeof(struct celula));

	v->elem = malloc(10*sizeof(struct celula));

	(*v->elem) = 1; 
	(*(v->elem+1)) = 2; 

	printf("%d\n", *(v->elem +1));
	return 0;
}
