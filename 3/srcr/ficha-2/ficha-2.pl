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
% Extensao do predicado soma: X,Y,R -> {V,F}

soma1(A,B,R) :-
	R is A + B.

% Extensao do predicado soma2: X,Y,Z,R -> {V,F}

soma2(A,B,C,R) :-
	R is A + B + C.

% Extensao do predicado soma: [X|T],R -> {V,F}
soma3([],0).
soma3([H|T],R) :- 
	soma3(T,N), R is H + N.

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado op: X,Y,OP,R -> {V,F}

op(X , Y , + , R) :- R is X + Y.
op(X , Y , - , R) :- R is X - Y.
op(X , Y , * , R) :- R is X * Y.
op(X , Y , / , R) :- R is X / Y.

%--------------------------------- - - - - - - - - - -  -  -  -  -   -
% Extensao do predicado op: [H|T] ,OP,R -> {V,F}

op1([] , + , 0).
op1([] , + , 0).
op1([] , * , 1).
op1([] , / , 1).
op1([H|T] , + , R) :- op1(T, + ,N), R is N + H.
op1([H|T] , - , R) :- op1(T, - ,N), R is N - H.
op1([H|T] , * , R) :- op1(T, * ,N), R is N * H.
op1([H|T] , / , R) :- op1(T, / ,N), R is N / H.

op2([] , + , 0).
op2([] , + , 0).
op2([] , * , 1).
op2([] , / , 1).
op2([H|T] , OP , R) :- op2(T,OP,N), op(H,N,OP,R).

%	vi)
maior(X,Y,X) :- X > Y.	
maior(X,Y,Y) :- X < Y.

%outra forma de fazer vi)
maioor(X,Y,R) :- X > Y, R is X.
maioor(X,Y,R) :- X < Y, R is Y.

%vii)
maior1(X,Y,Z,X) :- X > Y, X > Z.
maior1(X,Y,Z,Y) :- Y > X, Y > Z.
maior1(X,Y,Z,Z) :- Z > X, Z > Y.

%outra forma de fazer vii)
maioor1(X,Y,Z,R) :- X > Y, X > Z, R is X.
maioor1(X,Y,Z,R) :- Y > X, Y > Z, R is Y.
maioor1(X,Y,Z,R) :- Z > X, Z > Y, R is Z.

maior2([H],H).
maior2([H|T], R) :- maior2(T,N), maior(H,N,R).

menor(X,Y,X) :- X < Y.	
menor(X,Y,Y) :- X > Y.

menor1(X,Y,Z,X) :- X < Y, X < Z.
menor1(X,Y,Z,Y) :- Y < X, Y < Z.
menor1(X,Y,Z,Z) :- Z < X, Z < Y.

menor2([H],H).
menor2([H|T], R) :- menor2(T,N), menor(H,N,R).

%	xii)
length1( [] , R ) :- R is 0.
length1( [H] , R ) :- R is 1.
length1( [H|T] , R ) :- length1( T , N ), R is N + 1.

sum( [] , R ) :- R is 0.
sum( [H|T] , R ) :- sum( T , N ), R is N + H.

media( [] , R ) :- R is 0.
media( [H] , R ) :- R is H.
media( [H|T] , R ) :- 
	sum( [H|T], S ), length1( [H|T] , L ), R is S/L.
