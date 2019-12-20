import Data.Char
--Funções de Ordem Superior

fun1 l = map (3+) l 

fun2 l = map (\(a,b) -> a) l

fun3 l = map aux_fun3 l 

aux_fun3 x | x > 0 = x 
           | otherwise = (x-1) 

fun4 l = filter (\(x,y) -> x > 0 && y > 0) l 

fun5 l = filter (\x -> x>10) l 

fun6 l = filter (aux_fun6) l

aux_fun6 :: Char -> Bool
aux_fun6 x | (ord x >= ord '0') && (ord x <= ord '9') = True
           | otherwise = False

troca l = map (\(x,y) -> (y,x)) l 

concatt [] = []  
concatt (h:t) = h++concatt t 

concattt l = foldr (++) [] l 

summ l = foldr (+) 0 l 

produto l = foldr (*) 1 l 

andd l = foldr (&&) True l

anddd [] = True
anddd (h:t) | h == True = anddd t 
            | otherwise = False




