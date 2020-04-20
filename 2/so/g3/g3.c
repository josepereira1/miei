#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

/*
int execl(const char *path, const char *arg, ... (char  *) NULL );
	l = long;
	v = variável;

int execlp(const char *file, const char *arg, ... (char  *) NULL );
*/

//exercício 1:

void ex_4_1(){
	execlp("ls", "ARGC0","-l",NULL);	//	o argumento NULL é muito importante aqui;
	perror("Erro no execlp\n");			//	AGRC0 é o nome do programa que pode ser qualquer nome, como "coisinho", e o -l é o argc[1], que é o que queremos;
	_exit(-1);	
}
	//	para verificar se está correto, faço no terminal, ls -l | wc e depois faço ./execute | wc;



//exercício 2:

void ex_4_2(){

	pid_t id;
	int status;

	if ((id = fork()) == -1){
		perror("Erro na criação do processo!\n");
		_exit(1);
	}
	if(id == 0){
		printf("my id: %d\n",getpid());
		printf("dad id: %d\n",getppid());
		execlp("ls","ls","-l",NULL);
		perror ("Erro no execlp\n");
		_exit(-1);
	}else{
		wait(&status);	//	obriga o pai a esperar pelo exit;
	}
}

//exercício 3:


void ex_4_3(int argc, char ** argv){
	int i;

	for(i=0;i<argc;i++){
		printf("argv[%d] = %s\n", i, argv[i]);
	}
}

//exercício 4:

void ex_4_4(int argc, char **argv){
	strncpy(argv[1], "abc", 3);
	execv("./exe_3_3",argv);	//	./exe_3_3 é um ficheiro à parte;
	_exit(-1);

}

//exercício 5:

int ex_4_5(int argc, char ** argv){
	pid_t p;
	int i;
	int status;

	for(i = 1; i< argc; i++){
		if((p=fork()) == 0){	//	como o fork retorna 0 quando é o filho, então este código só vai ser executado pelo filho;
			execlp(argv[i],"coisinho",(char*)NULL);
			perror("Erro na criação do processo!\n");
			_exit(-1);
		}
	}
	for(i=1;i<argc;i++){	//	vai fazer wait por cada processo criado;
		wait(&status);
	}
	return 0;
}


//exercício 6:

//	system pede à shell que execute um comando;

/* system("clear");	//	limpa o ecrã;*/

/*	a função calc determina quantos argumentos existem e quantos caracteres tem o nome do programa;*/

void calc(int *size, int *args, int *flag, char *commands){
	int i = 0;

	while(commands[i] != '\0'){

		if(commands[i] == '\0' && *flag == 0)break;

		if(commands[i] != ' ' && *flag == 0)(*size)++;

		if(commands[i] == ' ' && *flag == 0){
			(*flag)++;
			(*args)++;
		}else {
			if(commands[i] == ' '){
				(*args)++;
			}
	    }
		i++;
	}
}

//	cria o array com os argumentos;

void create(int n, int args, char *nome_programa, char **argv, char *commands){
		int ind, i,j;

		for(i = 0; i < args+2; i++) argv[i] = malloc(10*sizeof(char));

		memcpy(nome_programa, commands, n);

		for(i=1; i <= args; i++){
			for(j=0,ind = n + 1; j < 10; j++, ind++){

				if(commands[ind] == ' ' || commands[ind] == '\0'){
					argv[i][j] = '\0';
					n = ind;
					break;
				}
				argv[i][j] = commands[ind];
			}
		}

		argv[i] = NULL;
}

void my_system(char *commands){

	int i, j, flag = 0, args = 0, n = 0, ind, status;
	char **argv, *nome_programa;
	pid_t id;
	if((id = fork()) == -1){
		perror("Erro na criaçãodo ficheiro\n");
		_exit(1);
	}
	if(id == 0){
		if(strcmp(commands, "") == 0){
			perror("Nenhum programa para executar");
			_exit(1);
		}

		calc(&n,&args,&flag,commands);	//	calcula o número de argumentos;

		if(flag > 0){	//	flag > 0, significa que há argumentos, caso contrário não há;

			nome_programa = malloc(n*sizeof(char));
			argv = malloc((args+2)*sizeof(char));

			create(n,args,nome_programa,argv,commands);	//	cria o array com os argumentos;
			
			execvp(nome_programa,argv);

		}else{	//	este ramo é executado, quando não há argumentos;
			nome_programa = malloc(n*sizeof(char));
			memcpy(nome_programa, commands, n);
			execlp(nome_programa,"coisinho", NULL);
		}
	}else{
		wait(&status);
	}
}

// 	exercício 7:

//	Uma bash que executa programas (system-calls) do sistema operativo.

#define K 1024

void bash(){
	int n, flag = 0,i, status;
	char *buf;
	pid_t id;

	my_system("say Welcome");

	buf = malloc(10*K*sizeof(char));
	while(1){
		write(1,"Air-de-Jose: josepereira$ ",26);
		n = read(0,buf,10*K);
		buf[n-1]='\0';

		if(strcmp("exit",buf) == 0)_exit(1);
		
		while(buf[i] != '\0'){
			if(buf[i] == '&') flag++;
			i++;
		}
		if(flag > 0){
			if((id = fork()) == -1){
				perror("Erro na criação do processo!\n");
				_exit(2);
			}
			flag = 0;
			if(id == 0){
				my_system(buf);
				_exit(2);
		    }else{
		    	wait(&status);
		    }
		}else{
			system(buf);
		}
	}
}

int main(int argc, char **argv){
	//ex_4_1();
	//ex_4_2();
	//ex_4_3(argc,argv);
	//ex_4_4(argc,argv);
	//ex_4_5(argc,argv);
	//my_system("ls -l");
	bash();
	return 0;
}