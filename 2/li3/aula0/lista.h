#ifndef LISTA_H	//	isto serve para não dar erro quando incluo mais que uma vez este ficheiro; 
#define LISTA_H

struct no {
	struct no* seguintes;
	paluno_t aluno;
};

typedef struct no lista_aluno_t, *plista_alunos_t;

plista_alunos_t lista_iniciar(void);	//no* lista_iniciar(void);

plista_alunos_t lista_inserir(const plista_alunos_t lista, paluno_t aluno);

paluno_t lista_consultar(const plista_alunos_t lista, const char* nome, unsigned numero);

void lista_destruir(plista_alunos_t lista);
#endif

