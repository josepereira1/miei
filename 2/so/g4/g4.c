#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*	
int dup(int fd);	//	duplica descritores de ficheiros;
int dup2(int fd1, int fd2);
*/

void nota(){
	int fd;

	fd = open("output.txt", O_CREAT | O_WRONLY | O_TRUNC, 0666);

	if(fd == -1){
		perror("Erro ao abrir output.txt\n");_exit(-1);
	}

	//	fd = 3, mas não temos de saber; usa-se o resultado do open.
	
	//write(1,"ola", 3);	//	se executar este write, vai escrever no terminal	
	
	dup2(fd,1);	//	o descritor do ficheiro passa a ser o fd

	//	Descritor 3 fi COPIADO para ao stdout, e por isso
	//	há 2 descritores a permitir acesso ao mesmo ficheiro
	//	Vamos fechar o que não precisamos

	close(fd);

	//	Vamos imprimir para o standard output

	printf("Olá meus amigos\n");	//	 este printf vai ser escrito no ficheiro.

	//	após substituir o file descriptor, não posso voltar atrás, uma forma de não 
	//	perder o descritor 1, é criar um processo e fazer a substituição do file 
	//  descriptor 1 pelo ficheiro output.txt

	/*
	id_t id;

	id = fork();

	if(id == 0){

		fd = open("output.txt", O_CREAT | O_WRONLY | O_TRUNC, 0666);

		if(fd == -1){
			perror("Erro ao abrir output.txt\n");_exit(-1);
		}

		dup2(fd,1);

		printf("Olá meus amigos\n");

	}else{
		printf("Olá meus amigos\n");
	}
	*/

}

#define K 1024

void ex_4_1(){
	int fd1, fd2, fd3, n;

	char *buf;

	buf = malloc(K*sizeof(char));

	fd1 = open("etc/passwd", O_RDONLY);
	fd2 = open("saida.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	fd3 = open("erros.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	
	if(fd1 == -1){
		perror("Erro na criação do ficheiro passwd.\n");
		_exit(-1);
	}

	if(fd2 == -1){
		perror("Erro na criação do ficheiro saida.txt.\n");
		_exit(-1);
	}

	if(fd3 == -1){
		perror("Erro na criação do ficheiro erros.txt\n");
		_exit(-1);
	}
	dup2(fd1,0);
	dup2(fd2,1);
	dup2(fd3,2);

	close(fd1);
	close(fd2);
	close(fd3);

	n = read(0,buf,K);

	write(1,buf,strlen(buf));
}

void ex_4_2(){
	int fd1, fd2, fd3, n, status;

	char *buf;

	id_t id;

	buf = malloc(K*sizeof(char));

	fd1 = open("etc/passwd", O_RDONLY);
	fd2 = open("saida.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	fd3 = open("erros.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	
	if(fd1 == -1){
		perror("Erro na criação do ficheiro passwd.\n");
		_exit(-1);
	}

	if(fd2 == -1){
		perror("Erro na criação do ficheiro saida.txt.\n");
		_exit(-1);
	}

	if(fd3 == -1){
		perror("Erro na criação do ficheiro erros.txt\n");
		_exit(-1);
	}
	dup2(fd1,0);
	dup2(fd2,1);
	dup2(fd3,2);

	close(fd1);
	close(fd2);
	close(fd3);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!\n");
		_exit(-1);
	}

	if(id == 0){
		n = read(0,buf,K);
		write(1,buf,strlen(buf));
	}else{
		wait(&status);
	}
}

void ex_4_3(){
	int fd1, fd2, fd3, n, status;

	char *buf;

	id_t id;

	buf = malloc(K*sizeof(char));

	fd1 = open("etc/passwd", O_RDONLY);
	fd2 = open("saida.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	fd3 = open("erros.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	
	if(fd1 == -1){
		perror("Erro na criação do ficheiro passwd.\n");
		_exit(-1);
	}

	if(fd2 == -1){
		perror("Erro na criação do ficheiro saida.txt.\n");
		_exit(-1);
	}

	if(fd3 == -1){
		perror("Erro na criação do ficheiro erros.txt\n");
		_exit(-1);
	}
	dup2(fd1,0);
	dup2(fd2,1);
	dup2(fd3,2);

	close(fd1);
	close(fd2);
	close(fd3);

	//	o que vai acontecer é que o output do wc vai para o 
	//	ficheiro que foi redirecionado com o file descriptor 1

	execlp("wc","nome_programa",NULL);
}

#define K 1024

void calc(int *size, int *args, int *flag, char *commands){
	int i = 0;

	while(commands[i] != '\0'){

		if(commands[i] == '\0' && *flag == 0)break;

		if(commands[i] != ' ' && *flag == 0)(*size)++;

		if(commands[i] == ' ' && *flag == 0){
			(*flag)++;
			(*args)++;
		}else {
			if(commands[i] == ' '){
				(*args)++;
			}
	    }
		i++;
	}
}

void create(int n, int args, char *nome_programa, char **argv, char *commands){
		int ind, i,j;

		for(i = 0; i < args+2; i++) argv[i] = malloc(10*sizeof(char));

		memcpy(nome_programa, commands, n);

		for(i=1; i <= args; i++){
			for(j=0,ind = n + 1; j < 10; j++, ind++){

				if(commands[ind] == ' ' || commands[ind] == '\0'){
					argv[i][j] = '\0';
					n = ind;
					break;
				}
				argv[i][j] = commands[ind];
			}
		}

		argv[i] = NULL;
}

void redir(int argc, char **argv){
	int fd1, fd2, fd3, n_prog = 0, n_agrs = 0, flag = 0, n = 1;

	char *buf, *nome_programa, **args;

	fd1 = open("etc/passwd", O_RDONLY, 0666);
	fd2 = open("saida.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);
	fd3 = open("erros.txt", O_CREAT | O_RDWR | O_TRUNC, 0666);

	if(fd1 == -1){
		perror("Erro ao abrir o ficheiro passwd.txt");
		_exit(-1);
	}

	if(fd2 == -1){
		perror("Erro ao criar/abrir o ficheiro saida.txt");
		_exit(-1);
	}

	if(fd3 == -1){
		perror("Erro ao criar/abrir o ficheiro erros.txt");
		_exit(-1);
	}

	dup2(fd1,0);close(fd1);
	dup2(fd2,1);close(fd2);
	dup2(fd3,2);close(fd3);

	if(argc > 1){
		execvp(argv[1],argv+1);
	}else{
		buf = malloc(K*sizeof(char));
		
		while(n > 0){
			n = read(0,buf,K*sizeof(char));
		}
		
		calc(&n_prog,&n_agrs,&flag,buf);

		nome_programa = malloc(n_prog*sizeof(char));
		args = malloc(n_agrs*sizeof(char));

		create(n_prog, n_agrs, nome_programa, args, buf);

		execvp(nome_programa, args);
		
	}
}

void bash(){
	int n, flag = 0,i, status;
	char *buf;
	pid_t id;

	my_system("say Welcome José Pereira!");

	buf = malloc(10*K*sizeof(char));
	while(1){
		write(1,"Air-de-Jose: josepereira$ ",26);
		n = read(0,buf,10*K);
		buf[n-1]='\0';

		if(strcmp("exit",buf) == 0)_exit(1);
		
		while(buf[i] != '\0'){
			if(buf[i] == '&') flag = 1;
			i++;
		}
		if(flag > 0){
			if((id = fork()) == -1){
				perror("Erro na criação do processo!\n");
				_exit(2);
			}
			flag = 0;
			if(id == 0){
				my_system(buf);
				_exit(2);
		    }else{
		    	wait(&status);
		    }
		}else{
			system(buf);
		}
	}
}
int main(int argc, char **argv){
	//nota();
	//ex_4_1();
	//ex_4_2();
	//ex_4_3();
	redir(argc,argv);
	return 0;
}