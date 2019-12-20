#include <unistd.h>
#include <sys/wait.h>
#include<stdio.h>
#include <fcntl.h>
#include <stdlib.h>
/* chamadas ao sistema: defs e decls essenciais */
/* chamadas wait*() e macros relacionadas */


/*
//	exercício 3:
int main(void){
	pid_t id;
	int status;
	id = fork();
	
	for(int i = 0; i < 10; i++){
		
		if((id = fork()) == -1){
			perror("Erro na criação do processo!");
			_exit(-1);
		}
		if(id == 0){
			printf("SOU PROCESSO FILHO!\n");
			printf("pid of process=%d\n", getpid());
			printf("pid of dad=%d\n", getppid());
			_exit(i+1);
		}else{
			printf("SOU PROCESSO PAI!\n");
			printf("pid of dad=%d\n", getppid());
			wait(&status);
			printf("status=%d\n", WEXITSTATUS(status));
		}
	}
	return 0;
}*/
//	exercício 4
/*
int main(void){
	pid_t id;
	int status;
	
	for(int i = 0; i < 10; i++){
		
		if((id = fork()) == -1){
			perror("Erro na criação do processo!");
			_exit(-1);
		}
		if(id == 0){
			printf("SOU PROCESSO FILHO!\n");
			printf("pid of process=%d\n", getpid());
			printf("pid of dad=%d\n", getppid());
			printf("FILHO A PROCESSAR!\n");
			sleep(5);
			_exit(i+1);
		}
	}
	
	for(int j = 0; j < 10; j++){
		wait(&status);
	}
	return 0;
}
*/


//	Aqui estava a testar o facto de que eles dizem no man do fork que os descritores 
//	são partilhados entre processos, ou seja, se eu fizer um lseek no processo filho, 
//	isso vai passar para o pai
//	int main(void){
/*
int main(void){
	pid_t id;
	int f;
	char* buf;

	buf = malloc(1024);

	printf("TESTEee\n");

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if((f = open("text.txt", O_WRONLY)) == -1){
		perror("Erro na abertura do ficheiro");
		_exit(-1);
	}

	if(id == 0){
		printf("ENTREI NO PROCESSO!\n");
		//lseek(f, SEEK_SET, 3);
		printf("f=%d\n", f);
		read(f, buf, 5);
		printf("buf=%s\n", buf);
		write(1,buf,5);
		_exit(-1);
	}else{
		sleep(10);
		read(f, buf, 4);
		write(1,buf,4);
		wait(NULL);
	}
}*/

//	exercício 5
/*
int main(void){
	pid_t id;
	int f, status;

	for(int i = 0; i < 10; i++){
		if(( id = fork()) == -1){
			perror("Erro na criação do processo");
			_exit(-1);
		}

		if(id == 0){
			printf("%d\n", i+1);
			printf("my id: %d\n", getpid());
			printf("dad id: %d\n\n", getppid());
		}else{
			wait(NULL);
			_exit(i);
		}
	}
}*/

//	exercício 6

int main(void){

	pid_t id;
	int num = 5, i, j;

	int array[5][5], status;

	/*
	for(i = 0; i < 5; i++){
		for(j = 0; j < 5; j++){
			array[i][j] = i;
			printf("array[%d][%d]=%d\n", i, j, array[i][j]);
		}
	}*/

	array[0][0]=11;
	array[0][1]=55;
	array[0][2]=99;
	array[0][3]=939;
	array[0][4]=66;
	array[1][0]=4;
	array[1][1]=465;
	array[1][2]=87;
	array[1][3]=91;
	array[1][4]=23;
	array[2][0]=42;
	array[2][1]=48;
	array[2][2]=1;
	array[2][3]=34;
	array[2][4]=98789;
	array[3][0]=43;
	array[3][1]=15;
	array[3][2]=13;
	array[3][3]=19;
	array[3][4]=100;
	array[4][0]=5;
	array[4][1]=4;
	array[4][2]=6622;
	array[4][3]=33;
	array[4][4]=2;

	for(i = 0; i < 5; i++){
		if((id = fork()) == -1){
			perror("Erro na criação do processo!");
			_exit(-1);
		}
		if(id == 0){
			for(j = 0; j < 5; j++){
				if(array[i][j] == num)printf("process=%d | Encontrei o valor!\n", getpid());
			}
			_exit(-1);
		}else{
			wait(&status);
		}
	}
}


