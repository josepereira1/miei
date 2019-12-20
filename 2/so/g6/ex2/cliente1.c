#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>

#include <sys/types.h>
#include <sys/stat.h>

int main(void){
	int file, n;
	char buf; 

	if((file = open("servidor", O_WRONLY, 0666) == -1)){
		perror("ERRO NA ABERTURA DO FICHEIRO SERVIDOR![CLIENTE 1]!");
		_exit(-1);
	}

	while((n = read(0,&buf,1)) > 0){
		write(file, &buf,n);
	}

}