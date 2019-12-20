#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>

char** strToTags(char *tags){ // separa a string com todas as tags 

    int i, count = 1, v = 0;

    for(i = 0; tags[i]; i++) if (tags[i] == ' ') count++; // contador do número de tags
  	printf("%d\n", count);
    char **res = malloc(sizeof(char*) * count);
    res[v++] = tags;
    res[count - 1] = (char*) NULL;
 
    for (i = 0; tags[i]; i++){
      if (tags[i] == ' '){
        tags[i] = '\0'; // sem esta linha cada apontador mostrava a string toda desde o inicio
        if (tags[i + 1] == '\0') break;
        res[v++] = tags + i + 1; 
      }
    }

    return res;
}

/*
//exercício 1:
int main(int argc, char**argv){
	
	int f1, f2, f3, n;
	char *str = "hello world", *buf, **cmds;
	pid_t id;
	int status;

	printf("argv[0]=%s ||  argv[1]=%s\n", argv[0],argv[1]);

	buf = malloc(1024*sizeof(char));
	
	if((f1 = open("passwd.txt", O_RDONLY, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(-1);
	}

	if((f2 = open("saida.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(-1);
	}

	if((f3 = open("error.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(-1);
	}
	
	dup2(f1,0);
	dup2(f2,1);
	dup2(f3,2);

	close(f1);
	close(f2);
	close(f3);
	
	if((id = fork()) == -1){
		perror("ERRO NA CRIAÇÃO DO PROCESSO!");
		_exit(-1);
	}

	if(id == 0){
		if(argc > 1){
			execvp(argv[1], argv + 1);
		}else{
			n = read(0, buf, 1024);
			cmds = strToTags(buf);
			printf("cmds[0]=%s || cmds[1]=%s || cmds[2]=%s\n", cmds[0], cmds[1], cmds[2]);
			execvp(cmds[0], cmds +1);
		}
	}else{
		wait(&status);
	}
	return 0;
}
*/

/*
//	exercício 2:
int main(void){
	int f0, f1, f2, n = 0, status;
	pid_t id;
	char* buf = (char*) malloc(50*sizeof(char));

	if((f0 = open("input.txt", O_RDONLY)) == -1){
		perror("Erro na abertura do ficheiro!");
		_exit(1);
	}

	if((f1 = open("output.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(2);
	}

	if((f2 = open("error.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(3);
	}

	dup2(f0,0);
	dup2(f1,1);
	dup2(f2,2);

	close(f0);
	close(f1);
	close(f2);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(4);
	}

	if(id == 0){
		n = read(0, buf, 50);
		write(1, buf, n);
		_exit(5);
	}else{
		wait(&status);
		_exit(6);
	}


	return 0;
}
*/

/*
//exercício 3
int main(void){
	int f0, f1, f2, n = 0, status;
	pid_t id;
	char* buf = (char*) malloc(50*sizeof(char));

	if((f0 = open("input.txt", O_RDONLY)) == -1){
		perror("Erro na abertura do ficheiro!");
		_exit(1);
	}

	if((f1 = open("output.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(2);
	}

	if((f2 = open("error.txt", O_CREAT | O_RDWR | O_TRUNC, 0666)) == -1){
		perror("Erro na criação do ficheiro!");
		_exit(3);
	}

	dup2(f0,0);
	dup2(f1,1);
	dup2(f2,2);

	close(f0);
	close(f1);
	close(f2);

	if((id = fork()) == -1){
		perror("Erro na criação do processo!");
		_exit(-1);
	}

	if(id == 0){
		execlp("wc","coisinho", NULL);
	}else{
		wait(NULL);
	}
}
*/

void files(char** file1, char** file2){
	char* tmp1, *tmp2;
	int size1, size2;

	size1 = strlen(*file1);size2 = strlen(*file2);

	printf("%d\n", size1);

	tmp1 = (char *)malloc((size1 -5)*sizeof(char));
	tmp1 = (char *)malloc((size2 -5)*sizeof(char));
	
	memcpy(tmp1, (*file1) + 4, size1 - 5);
	memcpy(tmp2, (*file2) + 4, size2 - 5);

	*file1 = malloc(strlen(tmp1));

	*file2 = malloc(strlen(tmp2));

	memcpy((*file1), tmp1, strlen(tmp1));
	memcpy((*file2), tmp2, strlen(tmp2));

	printf("s1=%s || s2=%s\n", (*file1), (*file2));

}

int main(int argc, char** argv){

	/*
	if(argv[1][0] == '['){

	}
	return 0;*/

	char* s1 = "[-i ficheiro.txt]", *s2 = "[-o text.txt]";
	files(&s1,&s2);
	printf("s1=%s || s2=%s\n", s1, s2);
}








