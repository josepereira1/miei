%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SIST. REPR. CONHECIMENTO E RACIOCINIO - MiEI/3

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Base de Conhecimento com informacao genealogica.

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: Declaracoes iniciais

:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).
:- set_prolog_flag( unknown,fail ).


nao(X) :- X, !, fail.
nao(X).

% iv)
ave(pitigui).

% v)
ave(X) :- canario(X).

% vi)
ave(X) :- periquito(X).

% vii)
canario(piupiu).

% viii)
mamifero(silvestre).

% ix)
mamifero(X) :- cao(X).

% x)
mamifero(X) :- gato(X).

% xi)
cao(boby).

% xii)
ave(X) :- avestruz(X).

% xiii)
ave(X) :- pinguin(X).

% xii)
avestruz(trux).

% xv)
pinguin(pingu).

% xvi)
mamifero(X) :- morcego(X).

% xvii)
morcego(batemene).


