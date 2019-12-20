%code{
	#define _GNU_SOURCE 
	#include <stdio.h>
	#include <math.h>
	int yyerror(char *s){fprintf(stderr,"Erro:%s\n",s);}
	int yylex();
}
%token NUM VAR PRINT INT ID
%union{
	double n;
	char * c;

}
%type <n>  NUM
%type <c>  ID decls insts inst exp tipo
%%
prog	: decls insts {printf("%s\n%s\n",$1,$2);}
		;

decls	: VAR ID ':' tipo ';'
		|
		;
insts	: insts inst {asprintf(&$$, "%s\n%s", $1,$2); }
		|  {$$='';}
		;

inst 	: ID '=' exp ';' {asprintf(&$$, "%s\n%s", $3,$); }
		| PRINT exp ';'
		;

exp		: NUM '+' NUM
		| ID
		;
tipo	: INT
		;
%%
#include "lex.yy.c"
int main(){

	yyparse();
	
}