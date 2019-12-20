%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SIST. REPR. CONHECIMENTO E RACIOCINIO - MiEI/3

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Invariantes

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: Declaracoes iniciais

:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).
:- set_prolog_flag( unknown,fail ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: definicoes iniciais

:- op( 900,xfy,'::' ).
:- dynamic filho/2.
:- dynamic pai/2.
:- dynamic neto/2.
:- dynamic avo/2.
:- dynamic descendente/3.

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado filho: Filho,Pai -> {V,F,D}

filho( joao,jose ).
filho( jose,manuel ).
filho( carlos,jose ).

pai( jose,joao ).

neto( nuno, tobias ).
neto( serafim, joaquina ).

avo( tobias, nuno ).
avo( joaquim, nuno ).
avo( aurora, nuno ).

descendente( nuno, tobias, 2).
descendente( nuno, josefina, 3).



% Invariante Estrutural:  nao permitir a insercao de conhecimento
%                         repetido

% i)
+filho( F,P ) :: (solucoes( (F,P),(filho( F,P )),S ),
                  comprimento( S,N ), 
				  N == 1
                  ).

% ii) 
+pai( P,F ) :: (solucoes( (P,F),(pai( P,F )),S ),
                  comprimento( S,N ), 
				  N == 1
                  ).

% iii)
+neto( A,B ) :: (solucoes( (A,B),(neto( A,B )),S ),
                  comprimento( S,N ), 
				  N == 1
                  ).

% iv)

+avo( A,B ) :: (solucoes( (A,B),(avo( A,B )),S ),
                  comprimento( S,N ), 
				  N == 1
                  ).

% v)

+descendente( A,B,G ) :: (solucoes( (A,B,G),(descendente( A,B,G )),S ),
                  comprimento( S,N ), 
				  N == 1
                  ).

% Invariante Referencial: nao admitir mais do que 2 progenitores
%                         para um mesmo individuo

% vi)
+filho( F,P ) :: (solucoes( PS ,(filho( F,PS )),S ),
				  comprimento(S,N),
				  N =< 2
				  ).

% vii)

+pai( P,F ) :: (solucoes( PS ,(pai( F,PS )),S ),
				  comprimento(S,N),
				  N =< 2
				  ).

% vii)

+pai( _,F ) :: (solucoes( F ,(pai( _ ,F )),S ),
				  comprimento(S,N),
				  N =< 2
				  ).

% viii)

+neto( N,_ ) :: (solucoes( N ,(neto(N,_)),S ),
				  comprimento(S,N),
				  N =< 4
				  ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensão do predicado que permite a evolucao do conhecimento

comprimento([],0).
comprimento([H|T], R) :- comprimento(T,N), R is N + 1.

teste([]).
teste([I|L]) :- I,teste(L).

insercao(T) :- assert(T).
insercao(T) :- retract(T), !, fail.

remocao(T) :- retract(T).
remocao(T) :- assert(T), !, fail.

nao(T) :- T,insucesso.
nao(T).

solucoes(I,Condicao,S) :- findall(I,Condicao,S).

evolucao( Termo ) :- solucoes(Invariante, +Termo::Invariante, Lista),
					insercao(Termo),
					teste(Lista).

criarFilho( F,P ) :- evolucao( filho(F,P) ).

criarPai( P,F ) :- evolucao( pai(P,F) ).

criarNeto( N,A ) :- evolucao( neto(N,A) ).

criarAvo( A,N ) :- evolucao( avo(A,N) ).

criarDescendente( S,D,G ) :- evolucao( descendente( S,D,G) ).

