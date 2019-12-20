#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define Pi 3.14151617

//ex1:
float soma(int a, int b){
	return (a+b);
}

//ex2:
float area(float a){
	return (a*a);
}

//ex3:
float perimetro(float a){
	return (a*4);
}

//ex4:
float volume(float h, float r){
	return(h*Pi*r*r);
}
//ex5:
float areaTriangulo(float b, float h){
	return((b*h)/2);
}

//ex6:
float precoAutmovel(char *s, float pf){
	float iva, rev;
	iva = pf*0.45;
	rev = pf*0.28;
	printf("Carro: %s\nPreço:%.2f Euros\n",s,(pf+iva+rev));
	return (pf + iva + rev);
}

//ex7:
float funcEmpresa(char *s, float h, int d){
	float sb, sl, descIRS, descINSS;
	sl = (12*8)+(40*d);
	sb = sl - (sl*0.085)-(sl*0.05);
	printf("Nome:%s\n",s);
	printf("Sálario líquido:%.2f Euros\n", sl);
	printf("Número de horas: %.2f horas\n",h);
	printf("Número de Dependentes:%d\n",d);
	printf("Descontos para o INSS:%.2f Euros\n",(sl*0.085));
	printf("Descontos para IRS:%.2f Euros\n",(sl*0.05));
	return (sb);
}

//ex8:
char * avaliacao(float nota){
	char *s1 = "Aprovado",*s2 = "Reprovado";
	return(nota>=9.5 ? s1:s2);
}

//ex9:
char * media(float n1, float n2){
	float media;
	if((n1 >= 8.5 || n2 >= 8.5) && (n1*0.4)+(n2*0.60) >= 9.5) return("Aprovado");
	else return("Reprovado");
}

//ex10:
void horaToAMPM(int h, int min){
	char *s;
	if (h >= 12) printf("%dh%dmin PM\n",h,min);
	else printf("%dh%dmin AM\n",h,min);
}

//ex11:
void converte(float bytes){
	int i = 0;
	
	while(bytes >= 1024){
		bytes = (float)(bytes/1024);
		i++;
	}
	
	switch(i){
		case 1:
		printf("%.2f K bytes\n", bytes);
		break;

		case 2:
		printf("%.2f M bytes\n", bytes);
		break;

		case 3:
		printf("%.2f G bytes\n", bytes);
		break;

		case 4:
		printf("%.2f T bytes\n", bytes);
		break;

		case 5:
		printf("%.2f P bytes\n", bytes);
		break;
	}
}

//ex12:
void qualitativa(int nota){
	if(nota >= 0 && nota < 5){
		printf("Péssimo!\n");
	}else{
		if(nota >= 5 && nota < 8){
			printf("mau!\n");
		}else{
			if(nota >= 8 && nota < 10){
				printf("insuficiente!\n");
			}else{
				if(nota >= 10 && nota < 12){
					printf("suficiente!\n");
				}else{
					if(nota >= 12 && nota < 16){
						printf("bom!\n");
					}else{
						printf("excelente!\n");
					}
				}
			}
		}
	}
}

//ex13:
void paridade(int n){
	if (n % 2 == 0) printf("Par!\n");
	else printf("Ímpar!\n");
}

//ex14:
int menor(int a, int b){
	return(a>b?a:b);
}

//ex15:
int maiorDe3(int a, int b, int c){
	if(a>=b){
		if(a>=c)return a;
		else return c;
	}else{
		if(b>=c)return b;
		else return c;
	}
}

//ex16:
int testaTriangulo(int a, int b, int c){
	if(a+b>=c){
		if(a+c>=b){
			if(b+c>=a){
				return 1;

			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}else{
		return 0;
	}
}

//ex17:
void triangulo(float a, float b, float c){
	if(a==b && a==c){
		printf("equilátero!\n");
	}else{
		if((a==b && a != c) || (b==c && b != a) || (a==c && a != b)){
			printf("isósceles!\n");
		}else{
			printf("escaleno!\n");
		}
	}
}

//ex18:
int retangulo(float a, float b, float c){
	if((maiorDe3(a,b,c)*(maiorDe3(a,b,c))) == ((b*b) + (c*c))){
		return 1;
	}
	else{
		return 0;
	}
}

//ex19:
void converteKm(float km){
	if((1609/(km*1000)) > 5000){
		printf("%.5f km = %.5f Milhas, muito longe!\n", km, ((float)(1609/(km*1000))));
	}else{
		printf("%.5f km = %.5f Milhas\n", km, ((float)(1609/(km*1000))));
	}

}

//ex20:
void conversor(float valor, char esc){
	if(esc == 'a'){
		printf("%.2f euros = %2f escudos\n", valor, (float)(valor*200.482));
	}else{
		printf("%.2f escudos = %2f euros\n", valor, (float)(valor/200.482));
	}
}

//ex21:
void recebeNomes(){
	char nome[50];
	for(int i = 0; i < 20; i++){
		printf("%d -> Introduza o nome:\n",i+1);
		scanf(" %[^\n]s ", nome);
		printf("O nome inserido foi:\n%s\n", nome);
	}
}

//ex22:
void positivo(){
	int num = -1;
	while(num < 0){
		printf("Introduza um número positivo:\n");
		scanf("%d", &num);
	}
}

//ex23:
int maiorValor(int *v, int x){
	int maior = v[0];
	for(int i = 0; i < x; i++){
		if(v[i] >= maior)maior = v[i];
	}
	return maior;
}
//ex47:
void visualizarVetor(int *v, int x){
	for(int i = 0; i < x; i++){
		printf("%d\n",v[i]);
	}
}

//ex52:
void selection_sort(int *v, int x){ 
  int i, j, min, aux;
  for (i = 0; i < (x-1); i++) 
  {
     min = i;
     for (j = (i+1); j < x; j++) {
       if(v[j] < v[min]) 
         min = j;
     }
     if (i != min) {
       aux = v[i];
       v[i] = v[min];
       v[min] = aux;
     }
  }
}

//ex60:
void reverse(char *s, int x){
	int i, j;
	char aux;
	for(i = 0, j = (x-2); i < ((x-1)/2); i++, j--){
		aux = s[i];
		s[i] = s[j];
		s[j] = aux;
	}
	printf("%s\n",s);
}

int main(void){
	int v1[10] = {3,2,1,4,3,7,11,55,3,2};
	char v2[13] = "Universidade";
	//ex1:printf("%.2f\n",soma(1,2));
	//ex2:printf("%.2f\n",area(2));
	//ex3:printf("%.2f\n",perimetro(2));
	//ex4:printf("%.2f\n",volume(3,4));
	//ex5:printf("%.2f\n",areaTriangulo(3,4));
	//ex6:precoAutmovel("BMW",1000);
	//ex7:float emp = funcEmpresa("Pedro",40,3);printf("Sálario Bruto:%.2f Euros\n",emp);
	//ex8:printf("%s\n", avaliacao(9.49));
	//ex9:printf("%s\n",media(8.4,11));
	//ex10:horaToAMPM(12,21);
	//ex11:converte(1500);
	//ex12:qualitativa(20);
	//ex13:paridade(4);
	//ex14:printf("%d\n",menor(3,4));
	//ex15:printf("%d\n",maiorDe3(344,25,3));
	//ex16:printf("%d\n",testaTriangulo(1,1,50));
	//ex17:triangulo(1,3,4);
	//ex18:printf("%d\n",retangulo(1,2,3));
	//ex19:converteKm(50);
	//ex20:conversor(5000000,'b');
	//ex21:recebeNomes();
	//ex22:positivo();
	printf("O maior valor deste array é: %d\n", maiorValor(v1,10));






	//ex47:visualizarVetor(v1,10);
	//ex52:selection_sort(v1,10);
	//ex60:reverse(v2,13);
	return 0;
}