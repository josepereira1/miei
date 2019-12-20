#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*chapter 5*/

/* 5.2 */
/*
void swap(int *a, int *b){
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

int main(void){
	int x=1, y=2;
	printf("%d - %d\n",x,y);
	swap(&x,&y);
	printf("%d - %d\n",x,y);
	
	return 0;
*/

/* 5.4 */
/*
void printString(char *s){
	int i  = 0;
	while((*(s+i)) != '\0'){
		putchar(*(s+i));i++;
	}
	putchar('\n');
}

int main(void){
	char *s = "ola";
	printString(s);
	return 0;
}

*/

/*
void fun(int *v){
	printf("%d\n",(*(v-1)));
	printf("%d\n", v);
}
int main(void){
	int v[3] = {1,2,3};
	fun(&v[0]);
}
*/

/*
int main(void){
	int i = 0;
	int *p;
	p = (int*)malloc(3*sizeof(int));
	p[0] = 1;
	p[1] = 2;
	p[2] = 3;
	printf("%d\n", p);
	p = p + i; //sendo i a posição no array, isto dá-me o endereço do elemento que está nessa posição
	printf("%d\n", (*p));
	return 0;
}
*/

/*
#define ALLOCSIZE 10000 //size of availabel space

static char allocbuf[ALLOCSIZE]; //storage for alloc
static char *allocp = allocbuf; //next free position

char * alloc(int n){ //return pointer to n characters
	if(allocbuf + ALLOCSIZE - allocp >= n){ //it fits
		allocp += n;
		return allocp - n; //old p
	}else{
		return 0;
	}

}

void afree(char *p){ //free storage pointed to by p
	if(p >= allocbuf && p < allocbuf + ALLOCSIZE)
		allocp = p;

}
*/

/* strcpy: copy t to s; pointer version 3 */

/*
void strcpy1(char *s, char *t){
	while(*s++ = *t++)
		;
}

int main(void){
	char *array1 = "Hello World!", array2[13];
	strcpy1(array2,array1);
	printf("%s\n", array2);
	return 0;
}
*/

/* strcmp: return <0 if s<t, 0 if s==t, >0 if s>t */
/*
int strcmp1(char *s, char *t){
	for( ; *s == *t; s++, t++)
		if(*s == '\0')
			return 0;
	return *s - *t;
}

int main(void){
	char *s1 = "ola1", *s2 = "ola";
	printf("%d\n", strcmp1(s1,s2));
	return 0;
}
*/

/*
char * strcat1(char *s, char *t){
	char *aux, *array;
	
	int size = strlen(s) + strlen(t) +1;
	
	aux = (char*)malloc(size*sizeof(char));
	
	array = aux;
	while(*s != '\0'){
		*aux = *s;
		aux++;s++;
	}
	while(*t != '\0'){
		*aux = *t;
		aux++, t++;
	}
	
	return array;
}


int main(void){
	char *s = "Hello ", *t = "World!";
	printf("%s\n", strcat1(s,t));
	return 0;
}

*/

/*chapter 8*/

/* 8.2 */

#include <unistd.h>	// chamadas ao sistema: defs e decls essenciais 
#include <fcntl.h>
/*
int main(void){ //copy input to output
	char string[15];
	int n;
	while((n = read(0, string, 15)) > 0){
		write(1,string, n);
	}
	return 0;
}
*/

/* getchar: unbuffered single character input */

int getchar1(void){
	char c;
	return (read(0, &c, 1) == 1) ? (unsigned char) c : EOF;
}
int main(void){
	int c;
	c = getchar1();
	putchar(c);
	return 0;
}