module Ficha2 where

import Data.Char

--1)
--a)
funA :: [Float] -> Float
funA [] = 0
funA (x:xs) = x^2 + (funA xs)

--b)
funB :: [Int] -> [Int]
funB [] = []
funB (h:t) = if (mod h 2)==0 then h : (funB t) else (funB t)

--2)
--a)
dobros :: [Float] -> [Float]
dobros [] = []
dobros (h:t) = 2*h : c
            where
            c = dobros t

--b)
numOcorre :: Eq a => a -> [a] -> Int 
numOcorre ch [] = 0
numOcorre ch (h:t) = if ch == h then 1 + numOcorre ch t else numOcorre ch t

--c v1)
positivos :: [Int] -> Bool
positivos (x:[]) = if x>0 then True else False
positivos (x:xs) = if x > 0 then positivos xs else False

--c v2)
positivoss :: [Int] -> Bool 
positivoss (x:[])  | x > 0 = True 
                   |otherwise = False 
positivoss (h:t)   | h < 0 = False
positivoss (h:t)   | h >= 0 = positivoss t

--d)
soPos :: [Int] -> [Int]
soPos [] = []
soPos (h:t) | h < 0 = soPos t 
soPos (h:t) | h >=0 = h:soPos t

--e)
somaNeg :: [Int] -> Int 
somaNeg [] = 0
somaNeg (h:t) | h >= 0 = somaNeg t
somaNeg (h:t) | h < 0 = h + somaNeg t


--f v1)
tresUlt :: [a] -> [a]               -- esta função é um exemplo de uma forma diferente de estruturar a função.
tresUlt [] = []                     -- quando a lista é vazia, retorna a lista vazia.
tresUlt (x1:[]) = [x1]              -- quando a lista tem 1 elemento, retorna a lista com esse elemento.
tresUlt (x1:x2:[]) = [x1,x2]        -- quando a lista tem 2 elementos, retorna a lista com os 2 elementos. 
tresUlt (x1:x2:x3:[]) = [x1,x2,x3]  -- quando a lista tem 3 elementos, retorna a própria lista.  
tresUlt (h:t) = tresUlt t
--tresUlt [1,2,3,4,5] = tresUlt 
--f v2)
tresUltt :: [a] -> [a]
tresUltt (h:t) = reverse (take 3 (reverse (h:t)))  

--g)
primeiros :: [(a,b)] -> [a]
primeiros [] = [] 
primeiros (h:t) = fst h:primeiros t

--3)
--a v1)
isLowerr :: Char -> Bool
isLowerr c | ord c >= 97 && ord c <= 122 = True 
           |otherwise                    = False

--a v2)
isLowerrr :: Char -> Bool
isLowerrr c = ord c >= ord 'a' && ord c <= ord 'z'

--b)
isDigitt :: Char -> Bool 
isDigitt c | ord c >= ord '0' && ord c <= ord '9' =  True 
           | otherwise = False

--c)

{-isAlphaa :: Char -> Bool 
isAlphaa ' ' = False
isAlphaa c if ((ord c >= ord 'A') && (ord c <= ord 'Z') && (ord c >= ord 'a') && (ord c <= ord 'z')) then True else False-}

--d)
toUpperr :: Char -> Char 
toUpperr c = chr (ord c - 32)

--e)
intToDigit :: Int -> Char 
intToDigit n | n >=0 && n<=9 = chr( ord '0' + n ) -- esta função só está definida para números entre [0,9] 

--f)
-- Tenho que verificar se o caracter está entre 0 e 9???
digitToIntt :: Char -> Int 
digitToIntt c = ord c - 48 


--4)
--a)
--Está a dar um erro, que não percebo??
{-primMai :: String -> Bool
primMai [] = False
primMai (h:t) = if ((isLowerrr h) == True) then False
              else otherwise = True-} 

--b) 
segMin :: String -> Bool 
segMin (h:t) = if (isLowerrr (head t)) then True else False

--5)
--a)
soDigitoss :: [Char] -> [Char] 
soDigitoss [] = []
soDigitoss (h:t) = if (ord h >= ord '0' && ord h <= ord '9') 
                then
                    h:soDigitoss t
                else 
                    soDigitoss t

--b)
minusculas :: [Char] -> Int 
minusculas [] = 0
minusculas (h:t) = if ord h >= ord 'a' && ord h <= ord 'z' then 
                   1 + minusculas t 
                   else 
                   minusculas t


