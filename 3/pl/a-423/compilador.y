%{
	#define _GNU_SOURCE
    #include <stdio.h>
	#include <math.h>
	int yyerror(char *s){ fprintf(stderr,"Erro:%s\n",s); }
	int yylex();
	int tabelaEnderecos[26]; 	//	tabela de endereços - mapeia letra com posição
	int endereco(char* x){return tabelaEnderecos[x[0]-'a'];}
	int ultimoOcupado = -1;		//	último endereço ocupado no tabelaEnderecos
	void aloca(char* var){ ultimoOcupado++; tabelaEnderecos[var[0]-'a']=ultimoOcupado; }
%}

%token  NUM VAR PRINT INT ID

%union{ 
	double n;  
    char* c;
}

%type <n> NUM
%type <c> ID declaracoes instrucoes instrucao expressao tipo parcela

%%

programa		: declaracoes instrucoes {printf("%s\nstart\n%s\nstop\n", $1, $2);}
		    	;

declaracoes 	: declaracoes VAR ID ':' tipo ';' { asprintf(&$$, "%s\npushi 0\n", $1); 
													aloca($3);}
				| {$$="";}
		        ;

instrucoes 		: instrucoes instrucao { asprintf(&$$, "%s\n%s", $1, $2); }
				| {$$="";}
			    ;

instrucao 		: ID '=' expressao ';' { asprintf(&$$, "%s\nstoreg %d\n", $3, endereco($1)); }
			    | PRINT expressao ';'  { asprintf(&$$, "%s\nwritei\n", $2); }
			    ; 

expressao 		: expressao '+' parcela { asprintf(&$$, "%s\n%s\nadd\n", $1, $3); }
		    	| parcela {$$=$1;}
		    	;

parcela 		: ID  { asprintf(&$$, "pushg %d\n", endereco($1)); }
				| NUM { asprintf(&$$, "pushi %.0f\n", $1); }
				;

tipo			: INT 	{$$="";}
		    	;

%%

#include "lex.yy.c"

int main(){
   yyparse();
   return 0;
}
