#include <stdio.h>
#include "aluno.h"
#include "lista.h"

	//	na ausência de um tipo em C, ele assume o tipo int como padrão;

void inc(int* x){
	*x = *x+1;
}

int main(void){
	int i = 0, *p;
	p = &i;
	inc(p);
	printf("%p -> %d\n",(long)p,(*p));
	printf("%p -> %d\n",(long)(p+1),(*p));
	printf("%p -> %d\n",(long)((char*)p+1),(*p));
	return 0;	//	quando um programa termina bem, retorn 0;
				//	caso retorne 1, significa que correu mal;
}

//	gcc -E aula0.c mostra todo o código presente no aula0.c e os respectivos includes, neste caso o stdio.h e stdlib.h;