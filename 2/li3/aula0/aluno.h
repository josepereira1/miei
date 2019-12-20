/*
struct aluno{	// o typedef não é necessário;
	unsigned int numero;
	char nome[512];
	unsigned int ano;	// posso omitir o int quando uso o unsigned;
}

typedef struct aluno aluno_t;
*/

#ifndef ALUNO_H

#define TAM_NOME 512

//#define QUERO_ANO 	//defino isto caso queira que aquela parte de código exista e possa ser usada;

typedef struct aluno{
	unsigned int numero;	// posso omitir o int quando uso o unsigned;
#ifdef QUERO_ANO

	unsigned int ano;
#endif
	char nome[TAM_NOME];
}aluno_t, * paluno_t;

#endif	//	/* ALUNO_H */

	//	definir o unsigned numero e ano, na mesma linha pode, puxar 
	// 	mais pelo programa, caso defini por exemplo um char dos mesmos;

	//  incluir um biblioteca é copiar um código existente nas pastas do 
	//  UNIX para o meu ficheiro file.c;

	//	podemos fazer gcc de ficheiros com qualquer extensão (.h .c .coiso);

	//  gcc estruturas.h -E, serve para vermos a informação do nosso .h;

	//  gcc -E estruturas.h -DQUERO_ANO, serve para destacar no terminal esta variável;


