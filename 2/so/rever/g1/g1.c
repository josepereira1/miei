#include <unistd.h>   /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>    /* O_RDONLY, O_WRONLY, O_CREAT, O_* */
#include <stdlib.h>
#include <stdio.h>

#include <string.h>

/*
int     open(const char *path, int oflag [, mode]);
ssize_t read(int fildes, void *buf, size_t nbyte);
ssize_t write(int fildes, const void *buf, size_t nbyte);
int     close(int fildes);
*/

typedef struct buffer_t{
	
	void *buf;	//	buffer com 10KB, que vai guardar todas as linhas lidas pelo read de uma só vez;
	int filde;	//	file descriptor;
	size_t size;	//	size do buffer principal;
	void *line;	//	este ponteiro vai apontar para a linha que eu vou ler, a linha que o readln vai retornar;
	int last;
} Buffer_t, *p_buffer_t;



#define K 1024
#define MB K*1024

void mycat(){
	int n;
	char ch;

	while((n=read(0,&ch,1)) > 0){
		write(1,&ch,1);
	}
}

void creatFile(char *nome){
	int n, f,i;
	char ch = 'a';
	if((f = open(nome, O_CREAT | O_WRONLY, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(-1);
	}
	for(i = 0; i< MB; i++)write(f,&ch,1);
}

void mycatv2(int argc, int N, char *nome){
	int n, f;
	char *c = NULL;
	c = malloc(N*sizeof(char));
	if(argc == 2){
		while((n = read(0,c,N)) > 0)write(1,c,n);
	}else{
		if((f = open(nome, O_RDONLY, 0666)) == -1){
			perror("Erro na abertura do ficheiro!");
			_exit(-1);
		}
		while((n = read(f,c,N)) > 0)write(1,c,n);
	}

}

ssize_t readln(int fildes, void *buf, size_t nbytes){
	int n = 1, i = 0;
	char* str = NULL;
	str = (char*) malloc(nbytes*sizeof(char));
	
	while(i < nbytes && str[i] != '\n' && (n = read(fildes,&str[i],1)) > 0){
		if(str[i] == '\n')
			break;
		i++;
	}
	memcpy(buf, str, i);
	return i;
}

void mynl(int f, int N){
	int n, i = 1;
	char *buf, num[12], ch = '\n';
	
	buf = malloc(N*sizeof(char));
	
	while((n = readln(f, buf, N)) > 0){
		if(n > N)break;
		sprintf(num,"%d",i);write(1,"    ",5);write(1,num, strlen(num));write(1,"   ",3);write(1,buf,n);write(1,&ch,1);
		i++;
	}
}

int create_buffer(int filde, p_buffer_t buffer, size_t nbyte){
	buffer->buf = malloc(10*K*sizeof(char));
	buffer->filde = filde;
	buffer->size = nbyte;
	buffer->line  = malloc(nbyte*sizeof(char));
	return 1;
}

int create_buffer1(int filde, p_buffer_t buffer, size_t nbyte){
	buffer->buf = malloc(10*K*sizeof(char));
	buffer->filde = filde;
	buffer->size = nbyte;
	buffer->line  = malloc(nbyte*sizeof(char));
	buffer->last = 0;
	return 1;
}

/*
ssize_t readln1(p_buffer_t buffer, void **buf){
	int n, i = 0;
	char* tmp = NULL;
	char* line = buffer->line;
	char* bif_buf = buffer->buf;

	if(bif_buf == NULL){
		tmp = malloc(buffer->buffer_size);
		n = read(buffer->fildes, tmp, buffer->buffer_size);
		while(tmp[i] != '\n' && i < buffer->buffer_size)
			i++;
		memcpy(line, tmp, i);
		bif_buf = malloc(10*1024*sizeof(char));
		bif_buf = tmp + i;
		tmp[i] = '\0';
		*buf = (char*) tmp;
		return i;
	}else{
		tmp = malloc(buffer->buffer_size);
		int size = strlen(bif_buf);
		if(size > buffer->buffer_size){
			memcpy(tmp,bif_buf, buffer->buffer_size);
			bif_buf = bif_buf + buffer->buffer_size;
			*buf = (char*) tmp;
		    line = (char*)tmp;
			return buffer->buffer_size;
		}else{
			memcpy(tmp,bif_buf, size);
			read(buffer->fildes, tmp + size, buffer->buffer_size-size);
			*buf = (char*) tmp;
			line = (char*)tmp;
			return size;
		}
	}
	return 0;
}*/

ssize_t readln2(struct buffer_t *buffer, void **buf){
	char* big_buf = buffer->buf;
	char* line = buffer->line;
	ssize_t size = buffer->size;
	int* last = &(buffer->last), len = 0, i = 0;
	int f = buffer->filde;
	char* str;

	len = strlen(big_buf);

	if(*last != len){
		if(len > size){
			memcpy(line, big_buf, size);
			line[size] = '\0';
			*buf = line;
			printf("str=%s\n", str);
			*last = *last * size;
			return size;
		}else{
			memcpy(line, big_buf, len);
			read(f, line + len, size-len);
			while(line[i] != '\n' && i < size)i++;
			line[i] = '\0';
			*buf = line;
			printf("str=%s\n", str);
			*last = 0;
			return i;
		}
	}else{
		read(f, line, size);
		while(line[i] != '\n' && i < size)i++;
		line[i] = '\0';
		*buf = line;
		printf("str=%s\n", str);
		big_buf = line + i;
		*last = i;
		return i;
	}
	return 0;
}

void mycatv3(int argc, int filde){
	int n, i = 1;
	char num, ch = '\n';
	char* buf = malloc(K*sizeof(char));
	if(argc > 1){
		while((n = read(filde, buf, K)) > 0)
		write(1, buf, n);
	}else{
		while((n = read(0, buf, K)) > 0)
		write(1, buf, n);
	}
}

void myhead(int argc, char** argv){
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

int main(int argc, char **argv){
	//mycat();
	//creatFile("text.dat");
	/*
	int n = atoi(argv[1]);
	mycatv2(argc, n, argv[2]);
	*/
	
	//char *buf = malloc(2);
	
	/*
	int f;
	if(argc > 1){
		if((f = open(argv[1], O_RDONLY, 0666)) == -1){
			perror("Erro na abertura do ficheiro!");
			_exit(-1);
		}
	}*/
	//int n = readln(f,buf, 4);
	//printf("buf=%s\n", buf);
	//printf("%d\n", n);
	//mynl(f, 50);

	
	struct buffer_t *buffer;
	size_t bytes = 5;
	char *buf;
	buffer = malloc(sizeof(struct buffer_t));
	create_buffer1(0,buffer, bytes);
	
	//mycatv3(argc, f);
	printf("num=%zd || buf=%s\n", readln2(buffer,&buf), buf);
	//myhead(argc, argv);
	  
	return 0;
}