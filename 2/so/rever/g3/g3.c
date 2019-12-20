#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>

//	exercício 1 e 2:
/*
int main(void){

	pid_t id;

	if((id = fork()) == -1){
		perror("ERRO na criação do processo!");
		_exit(-1);
	}
	if(id == 0){
		execlp("ls","nome_programa", "-l", NULL);
		_exit(-1);
	}else{
		wait(NULL);
		_exit(-1);
	}
	return 0;
}
*/

//	exercício 3:
/*
int main(int argc, char** argv){
	for(int i = 0; i < argc; i++)printf("%s\n", argv[i]);
	return 0;
}
*/

//	exercício 4:
/*
int main(int argc, char** argv){

	pid_t id;

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	argv[0] = "teste";

	if(id == 0){
		execv("./print", argv);
		_exit(-1);
	}else{
		wait(NULL);
		_exit(-1);
	}
}*/

/*
int main(int argc, char** argv){

	pid_t id;
	int status, i;

	for(i = 0; i < argc; i++){
		if((id = fork()) == -1){
			perror("ERRO NA CRIAÇÃO DO PROCESSO!");
			_exit(i);
		}

		if(id == 0){
			execlp(argv[i + 1], "nome_programa", NULL);
		}else{
			wait(&status);
		}
	}
	return 0;
}
*/

void strstr1(char* str, char** buf){
	int i, j, k = 0;
	unsigned long size;
	size = strlen(str);
	
	for(j = 0, i = 0; i < size + 1; i++){
		//printf("str + k=%s || str[%d]=%c || j = %d || i = %d || k = %d || size=%lu || size - (size - k) + i=%d\n",str + k,  i, str[i], j, i, k, size, (int) (size - k - (size -i)));
		//getchar();
		if(str[i] == ' '){
			memcpy(buf[j], str + k, (size - k - (size -i)));
			buf[j][(size - k - (size -i))] = '\0';
			k = i + 1;
			j++;
		}
		if(str[i] == '\0'){
			memcpy(buf[j], str + k, (size - k - (size -i)));
			buf[j][(size - k - (size -i))] = '\0';
			break;
		}
	}

	buf[j+1] = NULL;
}

void system1(char* cmdsStr){
	pid_t id;
	char** cmds;
	int n_args = 1, i, j, status;

	for(i = 0; i < strlen(cmdsStr); i++)
		if(cmdsStr[i] == ' ')n_args++;

	cmds = malloc((n_args+1)*sizeof(char*));

	for(j = 0; j < n_args; j++)cmds[j] = malloc(100*sizeof(char));

	strstr1(cmdsStr, cmds);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		execvp(cmds[0], cmds);
	}else{
		wait(&status);
	}
}

void bash(){
	char* text1 = "Air-de-Jose:", *cmdsStr, *snd;
	int n = 0;

	cmdsStr = malloc(1024*sizeof(char));

	while(1){
		write(1,text1, strlen(text1));
		n = read(0,cmdsStr, 1024);

		if(n == 0)_exit(-1);

		snd = (char*) malloc(n*sizeof(char));

		memcpy(snd, cmdsStr, n-1);

		snd[n] = '\0';

		if(strcmp(snd, "exit") == 0)_exit(-1);

		system1(snd);
	}
}

int main(int argc, char** argv){
	//system1("pwd");
	bash();
	return 0;
}









