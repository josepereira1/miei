%{
	#define _GNU_SOURCE 
	#include <stdio.h>
	#include <math.h>
	int yylex();
	void yyerror(char *s);
	int tabEnd[26]; //tabela de endereços - mapeia letra com posição tabEnd[0]='a'
	int endereco(char* x){ return tabEnd[x[0]-'a']; }
	int ultimo = -1; //ultimo endereço ocupado no tabEnd
	void aloca(char* var){ tabEnd[var[0]-'a']=++ultimo; }
%}
%token NUM VAR PRINT INT ID READ STRING IF ELSE WHILE
%union{
	double n;
	char * c;

}
%type <n>  NUM
%type <c>  ID decls insts inst exp tipo parc fact STRING ifinst cond whileinst
%%
prog	: decls insts {printf("%s\nstart\n%s\nstop\n",$1,$2);}
		;

decls	: decls VAR ID ':' tipo ';' { asprintf(&$$, "%s\npushi 0\n", $1); 
									  aloca($3);
									}
		|	{$$="";}
		;
insts	: insts inst {asprintf(&$$, "%s\n%s", $1,$2); }
		|	{$$="";}
		;

inst 	: ID '=' exp ';' 				{asprintf(&$$, "%s\nstoreg %d\n", $3,endereco($1)); }
		| PRINT exp ';'					{asprintf(&$$, "%s\nwritei\n", $2);}
		| READ STRING ',' ID ';' 		{asprintf(&$$, "pushs %s\nwrites\nread\natoi\nstoreg %d\n", $2, endereco($4));}
		| READ ID ';' 					{asprintf(&$$, "%s\nread\natoi\nstoreg %d\n", endereco($2));}
		| ifinst 						{$$=$1;}
		| '{' insts '}' 				{$$=$2;}
		;

exp		: exp '+' parc					{asprintf(&$$, "%s\n%s\nadd\n", $1,$3);} 
		| exp '-' parc					{asprintf(&$$, "%s\n%s\nsub\n", $1,$3);} 
		| parc							{$$=$1;}
		;

parc	: parc '*' fact	{asprintf(&$$, "%s\n%s\nmul\n", $1,$3);} 
		| parc '/' fact	{asprintf(&$$, "%s\n%s\ndiv\n", $1,$3);} 
		| fact	{$$=$1;}
		;

fact	: ID 	{asprintf(&$$, "pushg %d\n", endereco($1));}
		| NUM	{asprintf(&$$, "pushi %.0f\n", $1);}
		| '(' exp ')' {$$=$2;}
		;
tipo	: INT {$$="";}
		;

ifinst  : IF '(' cond ')' inst {asprintf(&$$, "%sjz fimse\n%s\nfimse:\n", $3, $5);} 
		| IF '(' cond ')' inst ELSE inst {asprintf(&$$, "%sjz else:\n%s\nfimse:\njump fimse:\nelse:\n%sfimse:", $3, $5, $7);}
		;

whileinst : WHILE '(' cond ')' inst {asprintf(&$$, "while:\n%sjz fimwhile\n%sjump while\nfimwhile:\n", $3, $5)} 

cond 	: exp{$$=$1;}
		;

%%
#include "lex.yy.c"
void yyerror(char *s){fprintf(stderr,"Erro:%sLine:%d\n",s, yylineno);}
int main(){

	yyparse();
	
}