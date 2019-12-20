#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>

#define KB 1024


/*	//	ex1:
int main(void){
	int pd[2], n;
	pid_t id;
	pipe(pd);
	char* buf;

	buf = malloc(KB);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		close(pd[0]);
		printf("pid=%d (filho) está escrever!\n", getpid());
		memcpy(buf, "hello world!", 12);
		sleep(5);
		write(pd[1], buf, KB);
		close(pd[1]);
		_exit(-1);

	}else{
		close(pd[1]);
		n = read(pd[0],buf,KB);
		printf("pid=%d (pai) está a ler!\n", getpid());
		write(1,buf,n);
		close(pd[0]);
		printf("o pai acabou de ler");
		wait(NULL);

	}
}*/

/*	//ex2:
int main(void){
	int pd[2], n, f;
	pid_t id;
	pipe(pd);
	char* buf;

	buf = malloc(KB);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if((f = open("text.txt", O_RDONLY)) == -1){
		perror("Erro na leitura do ficheiro!");
		_exit(-1);
	}

	if(id == 0){
		close(pd[0]); // como nao vair ler nada, fecha logo
		printf("pid=%d (filho) está escrever!\n", getpid());
		if((n = read(f, buf, KB)) == -1)printf("LEU MAL!");
		write(pd[1], buf, n);
		close(pd[1]);
		_exit(-1);

	}else{
		close(pd[1]); // como não vai escrever nada, fecha logo
		while((n = read(pd[0],buf,KB)) > 0){
			write(1,buf,n);
		}
		printf("pid=%d (pai) está a ler!\n", getpid());
		close(pd[0]);
		printf("o pai acabou de ler");
		wait(NULL);

	}
}
*/

/*
int main(void){
	int pd[2], n, f;
	pid_t id;
	pipe(pd);
	char buf;

	buf = malloc(KB);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		dup2(pd[0],1);
		close(pd[0]);
		execvp("wc",);
		close(pd[1]);
		_exit(-1);

	}else{
		close(pd[0]);
		dup2(pd[0],0);
		n = read(0, buf, KB);
	    write(pd[1], buf, KB);
		close(pd[1]);
		wait(NULL);

	}
}
*/

// exercício 1 - versão 02/06/2018
/*
int main(void){
	pid_t id;	
	int pd[2], n;

	pipe(pd);

	char* buf = malloc(1024*sizeof(char));
	char* str = malloc(1024*sizeof(char));

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	// if(id == 0){
	// 	close(pd[1]);
	// 	n = read(pd[0], buf, 1024);
	// 	close(pd[0]);
	// 	write(1, "Filho está a ler!\n", strlen("Filho está a ler!\n"));
	// 	write(1, buf, n);
	// 	_exit(-1);

	// }else{
	// 	close(pd[0]);
	// 	write(1,"Pai está a escrever!\n",strlen("Pai está a escrever!\n"));
	// 	sleep(5);
	// 	write(pd[1],"hello world", 11);
	// 	close(pd[1]);
	// 	wait(NULL);
	// }

	if(id == 0){
		close(pd[0]);
		write(1,"O filho está a escrever no pipe:", strlen("O filho está a escrever no pipe:"));
		sleep(5);
		write(pd[1], "hello world", 11);
		close(pd[1]);
		_exit(-1);

	}else{
		close(pd[1]);
		n = read(pd[0],buf,1024);
		write(1, "O pai está a ler o pipe:", strlen("O pai está a ler o pipe:"));
		write(1, buf, n);
		close(pd[0]);
		wait(NULL);
	}
}*/

/*int main(void){
	int f, pd[2], n = 0, i = 0;
	pid_t id;

	pipe(pd);

	if((f = open("text.txt", O_RDONLY)) == -1){
		perror("Erro na leitura do ficheiro!");
		_exit(-1);
	}


	char* buf = malloc(1024*sizeof(char));
	char ch;

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}
	
	if(id == 0){
		close(pd[0]);
		write(pd[1], "hello world", 11);
		close(pd[1]);
		//printf("Fazer o sleep(5)!\n");
		sleep(100);
		_exit(-1);
	}else{
		close(pd[1]);
		while((n = read(pd[0], &ch, 1)) > 0)write(1,&ch,1);
		printf("ACABEI DE LER NO PROCESSO PAI!\n");
		close(pd[0]);
		wait(NULL);
	}

	// if(id == 0){
	// 	close(pd[1]);
	// 	while((n = read(pd[0], &ch, 1)) > 0){
	// 		write(1,&ch,1);
	// 	}
	// 	close(pd[0]);
	// 	_exit(-1);
	// }else{
	// 	close(pd[0]);
	// 	printf("i=%d | buf=%s\n", i, buf);
	// 	write(pd[1], "hello world", 11);
	// 	close(pd[1]);
	// 	wait(NULL);
	// }

	// if(id == 0){
	// 	sleep(10);
	// 	printf("ACABEI O SLEEP DO PROCESSO FILHO!\n");
	// 	_exit(-1);
	// }else{
	// 	sleep(2);
	// 	printf("ACABEI O SLEEP DO PROCESSO PAI!\n");
	// 	wait(NULL);
	// }
}*/

//	exercício 3:
/*
int main(void){
	pid_t id;	
	int pd[2], n;

	pipe(pd);

	char* buf = malloc(1024*sizeof(char));
	char* str = malloc(1024*sizeof(char));

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		dup2(pd[0],0);
		//close(pd[0]);
		close(pd[1]);
		//printf("vou executar");
		execlp("wc", "wc",  NULL);
		_exit(-1);

	}else{
		close(pd[0]);
		write(pd[1], "hello world", 11);
		//printf("write feito com sucesso!\n");
		close(pd[1]);
		wait(NULL);
	}
}*/

int main(int argc, char** argv){
	int fd[2], status, id;
	char* buf = (char*)malloc(12);

	write(fd[1], "hello world", 11);

	for(int i = 0; i < 10; i++){
		pipe(fd);

		if((id = fork()) == -1){
			perror("Erro na criação do processo!");
			_exit(-1);		
		}

		if(id == 0){
			close(fd[1]);
			read(fd[0], buf, 12);
			write(1,buf,12);
			_exit(-1);
		}else{
			close(fd[0]);
			write(fd[1], "hello world\n", 12);
			close(fd[1]);
		}
	}

	for(int i = 0; i < 10; i++){
		wait(&status);
	}
	return 0;
}
