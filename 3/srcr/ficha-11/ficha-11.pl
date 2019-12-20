%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Programacao em logica estendida
% Representacao de conhecimento imperfeito

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: Declaracoes iniciais

:- set_prolog_flag( discontiguous_warnings,off ).
:- set_prolog_flag( single_var_warnings,off ).
:- set_prolog_flag( unknown,fail ).

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% SICStus PROLOG: definicoes iniciais

:- dynamic(jogar/4).


% meta-predicado jogar:: id, aspeto, temperatura, humidade, vento -> V,F

-jogar(1,sol,29,85,falso).
-jogar(2,sol,27,90,verdadeiro).
jogar(3,nuvens,28,86,falso).
jogar(4,chuva,21,96,falso).


demo(questao, verdadeiro) :- questao.
demo(questao, falso) :- -questao.
demo(questao, desconhecido) :- nao(questao), nao(-questao).

nao(X) :- X, !, fail.
nao(_).