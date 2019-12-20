#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct InfoAluno{
	char *nome;
	char *curso;
	int *idade;
	int *num;	
}*aluno;
/*
int main(void){
	aluno a;
	a = malloc(sizeof(struct InfoAluno));
	a->nome = malloc(50*sizeof(char));
	strcpy(a-> nome, "José");
	a->curso = malloc(10*sizeof(char));
	a->num = malloc(sizeof(int));
	*(a->num) = 82880;
	strcpy(a->curso, "MIEI");
	a->idade = malloc(sizeof(int));
	*(a->idade) = 20;
}*/


int * change_adress();
int main(void){
	void *p;

	p = malloc(sizeof(int));

	*(int*)p=20;
	printf("%d\n", *(int*)p);
	printf("%p\n", p);
	p = change_adress();
	printf("%d\n", *(int*)p);
	printf("%p\n", p);

	*(char *)p = '?';
	
	return 0;
}

int * change_adress(){
	int *p, a = 21;

	p = &a;

	return p;
}


/*
int main(void){
	int *p;
	p = malloc(sizeof(int));
	*p = 20;
	return 0;
}*/