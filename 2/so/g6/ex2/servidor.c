#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>

#include <sys/types.h>
#include <sys/stat.h>

int main(void){
	int n, file, f;
	char buf;
	if((mkfifo("servidor", 0666)) == -1){
		perror("ERRO NA CRIAÇÃO DO SERVIDOR!");
		_exit(-1);
	}

	/*if((f = open("log", O_RDWR | O_CREAT, 0666)) == -1){
		perror("ERRO AO CRIAR/ABRIR FICHEIRO LOG!");
		_exit(-1);
	}*/

	if((file = open("servidor", O_RDWR , 0666)) == -1){
		perror("ERRO AO ABRIR FICHEIRO SERVIDOR!");
		_exit(-1);
	}

	while((n = read(file,&buf,1)) > 0){
		printf("%c", buf);
		write(1,&buf,1);
	}
}