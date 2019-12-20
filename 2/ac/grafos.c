#include <stdio.h>
#include <stdlib.h>
#define N 6

typedef int GrafoM[N][N];

typedef struct aresta{
	int dest;
	int peso;
	struct aresta *prox;
}*GrafoL[N];

void init(GrafoL g){
	for(int i=0;i<N;i++)
		g[0] = malloc(sizeof(struct aresta));
		g[0] = NULL;
}

void matParaLista(GrafoM o, GrafoL d){
	int l,c;
	struct aresta *x;
	for(l = 0; l<N; l++)d[l]=NULL;	//	"limpar d"

	for(l = 0;l<N;l++){
		for(c = 0;c<N;c++){
			if(o[l][c] != 0){
				x = malloc(sizeof(struct aresta));
				x->dest = c;
				x->peso = o[l][c];
				x->prox = d[l];
				d[l] = x;
			}
		}
	}
}

void printGrafo(GrafoL g){
	struct aresta *x;

	for(int i = 0; i < N; i++){
		printf("g[%d]=", i);
		for(x = g[i]; x !=NULL;x = x->prox){
			printf("%d,%d ->", x->dest, x->peso);
		}
		printf("* \n");
	}
}

void printMatriz(GrafoM arr){
	for(int i = 0; i<N; i++){
		for(int j = 0; j<N; j++){
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
}

void listaParaMat(GrafoL o, GrafoM d){
	struct aresta *x;

	for(int l = 0; l < N; l++)
		for(int c = 0; c < N; c++)
			d[l][c] = 0;

	for(int i = 0; i < N; i++){
		for(x = o[i]; x!=NULL; x = x->prox){
			d[i][x->dest] = x->peso;
		}
	} 
}

int capacidadeVerticeNaMatriz(GrafoM m, int v){
	//	capacidade é igual ao entra menos o que sai do nó
	int r = 0;

	for(int i = 0; i < N; i++){
		r+=m[i][v];
		r-=m[v][i];
	}
	return r;
}

int capacidadeVerticeNoGrafo(GrafoL g, int v){
	struct aresta *x;
	int r = 0;

	for(x = g[v]; x!=NULL;x=x->prox)r-=x->peso;

	for(int i = 0; i <N; i++){
		for(x = g[i]; x!=NULL && i != v; x = x->prox){	//	o i!=v evita que ele vá procurar na sua própria linha
			if(x->dest == v){
				r+=x->peso;
				break;	
				//	este break aumenta a eficiência, 
				//	pois, quando se encontra o nó pertendido,
				//  já não irá ocorrer mais nas arestas deste nó
			}
		}
	}
	return r;
}


int succN (GrafoL g, int v, int max){
	struct aresta *x;
	int cnt = 0, i, queue[N], visitados[N], distancias[N], inicio, fim;

	for(i = 0; i < N; i++)visitados[i]=0;
	queue[0] = v;
	inicio = 0;
	fim = 1;
	visitados[v]=1;
	distancias[v] = 0;
	while(inicio != fim && distancias[queue[inicio]] <= max){	//	este distancias na condição melhora eficientemente o algoritmo
		cnt++;
		v = queue[inicio++];	//	busca o próximo node da fila
		for(x=g[v];x!=NULL;x=x->prox){	//	percorre os sucessores do node v
			if(visitados[x->dest]==0){	//	apenas vai fazer o que está no if, se ainda não foi visitado
				visitados[x->dest] = 1;	//	passa a visitado
				queue[fim++]=x->dest;	//	entra para a fila, para os seus sucessores serem testados
				distancias[x->dest] = distancias[v] + 1;	//	calcula-se a distância deste sucessor em relação ao v
			}
		}
	}
	return cnt;
}


int naoAlcansavel(GrafoL g, int o){
	struct aresta *x;
	int v, visitados[N], queue[N], inicio, fim;
	for(int i = 0; i < N; i++)visitados[i] = 0;

	queue[0] = o;
	inicio = 0;
	fim = 1;
	visitados[o] = 1;
	while(inicio != fim){
		v = queue[inicio++];
		for(x = g[v])
	}

}


int main(void){
	GrafoL g;
	GrafoM arr,clone;

	for(int i = 0; i<N; i++)
		for(int j = 0; j < N;j++)
			arr[i][j] = 0;

	arr[0][1] = 4;arr[0][2] = 3;arr[1][4] = 4;arr[2][0] = 2;arr[3][2] = 1;
	arr[3][5] = 2;arr[4][3] = 3;arr[5][4] = 1;

	//init(g);
	//printMatriz(arr);
	matParaLista(arr,g);
	printGrafo(g);
	printf("succN=%d\n", succN(g,0,1));

	//listaParaMat(g,clone);
	printMatriz(arr);

	//printf("capacidade do vértice %d = %d\n", 3, capacidadeVerticeNaMatriz(arr,3));
	//printf("capacidade do vértice %d = %d\n", 3, capacidadeVerticeNoGrafo(g,3));

	return 0;
}