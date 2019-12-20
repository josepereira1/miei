#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <unistd.h>     /* chamadas ao sistema: defs e decls essenciais */


//	int pipe(pd[2]);	//	recebe um array com 2 elementos
#define K 1024
#define MB K*1024

void ex_5_1(){
	int p[2];
	pid_t id;
	char *buf;

	pipe(p);	//	criação do pipe;

	buf = malloc(K*sizeof(char));
	
	if((id = fork()) == -1){	//	criação do processo;
		perror("Erro na criação do processo!\n");
		_exit(-1);
	}
	/*
	if(id == 0){
		close(p[1]);
		printf("Filho está a ler:\n");
		read(p[0],buf,K*sizeof(char));
		printf("Filho leu: %s\n", buf);
		_exit(-1);
	}else{
		close(p[0]);	//	fecho isto, pq não vou fazer nada com este filde no processo pai;
		printf("Pai está a escrever:\n");	
		//sleep(5);
		write(p[1],"hello world!", 12*sizeof(char));
		wait(NULL);
	}*/

	if(id == 0){	//	esta é uma versão inversa da que está em cima, ou seja, o filho escreve e o pai lê
		close(p[0]);
		printf("Filho está a escrever:\n");
		write(p[1],"hello world!", 12*sizeof(char));
		sleep(5);
		close(p[1]);	//	pq funcionou por sorte, visto que o filho acabou antes do pai;
		_exit(-1);
	}else{
		close(p[1]);	//	fecho isto, pq não vou fazer nada com este filde no processo pai;
		printf("Pai está a ler:\n");	
		read(p[0],buf,K*sizeof(char));
		printf("Filho leu: %s\n", buf);
		wait(NULL);
	}
}

void ex_5_2(){
	int p[2], ctn = 0, status;
	pid_t id;
	char buf;

	pipe(p);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!\n");
		_exit(-1);
	}

	if(id == 0){
		close(p[1]);
		printf("Filho está a ler:\n");
		while(read(p[0],&buf,sizeof(char)) > 0)
			write(1,&buf, sizeof(char));
		_exit(0);
	}else{
		close(p[0]);	//	fecho isto, pq não vou fazer nada com este filde no processo pai;
		printf("Pai está a escrever:\n");	
		write(p[1],"hello world!", 12*sizeof(char));
		close(p[1]);	//	temos que fechar o p[1] pq senão o filho vai estar sempre à espera de texto;
		wait(NULL);
		//sleep(5);
	}
}

char** aux_ex_5_3(char* fstBuf, char **sndBuf){
	int i = 0, cnt = 0, palavra, letra_do_fst, letra_do_snd = 0;
	while(fstBuf[i] != '\0'){
		if(fstBuf[i] == ' ')cnt++;
		i++;
	}
	cnt = cnt +3;

	sndBuf = malloc(cnt*sizeof(char*));

	for(i = 0; i < cnt; i++)sndBuf[i] = malloc(20*sizeof(char));
	
	sndBuf[0] = "wc";

	letra_do_fst = 0;
	letra_do_snd = 0;
	palavra = 1;

	int size = strlen(fstBuf);

	for(letra_do_fst = 0; letra_do_fst < size; letra_do_fst++){
		//printf("%c\n", fstBuf[letra_do_fst]);
		//printf("palavra: %d || letra_do_fst: %d || letra_do_snd: %d\n",palavra, letra_do_fst, letra_do_snd );
		if(fstBuf[letra_do_fst] != ' '){
			sndBuf[palavra][letra_do_snd] = fstBuf[letra_do_fst];
			letra_do_snd++;
		}else{
			palavra++;
			letra_do_snd = 0;
		}
		//printf("cheguei ao fim do for!!!!\n");
		//printf("palavra: %d || letra_do_fst: %d || letra_do_snd: %d\n",palavra, letra_do_fst, letra_do_snd );
	}
	palavra++;
	sndBuf[palavra] = NULL;
	return sndBuf;
}

void ex_5_3(){
	int p[2], n = 0, status;
	pid_t id;
	char *fstBuf, *sndBuf, **thrBuf;

	fstBuf = malloc(K*sizeof(char));

	while((n = read(0,fstBuf,K*sizeof(char))) > 0);

	sndBuf = malloc(n*sizeof(char));

	memcpy(sndBuf, fstBuf,n+1);

	pipe(p);

	if((id = fork()) == -1){
		perror("ERRO NA CRIAÇÃO DO PROCESSO!");
		_exit(-1);
	}

	if(id == 0){
		close(p[1]);
		read(p[0],sndBuf,n);
		close(p[0]);
		thrBuf = aux_ex_5_3(sndBuf, thrBuf);
		printf("%s\n", thrBuf[0]);

		//execvp("wc", thrBuf);
		_exit(1);
	}else{
		close(p[0]);
		write(p[1], sndBuf, n);
		close(p[1]);
		wait(&status);
	}
}

void ex_5_5(){

	int p[2], i, n;
	pid_t id;
	char *buf = malloc(K*sizeof(char));

	pipe(p);

	if((id = fork()) == -1){
		perror("ERRO! Na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		dup2(p[1],1);
		execlp("grep","grep", "-v", "ˆ#", "/etc/passwd", NULL);
	}else{
		if((id = fork()) == -1){
		perror("ERRO! Na criação do processo!");
		_exit(-1);
		}
		
		if(id == 0){
			if((n = read(p[0],buf,K)) < 0){
				perror("ERRO NO READ()!");
				_exit(-1);
			}
			write(1,buf,n);
			//execlp("cut","cut", "-f7" "-d:", NULL);
	}

}
}


//	no exercício 7 temos que fazer uma cena semelhante à barra no terminal, que é como um pipeline 
//  que posso escrever um monte de comandos, mas ele só irá apenas mostrar o output do último, visto que o primeiro 
//	manda para o segundo e assim sucessivamente;

int main(int argc, char** argv){
	//pipe[0] = leitura
	//pipe[1] = escrita
	//ex_5_1();
	ex_5_2();
	//ex_5_3();
	//ex_5_5();

	
	/*
	char *fstBuf = "ola ole";
	char **sndBuf;
	
	sndBuf = aux_ex_5_3(fstBuf,sndBuf);
	printf("%s\n", sndBuf[0]);
	*/
	return 0;
}