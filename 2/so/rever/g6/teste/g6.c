#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <unistd.h>


int main(int argc, char** argv){

	if((mkfifo("servidor1", 0666)) == -1){
		perror("Erro na criação do fifo!");
		_exit(1);
	}

	if((mkfifo("servidor2", 0666)) == -1){
		perror("Erro na criação do fifo!");
		_exit(1);
	}
	return 0;
}