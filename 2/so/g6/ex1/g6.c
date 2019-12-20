#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>

#include <sys/types.h>
#include <sys/stat.h>


/*
	Um servidor é algo que controla pedidos de utilizadores, de forma controlada e com segurança, para
	que estes não destruam coisas;

	mkfifo -m 0666 fsm		//	o fsm é o nome que dou ao FIFO;

	cat < fsm	//	isto vai buscar ao fsm (servidor), dados;

	cat > fsm	//	envia para o fsm dados;

	se não tivermos este dois últimos, e apenas um deles, ao fazermos lsof -c cat, verificamos que não existe
	nenhum cat a ser executado, pq ele ou vai estar à espera de escrever, e não escreve nada, visto que não
	existe o cat > fsm, ou não lê nada pq não existe nada a ler, ou seja, cat < fsm;
*/

#define K 1024
#define MB 1024*K

int main(void){
	
	if((mkfifo("fifo", 0666)) == -1){
		perror("ERRO NA CRIAÇÃO DO SERVIDOR!");
		_exit(-1);
	}
	return 0;
}