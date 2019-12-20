{-| 
Module      : Doc
Description : Módulo Haskell contendo exemplos de funções recursivas 
Copyright   : Alguém <alguem@algures.com>;
			  Outro alguém <outro@algures.com>


Este módulo contém variadas __funções__, que foram realizadas através da ficha /LI1_3.pdf/ .

=Ficha LI1_3.pdf
-}
module Doc where

import Data.Char

{-|
==Descrição:

A função __dobros__ , recebe uma /lista/ com elementos do tipo __Float__ e retorna uma /lista/ do mesmo tipo, com os seus elementos duplicados.

==Código Fonte:

@
dobros :: [Float] -> [Float]
dobros [] = []
dobros (h:t) = 2*h : dobros t
@


==Exemplos de Utilização:

>>> dobros [1.0,2.0,3.0]
[2.0,4.0,6.0]
>>> dobros [4.0,10.0,8.0]
[8.0,20.0,16.0]

-}
dobros :: [Float] -> [Float]
dobros [] = []
dobros (h:t) = 2*h : dobros t
{-|
==Descrição:

A função __ocorre__ , recebe um __Char__ e uma /lista/ de elementos do tipo __Char__, e retorna o número de vezes que esse __Char__ ocorre na __String__ (/lista/ de __Char__).

==Código Fonte:

@
ocorre :: Eq a => a -> [a] -> Int 
ocorre ch [] = 0 
ocorre ch (h:t) = if ch == h then 1 + ocorre ch t else ocorre ch t 

@

== Exemplos de Utilização:

>>>ocorre 'a' "amanhecer"
2
>>>ocorre '1' "1 + 1 = 1 + 0 + 1"
4

* A lista pode escrita desta forma: __"amanhecer"__;
* Ou, também pode ser escrita assim: __[''a'',''m'',''a'',''n'',''h'',''e'',''c'',''e'',''r'']__;
-}

ocorre :: Eq a => a -> [a] -> Int 
ocorre ch [] = 0 
ocorre ch (h:t) = if ch == h then 1 + ocorre ch t else ocorre ch t 

{-|
==Descrição:

A função __pmaior__ , recebe um número __'n'__ __Int__ e uma /lista/ de elementos do tipo __Int__, e retorna o primeiro número da /lista/ que é maior que __'n'__ caso, não encontre retorna __'n'__.

==Código Fonte:

@
pmaior :: Int -> [Int] -> Int
pmaior num [] = num 
pmaior num (h:t) = if num < h then h else pmaior num t   
@

==Exemplos de Utilização:

>>>pmaior 4 [2,1,3,4,5,6,10,20]
5
>>>pmaior 6 [2,1,3,4,5,6,10,20]
10

-}
pmaior :: Int -> [Int] -> Int
pmaior num [] = num 
pmaior num (h:t) = if num < h then h else pmaior num t   
{-|
==Descrição:

A função __repetidos__ , recebe uma /lista/ de elementos do tipo __Int__ e verifica se há números repetidos.

==Código Fonte:

@
repetidos :: [Int] -> Bool 
repetidos [] = False
repetidos (h:t) = if ocorre h t > 0 then True else repetidos t  
@

==Exemplos de Utilização:

>>>repetidos [1,2,3,4,4,5]
True
>>>repetidos [1,2,3,4,5,6]
False


-}
repetidos :: [Int] -> Bool 
repetidos [] = False
repetidos (h:t) = if ocorre h t > 0 then True else repetidos t  

{-nums :: String -> [Int]
nums [] = [] 
nums (h:t) = h:nums t
-}
{-|==Descrição:
A função __tresUlt__, recebe uma /lista/ de qualquer tipo, e retorna os 3 últimos elementos dessa mesma /lista/.

==Código Fonte:
@
tresUlt :: [a] -> [a]
tresUlt [] = []
tresUlt (h:[]) = [h]
tresUlt (x1:x2:[]) = [x1,x2]
tresUlt (x1:x2:x3:[]) = [x1,x2,x3]
tresUlt (h:t) = tresUlt t
@

== Exemplos de Utilização:
>>>tresUlt [1,2,3,4,5,6,7]
[5,6,7]
>>>tresUlt "Bom dia Mundo!"
['d','o','!']

*Caso a lista tenha menos de 3 elementos, a função retorna a própria /lista/.
*Funciona para qualquer tipo.
-}
tresUlt :: [a] -> [a]
tresUlt [] = []
tresUlt (h:[]) = [h]
tresUlt (x1:x2:[]) = [x1,x2]
tresUlt (x1:x2:x3:[]) = [x1,x2,x3]
tresUlt (h:t) = tresUlt t

{-|
==Descrição:

A função __posImpares__, recebe uma /lista/ de elementos de qualquer tipo, e retorna uma lista com os elementos nas posições ímpares.

==Código Fonte:

@
posImpares :: [a] -> [a]
posImpares (h:t) = aux 1 (h:t)
aux :: Int -> [a] -> [a]
aux n [] = []
aux n (h:t) | mod n 2 == 0 = aux (n+1) t
aux n (h:t) | mod n 2 /= 0 = h:(aux (n+1) t)
@

==Exemplos de Utilização:
>>>posImpares [1,2,3,4,5]
[2,4]
>>>posImpares "Bom dia Mundo!"
"o i ud!"

*Nesta função utiliza-se um método diferente, em que criamos outra função, __aux__ para facilitar a função __posImpares__.

-}
posImpares :: [a] -> [a]
posImpares (h:t) = aux 0 (h:t)
aux :: Int -> [a] -> [a]
aux n [] = []
aux n (h:t) | mod n 2 == 0 = aux (n+1) t
aux n (h:t) | mod n 2 /= 0 = h:(aux (n+1) t)

{-|
==Descrição:
A função __somaNeg__, recebe uma /lista/ de elementos do tipo __Int__, e retorna a soma de todos os elementos negativos dessa mesma /lista/.

==Código Fonte:
@
somaNeg :: [Int] -> Int 
somaNeg [] = 0
somaNeg (h:t) | h>=0 = somaNeg t
somaNeg (h:t) | h<0 = h+somaNeg t
@

==Exemplos de Utilização:
>>>somaNeg [1,2,-3,4,5,-1]
-4
>>>somaNeg [1,2,3,4,5,1]
0

* Caso não existam elementos negativos a função __somaNeg__ retorna 0.

-}
somaNeg :: [Int] -> Int 
somaNeg [] = 0
somaNeg (h:t) | h>=0 = somaNeg t
somaNeg (h:t) | h<0 = h+somaNeg t

soDigitos :: [Char] -> [Char]
soDigitos [] = []
soDigitos (h:t) | (ord h >= ord '0') && (ord h <= ord '9') = h:soDigitos t
                | (ord h < ord '0') && (ord h > ord '9') = soDigitos t


minusculas :: [Char] -> Int 
minusculas [] = 0
minusculas (h:t) | ((ord h >= ord 'a') && (ord h <= ord 'z')) = 1 + minusculas t
                 | ((ord h < ord 'a') && (ord h > ord 'z')) = minusculas t

--13)
type Jogo = (String, Int, String, Int)     --(Eq.casa, golos, Eq.visitantes, golos)
--a)
