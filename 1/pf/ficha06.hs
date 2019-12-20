import Data.Char
--1)
toDigits :: Int -> [Int]
toDigits n | q == 0 = []
           | otherwise = q:toDigits r
            where (q,r) = divMod n 10 
--2)
--a)
fromDigit :: [Int] -> Int 
fromDigit l = sum (zipWith f l [0..])
                where f x y = x * 10^y

--zipWith (f) [4,3,2,1] [0,1,2,3] = [4,30,200,1000] e agora tenho 
--que somar os 4 valores para obter o resultado esperado.

--b)
fromDigit'' :: [Int] -> Int
fromDigit'' [] = 0
fromDigit'' (h:t) = h + 10*fromDigit'' t


--c)
--fromDigit' [4,3,2,1] = 4+10*(3+10*(2+10*(1+10*0)))
fromDigit' :: [Int] -> Int 
fromDigit' l = foldr (\x y -> x + 10 * y) 0 l   

--3)
--a)
intStr :: Int -> String
intStr n | q /= 0 = intStr q ++ [intToDigit r]
         | otherwise = [intToDigit r]   
            where (q,r) = divMod n 10

det_digitos :: Int -> Int -> Int -> Int
det_digitos n b cnt | div n b /= 0 = det_digitos n (b*10) (cnt+1)
                    | otherwise = cnt

--b)
--v1)
strInt :: String -> Int
strInt numb = aux_strInt (reverse numb) 1
aux_strInt [] _ = 0
aux_strInt (h:t) base = (digitToInt h)*base+aux_strInt t (base*10)

--v2)
strInt' :: String -> Int
strInt' l = aux_strInt' l ((length l) -1)
aux_strInt' (h:t) e | e > 0 = (digitToInt h) * 10 ^ e + aux_strInt' t (e-1)
                    | otherwise = (digitToInt h)
--4)
agrupa :: String -> [(Char,Int)]
agrupa [] = []
agrupa (h:t) = (h,conta):agrupa resto
        where (conta,resto) = contaletras (h:t) 

contaletras :: String -> (Int,String)
contaletras [] = (0,[])
contaletras [x1] = (1,[])
contaletras [x1,x2] | x1 == x2 = (2+conta,resto)
                    | otherwise = (1,[x2])
                      where (conta,resto) = contaletras  []
contaletras (x:y:t) | x == y = (1+conta,resto)
                    | otherwise = (1,(y:t))
                      where (conta,resto) = contaletras  (y:t)
--5)

--6)
type Mat a = [[a]]
--m = [[1,2,3]
--    ,[0,4,5]
--   ,[0,0,5]]
--a)
--v1)
dimOK :: Mat a -> Bool 
dimOK m | l' == [] = True
        | otherwise = False
        where lista_comprimentos = map length m 
              l'  = filter (\x -> x /= head lista_comprimentos) lista_comprimentos
--v2)
dimOk :: Mat a -> Bool
dimOk [x1,x2] | length x1 == length x2 = True
              | otherwise = False
dimOk (x1:x2:t) | length x1 == length x2 = dimOk (x2:t)
                | otherwise = False
dimOk _ = True

--b)
dimMat :: Mat a -> (Int,Int)
dimMat m = (length (head m), length m)

--usadno uma ordem superior 
dimMatt :: Mat a -> (Int,Int)
dimMatt m = (lengthh (head m), lengthh m)
            where lengthh l = foldr (\x y-> 1 + y) 0 l 
                                    --(\_ y-> 1 + y) pode ser assim 
                                    -- o y corresponde ao resultado anterior, ou seja, 2:[] o [] é o y, enquanto que x é o 2 
--c) 
--addMat :: Num a => Mat a -> Mat a -> Mat a
addMat m n = zipWith f m n 
            where f lm ln = zipWith (+) lm ln 
