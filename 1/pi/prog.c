#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void duplicar(int* a, int* b);
void duplicar2(int a, int b);

typedef struct node {
    char* nome;
    char* sobrenome;
    int idade;
    struct node* amigo;
}Pessoa;

int main(int argc, char* args[]){
    Pessoa joana, luis;

    joana.nome = (char*) malloc(15*sizeof(char));

    luis.nome = (char*) malloc(15*sizeof(char));

    strcpy(joana.nome, "Joana");
    strcpy(luis.nome, "Luís");

    joana.amigo = &luis;

    Pessoa amigo = *(joana.amigo);

    char * nomeAmigo = *(*(joana.amigo)->nome);

    printf("nome = %s\n amigo = %s\n", joana.nome, nomeAmigo);
}


/*int main(int argc, char* args[]){
    int* p;
    int a = 2;
    p = &a;
    printf("%p\n", &p);
    printf("%p\n", p);
    printf("%d\n", *p);

    int* arr;

    arr = (int*)malloc(10*sizeof(int));

    printf("arr=%p\n", arr);
    printf("*arr=%d\n", *arr);

    for(int i = 0; i < 10; i++){
        *(arr+i) = i;
    }

    for(int i = 0; i < 10; i++){
        printf("%d\n", *(arr + i));
    }

    void* pointer;

    pointer = (void *) malloc(10*sizeof(char));

    *(char*)pointer = 'c';

    printf("pointer=%c\n", *(char*)pointer);

    printf("void size = %ld\n", sizeof(void));


    int** matrix;

    int x = 1, y =3;

    printf("inside main %p %p\n", &x, &y);

    duplicar2(x,y);

    duplicar(&x, &y);

    printf("x=%d\ny=%d\n", x,y);

    int *o;

    o = &x;

    printf("valor que está em o = %d\n", *o);

    free(o);

    printf("valor que está em o = %d\n", *o);

    int b = 2;

    int *pb = &b;

    matrix = &pb;

    printf("%p\n", &b);
    printf("%p\n", pb);
    printf("%d\n", **matrix);

    matrix = (int**)malloc(10*sizeof(int));

    printf("value of matrix = %p\n", matrix);

    for(int i = 0; i < 10; i++){
        matrix[i] = (int *) malloc(10*sizeof(int));
        *(*(matrix+i) + 5) = 1;
        //matrix[i][5] = 1;
    }

    printf("value of matrix = %p\n", *matrix);

    for(int i = 0; i < 10; i++){
        printf("%d\n", matrix[i][5]);
    }



    return 0;
}*/

void duplicar(int* a, int* b){
    printf("inside duplicar %p %p\n", a, b);
    *a = *a * 2;
    *b = *b * 2;
}

void duplicar2(int a, int b){
    a = a * 2;
    b = b * 2;
    printf("inside function x=%d and y=%d\n", a, b);
}