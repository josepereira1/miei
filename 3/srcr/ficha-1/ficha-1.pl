%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SIST. REPR. CONHECIMENTO E RACIOCINIO - MiEI/3

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Base de Conhecimento com informacao genealogica.

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: Declaracoes iniciais

:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).
:- set_prolog_flag( unknown,fail ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado filho: Filho,Pai -> {V,F}

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado pai: Pai,Filho -> {V,F}
pai(P,F) :-
	filho(F,P).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado avo: Avo,Neto -> {V,F}
avo( A,N ) :- 
	filho( P, A ), 
	filho( N, P ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado bisavo: Bisavo,Bisneto -> {V,F}
bisavo( bisavo,bisneto ) :- 
	filho( f1, bisavo), 
	filho(f2, f1), 
	filho(Bisneto, f2).



%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado descendente: Descendente,Ascendente -> {V,F}

filho( joao,jose ).
filho( jose,manuel ).
filho( carlos,jose ).

pai( paulo, filipe ).
pai( paulo, maria ).

avo( antonio,nadia ).
neto( nuno, ana ).

sexo(joao,masculino).
sexo(jose,masculino).
sexo(joana,feminino).
sexo(maria,feminino).

%xiv
neto(N,A) :-
	filho(N,P),
	filho(P,A).

%xv
descendente( D,A ) :-
	filho( D,A );	%	o ';' representa o 'ou'
		filho( D, X), descendente(X,A).

%xvi
grau( D,A,1) :- filho(D,A).	%	caso de paragem
grau( D,A, G ) :-
	filho( D, X), grau(X,A, N), G is N + 1.

%	o is é como um igual, e tenho que atribui o 
%	valor a uma nova variável, pois o PROLOG é 
%	uma linguagem declarativa, logo os valores 
%	atribuídos a letras são constantes, logo não mudam.

filho( andre, pedro ).
filho( pedro, catarina ).
filho( catarina, miguel ).
filho( miguel, gabriela ).
filho( gabriela, henrique ).


%xvii
grauAvo(N,A) :- grau(N,A,2).

%xviii
grauBisavo(X,Y) :- grau(X,Y,3).

%xix
grauTrisavo(X,Y) :- grau(X,Y,4).

%xx
grauTetravo(N,A) :- grau(N,A,5).

%xxi
filho( joao,jose ).

%xxii
pai( jose, joao).

%xxiii
sexo(joao,masculino).

%xxiv
sexo(jose, feminino).

%xxv
filho( _,jose).

%xxvi
filho( jose, joao).

%xxvii
avo( manuel , jose ).

%xxviii
avo( manuel , joao ).

%xxix
neto( carlos, _).











