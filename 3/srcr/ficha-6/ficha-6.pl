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
% Extensao do predicado par: N -> {V,F}

nao(X) :- X, !, fail.
nao(X).

%	i)
par(0).
par(X) :- N is X-2, N >= 0, par(N).

%	ii)

impar(1).
impar(X) :- N is X-1 ,N >=1, impar(N).

%	outra forma de fazer:
impar1(X) :- nao(par(X)).


%	iii)
naturais(0).
naturais(X) :- N is X-1, N >= 0, naturais(N).

%	iv)
z(0).
z(X) :- X > 0, N is X-1, N >= 0 , z(N).
z(X) :- X < 0, N is X+1, N >= 0, z(N).


%	v)
cor(vermelho).
cor(verde).
cor(azul).
cor(amarelo).
cor(laranja).
cor(violeta).

arco(X) :- cor(X).

%	viii)

nodo(a).
nodo(b).
nodo(c).
nodo(d).

ligacao(b,a).
ligacao(b,c).
ligacao(c,a).
ligacao(c,d).

nodoTerminal(X) :- nodo(X), nao(ligacao(X,_)).










