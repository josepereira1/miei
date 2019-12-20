#include <signal.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

/*
SYSTEM CALLS:
sighandler_t signal(int signum, sighandler_t handler);
int kill(pid_t pid, int sig);
unsigned int alarm(unsigned int seconds);
int pause(void);
*/

/*
Usando SIGINT, SIGQUIT, e SIGALRM, escreva um programa 
que va ́ contando o tempo em segundos desde que comec
ou e: se o utilizador carregar em Ctrl-C imprima o tempo 
passado; se carregar em Ctrl-\ indique quantas vezes o 
utilizador carregou em Ctr-C e termine.


alarm(5); 	//	manda-me o sinal de alarm daqui a 5 segundos;

alarm(5);
...			//	neste caso, ele vai ignorar o primeiro, ou seja, 
alarm(2);	//se ele demorar 1 segundo entre o primeiro e o segundo, ele vai ignorar o primeiro e vai executar o segundo, ou seja, vai demorar 3 segundos;

*/

int seg=0;
int ctr = 0;
int n=0;

void sec(int s){
	seg++;
	printf("pid/sec = %d:%d\n", n, seg);
	alarm(1);
}

void ctrl(){
	ctr++;
	printf("time = %d\n",seg);
}

void exit(){
	printf("ctrl = %d\n", ctr);
	_exit(0);
}

int processo_num = 0;
int processo_atual = -1;
pid_t *pids;

void round_robin(){
	alarm(1);
	if(processo_atual >= processo_num) processo_atual = 0;
	printf("processo continue\n");
	kill(pids[processo_atual], SIGCONT);
	processo_atual++;
}

/*void ex_7_2(int argc, char** args){
	pid_t id;
	int i = 1;
	printf("%d\n",argc);

	for(i = 0; i < argc; i++){
		if((id = fork()) == -1){
			perror("Erro na criação do processo!");
			_exit(-1);
		}

		if(id == 0){	//	processo
			printf("Sou o processo filho!\n");
			pause();
			execlp(args[i],(char*)NULL);
			perror("Erro na execução!");
			_exit(-2);
		}else{
			printf("Sou o processo pai!\n");
			pids[i] = p;
			processo_atual = i;
			
		}
	}

	for(i = 0; i < argc; i++)printf("\n");
}*/

int main(int argc, char** args){
	
	//pergunta 1;
	n = getpid();
	signal(SIGALRM,sec);
	signal(SIGINT,ctrl);
	signal(SIGQUIT,exit);

	alarm(1);
	while(1) pause();
	
	//ex_7_2(argc, args);
	return 0;	
}








