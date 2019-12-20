#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

int main(void){
	int fd1, fd2, n, id;
	if((fd1= open("servidor1", O_RDONLY)) == -1){
		perror("Erro na abertura do fifo!");
		_exit(-1);
	}

	if((fd2 = open("servidor2", O_WRONLY)) == -1){
		perror("Erro na abertura do fifo!");
		_exit(-1);
	}

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		while(1){
			char* buf = (char*) malloc(1024*sizeof(char));
			n = read(0, buf, 1024);
			if(n == 0)break;
			write(fd2, buf, n);
			free(buf);
			buf = NULL;
		}
	}else{
		while(1){
			char* buf = (char*) malloc(1024*sizeof(char));
			n = read(fd1, buf, 1024);
			if(n == 0)break;
			write(1, buf, strlen(buf));
			free(buf);
			buf = NULL;
		}
		wait(NULL);
	}

	return 0;
}