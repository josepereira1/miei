#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>
#include <fcntl.h>

#include <sys/wait.h>	/* chamadas wait*() e macros relacionadas */

/*
	//	funções usadas para manipulação de processos;
pid_t getpid(void);	//	retorna o id do processo;
pid_t getppid(void);	//	retorn o id do pai deste processo;
pid_t fork(void);	//	cria novo processo, o processo criado denomina-se por "filho" e o processo que o criou, por "pai";
void _exit(int status);	//	termina o processo "imediatamente", e todos os file descriptor associados a este, os filhos são herdados pelo processo pai;
pid_t wait(int *status);	//	suspende o processo até que os seus "filhos" terminam;
pid_t waitpid(pid_t pid, int *status, int options);	//	suspende o processo até que o processo filho com o pid que lhe manda-mos tiver mudado o seu estado;
int WIFEXITED(int status);	//	macro wait if exited 
int WEXITSTATUS(int status);	//	macro 
*/

/*

ps é um comando que mostra os processos ativos no momento;

*/

//	exercício 3_1:
void ex_3_1(){
	printf("adress of dad: %d\n",getppid());	//	id do pai deste programa, ou seja, a bash;
	printf("adress of sun: %d\n",getpid());		//	id deste programa;
}

void ex_3_2(){
	pid_t id;
	int status;

	printf("Código executado apenas pelo primeiro processo!\n\n");
	
	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(1);
	}
	printf("my id: %d\n", getpid());
	printf("id pai: %d\n", getppid());
	
	if(id == 0){	//	este código vai ser executado apenas pelo filho;
		printf("\n");
		_exit(2);
	}else{
		wait(&status);
		printf("id filho: %d\n\n", id);		//	este código vai ser executado pelo pai;
	}

}

void ex_3_3(){
	pid_t pid;
	int i, status;
	
	for(i=0;i != 10; i++){
		if((pid = fork()) == -1){
			perror("Falha ao criar processo!\n");
			_exit(1);
	    }
		if(pid == 0){
			printf("my id: %d\n", getpid());
			printf("my dad id: %d\n\n", getppid());
			_exit(i+1);	//	o processo morre;
		}else{
			wait(&status);	//	espera pela finalização do filho;
			printf("exit code: %d\n",WEXITSTATUS(status));	//	diz-me o exit code do processo criado;
		}
    }

}

void ex_3_4(){
	pid_t id;
	int i, status;
	for(i = 0;i != 10; i++){
		if((id = fork()) == -1){
			perror("Falha na criação do processo!\n");
			_exit(1);
		}
		if(id == 0){
			printf("%d\n", i);	//	isto serve para "provar" que os programas são consecutivos;
			printf("my pid: %d\n", getpid());
			printf("dad pid: %d\n", getppid());
			_exit(i+1);
		}else{

		}
	}
	for(i=0;i!=10;i++){
		wait(&status);	//	isto faz wait para todos os processos, os processos são criados todos ao mesmo tempo;
	}
}

void ex_3_5(){

	pid_t id;
	int i, status;

	for(i=0;i<10;i++){
		if((id = fork()) == -1){
			perror("Falha na criação do processo!\n");
			_exit(1);
		}
		if(id == 0){
			printf("%d\n", i+1);
			printf("my id: %d\n", getpid());
			printf("dad id: %d\n\n", getppid());
		}else{
			wait(&status);
			_exit(i);
		}
	}
}

#define LINHAS 3
#define COLUNAS 5

/*
//	não tenho a biblioteca da função rand();
void geraMatriz(int *array){
	int i, j;

	array = malloc(LINHAS*sizeof(int));
	for(i=0;i<LINHAS;i++){
		array[i] = malloc(COLUNAS*sizeof(int));
	}

	for(i=0;i<LINHAS;i++){
		for(j=0;j<COLUNAS;j++){
			array[i][j] = rand() % 100;
		}
	}
}
*/

void ex_3_6(int num){
	int status, flag = 0, i, j;
	int array[LINHAS][COLUNAS] = {{11,2,55,4,8},{1,2,33,44,41},{99,768,2,1,3}};
	pid_t id;

	for(i=0;i<LINHAS;i++){
		if((id = fork()) == -1){
			perror("Falha na criação do processo!\n");
			exit(1);
		}
		if(id == 0){	//	este if é executado apenas pelo processo filho;
			printf("%d\n", i+1);
			printf("my id: %d\n", getpid());
			printf("dad id: %d\n", getppid());
			for(j = 0; j < COLUNAS;j++){	//	verifica se existe o número na linha i;
				if(num == array[i][j]){
					flag++;
				}
			}
			if(flag > 0){printf("True\n\n");}else{printf("False\n");}
			_exit(1);	//	"termina" o processo;
		}else{
			wait(&status);
		}
	}
}
int main(void){
	//ex_3_1();
	//ex_3_2();
	//ex_3_3();
	//ex_3_4();
	//ex_3_5();
	ex_3_6(7);
	return 0;
}

/*
	//	NOTA: 
	//	o processo pai cria o processo filho, este processo filho cria o seu filho, e assim sucessivamente;
	int i, id;

	for(i = 0; i != 10; i++)
		id = fork();
	printf("%d\n",id);
*/