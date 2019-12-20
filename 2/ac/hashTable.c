#include <stdio.h>
#include <stdlib.h>

typedef struct hashtable{
	char date[8];
	float price;
	float liters;
	float km;
	float cons;

	struct hashtable *next;
}*HASTABLE[12];

void insertInf(HASTABLE *h[]){
	char tmp[8];

	printf("date:");
	scanf("%s",tmp);
	
}

int getYear(char s){
	while()
}

int hash(int n, int size){
	return((n % size)-1);
}
int main(void){
	HASTABLE *h18[12];
	insertInf(h1);
	return 0;
}