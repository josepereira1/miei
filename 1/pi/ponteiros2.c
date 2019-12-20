#include <stdlib.h>
#include <stdio.h>

typedef struct no{
	int valor;
	struct no *next;
}NO, *pNO;

typedef struct no **duplopN;

typedef int linha;

NO* init(int valor){
	duplopN lista2;
	NO *lista;
	NO teste;
	teste.valor = 2;
	lista->valor = 0;
	lista->next = NULL;
	return lista;
}

int main(void){
	int *p, a = 1;

	printf("adress of a: %p\n", &a);

	printf("adress of p: %p\n", p);

	printf("size of pointer: %ld bytes\n", sizeof(p));

	p = &a;

	(*p)++;

	printf("%d\n", (*p));

	printf("adress of p: %p\n", p);

	printf("adress of a: %p\n", &a);

	int array[] = {1,2,3,4};

	int *pointer;

	pointer = array; 

	printf("%d\n", (*pointer+2));

	return 0;

}

/*
//	isto foi uns testes que eu fiz, para perceber ponteiros
void funcao(int* *p){
	*p = malloc(4);
	**p = 2;
	printf("endereço do ponteiro p do main(isto é na função)=%p\n", p);
	printf("valor do ponteiro p da função que é o endereço para onde o ponteiro do main aponta na função (isto é na função)=%p\n", *p);
	printf("valor para onde o ponteiro p aponta no main na função (isto é na função)=%d\n", **p); 
}


typedef struct valor{
	char* string;
}VALOR;

typedef VALOR *p_VALOR;

void funcao2(p_VALOR p){
	p->string = malloc(10);
	memcpy(p->string, "ola tudo", 9);
}

int main(void){
	
	int* p;
	printf("endereço do ponteiro no main(isto é no main)=%p\n", &p);
	funcao(&p);
	printf("valor=%d\n", *p);
	
	
	p_VALOR p;
	p = (p_VALOR) malloc(sizeof(VALOR));
	printf("%p\n", p);
	funcao2(p);
	printf("%s\n", p->string);

}*/