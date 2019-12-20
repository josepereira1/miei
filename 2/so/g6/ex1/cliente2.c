#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>

#define K 1024


int main(void){
	int file, n;
	char *buf;

	if((file = open("fifo", O_RDONLY, 0666)) == -1){
		perror("ERRO NA ABERTURA DO FICHEIRO fifo!");
		_exit(-1);
	}

	buf = malloc(K*sizeof(char));

	while((n = read(file, buf, K)) > 0)
		write(1,buf,n);

	return 0;
}