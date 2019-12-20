#include <unistd.h>	/*	chamadas ao sistema: defs e decls essenciais*/
#include <fcntl.h>	/*	O_RDONLY, O_WRONLY, O_CREAT, O_* (Chamadas ao sistema) */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "struct_buffer.h"

/*

//resumo teórico: 

int open (const char *pathname, int flags);	//const char * pathname = é o cmainho (string)
exemplo: open("/etc/lixo", O_RDONLY, O_CREAT)

permissões:
root-grupo-outros
rwe-rwe-rwe 1 //significa que o root o grupo e os outros tem todas as premissões;


cat programa.c //mostra o programa no termianl;

cat 		   //se escrevermos algo, ele mostra-nos o que escrevemos;

*void buf      //significa que aponta para qualquer coisa na memória de qualquer tipo;


//(exemplo):

int main(int argc, char **argv){

	//void *buf = malloc();	//tb podia fazer desta maneira;
	char buf[64];
	int n;

	//n = read(0,buf,30);	// read devolve o número de caracteres que eu inseri;
						    // o 30 refere-se ao número máximo de caracteres que eu posso inserir;
 	if(n = read(3,buf,30) == -1){
	perror("");exit(-1);
	}
	// isto dá erro, pq n posso ter acesso ao 3, visto que 3 é um ficheiro qualquer que eu não conheço
	// logo estou a tentar ler desse ficheiro, logo o correto é ler do teclado, ou seja 0, ou ler de um
	// ficheiro que eu conheça; 
	
	if(n = read(0,buf,60) == -1){	// neste caso não problemas, pois não estou a tentar ler de ficheiros que não tenho permissões
	perror("");exit(-1);			// nem a exceder o bufer que eu tenho, pois tenho 64, e estou a usar 60;
	}
}

	// se colocar um ponto de exclamação no terminal e uma letra, 
	// ele mostra-me todos os comandos que eu já executei que comecem por essa letra;
*/

//	EXERCÍCIOS PROPOSTOS: GRUPO 3: 

//exercício 1:

void ex_3_1(){
	char c;
	int n;

	while((n = read(0,&c,1)) > 0){	//	0 indica que é um input;
		write(1,&c,1);	// 1 indica que é um output;
	}
	exit(n);
}

#define MEGA10 					1024*1014*10
#define ALL_OWNER_PERMI 		S_IRUSR | S_IWUSR | S_IXUSR

//exercício 2:

void ex_3_2(char *path){
	// o path recebido como parâmetro da função, corresponde ao argv[1], que
	// é a string a seguir ao nome do programa quando o executamos ./g1 "path"
	// é o índice 1, pois o nome do programa é o argv[0] = "g1"; argv[1] = "path";
	
	char c ='&';
	int n, f;

	if( (f = open(path,O_WRONLY | O_CREAT, ALL_OWNER_PERMI)) == -1){
	 	perror("Erro de abertura do ficheiro!");
		exit(-1);
	}	
	for(n=0; n < MEGA10;n++){
		write(f,&c,1);	//este write é repetido 10MB vezes;
	}
	exit(n);
}

// exemplos de aplicações do read() e write():

void f1 (char *path){

	//char *path = "/home/andre/Base/codes/C/so/g1/text.txt";
	int N = 11;
	char str[] = "hello world";
	int n, f;

	if( (f = open(path,O_WRONLY | O_CREAT, ALL_OWNER_PERMI)) == -1){
	 	perror("Erro de abertura do ficheiro!");
		exit(-1);
	}	//argv[1] é o cenas que eu dou quando executo o programa, o índice 0 é o nome do programa; 
	for(n=0; n < 1;n++){
		write(f,str,(N + 1) *sizeof(char));	// 	o que tem no c é lixo, mas faz os 10MB;
	}
	exit(n);

}
//temos 3 tipos de flags 0 / 1 / 2
// 0 -> input
// 1 -> output
// 2 -> erros


void f2 (){

	char *path = "/home/andre/Base/codes/C/so/g1/text1.txt";
	int N = 4;
	int a[] = {1,11,3,10};
	int n, f;

	if( (f = open(path,O_WRONLY | O_CREAT, ALL_OWNER_PERMI)) == -1){
	 	perror("Erro de abertura do ficheiro!");
		exit(-1);
	}	//argv[1] é o cenas que eu dou quando executo o programa, o índice 0 é o nome do programa; 
	for(n=0; n < 1;n++){
		write(f,a,N * sizeof(int));	// 	o que tem no c é lixo, mas faz os 10MB;
	}
	exit(n);

}

void f3(){
	int f;
	char array2[12];

	if((f = open("/home/andre/Desktop/text1.txt",O_RDWR | O_CREAT, ALL_OWNER_PERMI))==-1){
		perror("Erro na Abertura!");	// abrir o ficheiro com path ou criar;
		exit(-1);
	}
	char array[]="Hello World";
	write(f,array,11*sizeof(char));	// escrever no ficheiro "Hello World";
	
	lseek(f,0,SEEK_SET);	// colocar o cursor no ínicio do ficheiro;
	read(f,array2,12*sizeof(char)); // ler através do ficheiro;
	close(f);
	write(1,array2,11*sizeof(char));	// escrever no terminal o que está no array2
}


//exercício 3:

void ex_3_3(int n, char* path, int n_files){
	int x;
	int *input;

	if(n_files == 1){
		input = malloc(n*sizeof(char));

		while((x = read(0,input,n*sizeof(char)))>0){
			write(1,input,n*sizeof(char));
		}
	}else{
		int f; 
		if((f = open(path,O_RDONLY,ALL_OWNER_PERMI)) == -1){
			perror("Erro na abertura do ficheiro!");
			exit(-1);
		}
		
	}

}

int getNumber(char *str){
	int i, n, x = 1;
	n = strlen(str);
	i = n-1;
	n = 0;
	while(i>=0){
		n = n + (str[i]-48) * x;
		x = x * 10;
		i--;
	}
	return n;
}

//exercício 4:

// time ./execute 1 & time ./execute 90
// tem aproximadamente o mesmo tempo de execução, mas verifica-se que o
// mycat com N bytes (N>1) é mais eficiente, visto que 
// estamos a guardar e escrever tudo de uma vez, enquanto que no outro é byte a byte

//exercício 5:

ssize_t readln(int fildes, void *buf, ssize_t nbyte){
	int n, i = 0;
	while(i < nbyte){
		n = read(fildes,((char*)buf + i),sizeof(char));
		if(*((char*)buf + i) == '\n' || n == 0)break;
		i++;
	}

	if (i == nbyte) {
		perror("Passou a memória do buffer!");
		return 0;
	}
	return i;
}

//exercício 6:

#define N 1024

void nl1(int fildes){	// funciona para ler do teclado, mas não para ler a partir de ficheiros;
	
	int n, i =1, size = 0;	//	se não declarar este aux, o programa não funciona, não percebo porquê??;
	char buf[N], num[12];
		
	while((n = readln(fildes,buf,N*sizeof(char)))>0){
		if(n>N){
			perror("ERRO!!!!!");
			exit(1);
		}
		sprintf(num,"%d",i);
		i++;
		size = strlen(num);
		write(1,"    ",4*sizeof(char));write(1,num,size*sizeof(char));write(1," ",1*sizeof(char));
		write(1,buf,(n+1)*sizeof(char));
	}
}	

// exercício 7:

int create_buffer(int fildes, p_buffer_t buffer, size_t nbyte){
	buffer->buf = malloc(nbyte);
	buffer->fildes = fildes;
	buffer->buffer_size = nbyte;
	buffer->last_line = 0;
}

int destroy_buffer(struct buffer_t *buffer){
	free(buffer->buf);
	free(buffer);
}

#define KB 1024


ssize_t readln1(p_buffer_t buffer, void *buf){
	int n, i;
	ssize_t len;

	if(buffer->last_line == 0)	//	só faço o read, quando estou no ínicio do buffer;
		if((n = read(buffer->fildes,buffer->buf,buffer->buffer_size)) == -1){
			perror("Erro na leitura do ficheiro!");
			exit(-1);
		}
	
	for(i = buffer->last_line; *( (char*)(buffer->buf + i)) != '\n'; i++);	//	começa na última linha e deteta o fim desta linha;
	len = i - buffer->last_line + 1;
	buffer->last_line = i++;

	if(buffer->last_line == buffer->buffer_size) buffer->last_line = 0;
	return len;
}


//EXERCÍCIOS ADICIONAIS:

// exercício 1:

void my_cat_files(int n_files, char *path){
	int f;
	if(n_files == 1){
		f = 0;
	}else{
		int f = open(path,O_RDONLY | O_CREAT, ALL_OWNER_PERMI);
	}	
	int n;
	char c;

	while((n = read(f, &c, sizeof(char))) > 0){
		write(1,&c,sizeof(char));
	}
}

// exercício 3:

void my_head(int n, char** paths){
	int i, files[n], input, size;
	char c;

	if(n == 1){
		while((input = read(0, &c, sizeof(char))) > 0){
			write(1,&c,sizeof(char));
		}
	}else{
		for(i=0;i<n;i++){
			files[i] = open(paths[i],O_RDONLY | O_CREAT, ALL_OWNER_PERMI);
		}
	
		for(i = 0; i < n;i++){
				size = strlen(paths[i]);
				write(1,"==>",3);write(1,paths[i],size);write(1,"<==",3);write(1,"\n",1);
			
			while((input = read(files[i], &c, sizeof(char))) > 0 && c != '\n'){
				write(1,&c,sizeof(char));
			}
			write(1,&c,sizeof(char));
		}
	}
}

void myhead1(int argc, char** argv){
	int n;
	char* buf, ch;
	int fildes[argc-1], f;

	for(int i = 1; i < argc; i++){
		if((f = open(argv[i], O_RDONLY, 0666)) == -1){
			perror("ERRRO! Na abertura do ficheiro!");
			_exit(-1);
		}
		fildes[i-1] = f;
	}

	if(argc > 1){
		for(int i = 0; i < argc -1; i++){
			write(1,"==> ", 4);
			write(1,argv[i+1], strlen(argv[i+1]));write(1," <==\n", 5);
			while(1){
				n = read(fildes[i], &ch, 1);
				if(ch == '\n'){
					write(1,&ch,1);
					break;
				}
				write(1,&ch,1);
			}
		}
	}else{
		while((n = read(0, &ch, 1)) > 0)write(1,&ch,1);
	}
}

// exercício 6:

void my_cmp(int argc, char *path1, char *path2){
	int n1, n2, f1, f2, car = 0, line = 1, size1, size2;
	char c1, c2, num1[20], num2[20];

	if(argc != 3){
		perror("Falta um ficheiro!");
		exit(1);
	}
	if((f1 = open(path1,O_RDONLY,ALL_OWNER_PERMI)) == -1){
		perror("Erro na abertura do primeiro ficheiro!");
		exit(-1);
	}
	if((f2 = open(path2,O_RDONLY,ALL_OWNER_PERMI)) == -1){
		perror("Erro na abertura do segundo ficheiro!");
		exit(-1);
	}

	do{
		n1 = read(f1,&c1,sizeof(char));
		n2 = read(f2,&c2,sizeof(char));
		car++;
		if(c1 == '\n' && c2 == '\n'){
			line++;car = 0;
		}
	}while(c1 == c2 && (n1 != 0 && n2 != 0));
	
	if(n1 == 0 && n2 == 0){
		write(1,"Os ficheiros são iguais!",25*sizeof(char));
	}else{
		size1 = strlen(path1);
		size2 = strlen(path2);
		write(1,path1,size1);write(1," ",sizeof(char));write(1,path2,size2);write(1," differ: char ",14*sizeof(char));
		sprintf(num1,"%d",car);
		sprintf(num2,"%d",line);
		size1 = strlen(num1);
		size2 = strlen(num2);
		write(1,num1,size1);write(1,", line ",7*sizeof(char));write(1,num2,size2);
	}
}

int main(int argc, char **argv){
	
	//ex_3_1();
	//ex_3_2(argv[1]);
	//f1(argv[1]);
	//f2();
	//f3();
	//int n3 = (int)argv[1];
	//ex_3_3(getNumber(argv[1]));
	
	/*
	int n4;
	char buf[12];
	n4 = readln(0,buf,12*sizeof(char));
	write(1,buf,(n4+1)*sizeof(char));	//	n4 + 1, para aparecer o '\n';
	*/

	/*
	int f;

	if(argc == 2){
		f = open(argv[1], O_RDONLY, ALL_OWNER_PERMI);
		nl1(f);
	}else{
		nl1(0);
	}
	*/

	//exercício 3_7:
	
	int f;
	if((f = open(argv[1], O_RDONLY, ALL_OWNER_PERMI)) == -1){
		perror("Erro na abertura do ficheiro: text1.txt");
		exit(-1);
	}

	Buffer_t* buffer = (Buffer_t*) malloc(sizeof(struct buffer_t));
	
	create_buffer(f,buffer,10 * KB);

	ssize_t size = readln1(buffer,buffer->line);
	write(1,buffer->buf,size*sizeof(char));

	destroy_buffer(buffer);
	
	//my_cat_files(argc, argv[1]);

	//este código é necessário para o exercício do grupo 4, exercício 3;
	/*
	char **paths;
	int i;
	paths = malloc(argc*sizeof(char*));
	for(i = 0; i < argc; i++){
		paths[i] = malloc(20*sizeof(char));
		paths[i] = argv[i+1];
	}
	my_head(argc-1, paths);
	*/

	//my_cmp(3,"text1.txt","text2.txt");
	//my_cmp(argc,argv[1],argv[2]);
	
	return 0;
}