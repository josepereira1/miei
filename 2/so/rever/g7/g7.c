#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

void exec(){
	printf("OLàAAAAAAAAAA!\n");
}

int main(void){
	pid_t id;

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(1);
	}

	if(id == 0){
		signal(SIGCONT, exec);
		pause();
		printf("OLá!\n");
		_exit(2);
	}
	else{
		getchar();
		printf("id=%d\n", id);
		kill(id, SIGCONT);
		wait(NULL);
	}
	return 0;
}