#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>

#define K 1024

int main(void){
	int n, file;
	char *fstBuf;

	if((file = open("fifo", O_WRONLY, 0666)) == -1){
		perror("ERRO NA ABERTURA DO FICHEIRO fifo!");
		_exit(-1);
	}

	fstBuf = malloc(K*sizeof(char));
	
	while((n = read(0,fstBuf,K)) > 0){
		write(file,fstBuf, n);
	}
}