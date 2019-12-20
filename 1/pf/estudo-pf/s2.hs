module Main where 
import Data.Char
--Insertion Sort:
isortt :: Ord a => [a] -> [a]
isortt [] = []
isortt (h:t) = insertt h (isortt t)

insertt x [] = [x]
insertt x (h:t) | x < h = x:h:t
               | otherwise = h:(insertt x t)

--Quick Sort:
qsort [] = []
qsort (h:t) = qsort [y | y <- t , y<h]++[h]++[y | y <- t , y>h]

--Quick Sort (mais otimizado):


parte :: Ord a => a -> [a] -> ([a],[a])
parte a [] = ([],[]) 
parte a (x:xs) | a < x = (x:l,h)
               | otherwise = (l,x:h)
                 where (l,h) = parte x xs 
qsortt :: Ord a => [a] -> [a] 
qsortt []  = []
qsortt (x:xs) = (qsortt l)++[x]++(qsortt h)
                where (l,h) = parte x xs 

duplicaLista :: [Int] -> [Int]
duplicaLista l = map (\x-> 2*x) l 

maiores2 :: [Int] -> [Int]
maiores2 l = filter (>2) l

maxim [x] = x
maxim (x:xs) = maxAc x xs 
    where maxAc ac [] =  ac
          maxAc ac (h:t) | h > ac = maxAc h t 
                         | otherwise = maxAc ac t 
revers1 :: Ord a => [a] -> [a]
revers1 l = auxrevers1 [] l
    where auxrevers1 i [] = i
          auxrevers1 i (h:t) = auxrevers1 ([h]++i) t

revers2 :: Ord a => [a] -> [a]
revers2 l = auxrevers2 [] l 
auxrevers2 :: Ord a => [a] -> [a] -> [a]
auxrevers2 l1 [] = l1
auxrevers2 l1 (h:t) = auxrevers2 ([h]++l1) t 

app :: (a->b) -> (a,a) -> (b,b)
app f (x,y) = (f x, f y)

mult :: Int -> Int -> Int 
mult x y = x*y      --mult 2 :: Int -> Int 

dobro =  mult 2

triplo = mult 3

divd :: Float -> Float -> Float
divd x y = x / y 

fact :: Integer -> Integer
fact 0 = 1
fact n = n*fact(n-1)

factoriais l = map (fact) l 

bits l = map (\x -> 2^x) l  

minusculas l = map (toLower) l 

positive :: [Float] -> [Float]
positive l = filter (9.5<) l

f :: Float -> Bool
f x = if x >= 9.5 then True else False

trocaPares p = map (\(x,y) -> (y,x)) p

primQuad p = filter (\(x,y) -> x>0 && y>0) p

somaLista l = foldr (+) 0 l

data Cor = Azul
         | Amarelo
         | Verde
         | Vermelho
    deriving Show 

a :: Cor
a = Azul

data CCart = Coord  Float Float 
    deriving Show

somaVect :: CCart -> CCart -> CCart
somaVect (Coord x1 y1) (Coord x2 y2) = Coord (x1+x2) (y1+y2)

data Hora = AM Int Int 
          | PM Int Int 
    deriving Show

contaminutos (AM h m) = h*60 + m 
contaminutos (PM h m) = (h*60 + 12) + m

maiorHora (AM h1 m1) (AM h2 m2) | h1 > h2 = (AM h1 m1)
                                | h1 == h2 && m1 > m2 = (AM h1 m1)
                                | h1 == h2 && m1 < m2 = (AM h2 m2) 
maiorHora (PM h1 m1) (PM h2 m2) | h1 > h2 = (PM h1 m1)
                                | h1 == h2 && m1 > m2 = (PM h1 m1)
                                | h1 == h2 && m1 < m2 = (PM h2 m2)   
maiorHora _ (PM h1 m1) = (PM h1 m1)
maiorHora (PM h1 m1) _ = (PM h1 m1)

data ArvBin a = Vazia 
              | Node a (ArvBin a) (ArvBin a)
    deriving Show
printArvBin (Node x e d) = x

data Figura = Retangulo Float Float 
            | Circulo Float 
            | Triangulo Float Float 
        deriving Show

area :: Figura -> Float 
area (Retangulo l c) = l*c
area (Circulo r) = pi*r^2
area (Triangulo b h) = (b*h)/2

listaFiguras = [(Retangulo 2 4),(Circulo 3),(Triangulo 3 2)]

data Nat = Zero 
         | Suc Nat
    deriving Show

dois = Suc (Suc Zero)
tres = Suc (Suc (Suc Zero))

convert :: Nat -> Int 
convert Zero = 0
convert (Suc x) = 1 + convert x

somaNat :: Nat -> Nat -> Nat 
somaNat Zero n = n 
somaNat (Suc x) m = Suc (somaNat x m)
