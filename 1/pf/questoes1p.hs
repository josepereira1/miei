module Main where
import Data.Char

--1)
enumfromToo :: Int -> Int -> [Int]
enumfromToo n m | n <= m = n:(enumfromToo (n+1) m)
                | otherwise = [] 

--2)
myEnumFromThenTo :: Int -> Int -> Int -> [Int]
myEnumFromThenTo a b c | a < b && a <= c = a:myEnumFromThenTo b (b+(b-a)) c 
                       | a < b && a > c = []
                       | a > b && a >= c = a:myEnumFromThenTo b (b+(b-a)) c 
                       | a > b && a < c = []

--3 v2)
concListaa :: [a] -> [a] -> [a]
concListaa [] l = l
concListaa l [] = l 
concListaa (x:xs) l = x : (xs++l)

--3 v3)
concListaaa :: [a] -> [a] -> [a]
concListaaa [] l = l
concListaaa l [] = l
concListaaa (h:t) l = h:(concListaaa t l) 

--4 v1)
ultimo :: [a] -> a
ultimo [l]= l
ultimo l = head (reverse l)

--4 v2)
ultimo1 :: [a] -> a
ultimo1 [l] = l
ultimo1 (x:xs) = ultimo1 xs

--5 v1)
innit :: [a] -> [a]
innit l = reverse (tail (reverse l))

--5 v2)
iniit :: [a] -> [a] 
iniit [a]= []
iniit (h:t) = h: iniit t

--6)
positionn :: [a] -> Int -> a
positionn (h:t) num | num >0 = positionn t (num -1)
                    | otherwise = h
--7)
reversee :: [a] -> [a]
reversee [] = []
reversee (h:t) = (reversee t)++(h:[])

--8) 
takee :: Int -> [a] -> [a]
takee pos [] = []
takee pos (h:s) | pos > 0 = h:(takee (pos-1) s)
                | otherwise = []
--9)
droop :: Int -> [a] -> [a]
droop pos [] = []
droop pos l | length l <= pos = [] -- acho que pudemos omitir este caso
droop pos (h:t) | pos > 0 = droop (pos-1) t 
                | otherwise = (h:t)

--10)
--dúvida, isto não funciona
ziip :: [a] -> [b] -> [(a,b)]
ziip (y:ys) (x:xs) = (y,x):(ziip ys xs) 
ziip _ _ = []

 --11)
elemm :: Eq a => a -> [a] -> Bool
elemm n [] = False
elemm n (h:t) = if h == n then True else elemm n t

--12)
replicatee :: Int -> a -> [a]
replicatee n x | n > 0 = x:replicatee (n-1) x
               | otherwise = []
--13)
interspersee :: a -> [a] -> [a]
interspersee n [] = []
interspersee n (h:[]) = h:[]
interspersee n (h:t) = h:n:interspersee n t

--14) 
groupp [] = []
groupp [x] = [[x]]
groupp (x:xs) = if x == head y then (x:y):ys else [x]:(y:ys)
                where (y:ys) = groupp xs                        -- sabemos que tem sempre uma cabeça não vazia

--15)
concatt :: [[a]] -> [a]
concatt [] = []
concatt (h:t) = h++concatt t

--16 v1)
inits' l = [ take n l   |  n <-  [0 .. length l]]--isto é a penas para perceber!

inits'' [] = [[]]
inits'' l = inits'' (init l) ++ [l]              --explicação no caderno de PF prática
    
--17 v1)
tailss :: [a] -> [[a]]
tailss [] = [[]]
tailss (h:t) = ((h:t):[])++tailss t

--17 v2)
myTails :: [a] -> [[a]]
myTails [] = [[]]
myTails l = [l]++(myTails (tail l))

--17 v3)
tailsss :: [a] -> [[a]]
tailsss [] = [[]]
tailsss (h:t) = (h:t):(tailsss t)

--18)
isPrefixOff :: Eq a => [a] -> [a] -> Bool 
isPrefixOff [] lista = True 
isPrefixOff lista [] = False
isPrefixOff (x:xs) (y:ys) | x == y = isPrefixOff xs ys 
                          | otherwise = False

--19 v1)
myIsSuffixOf :: Eq a => [a] -> [a] -> Bool 
myIsSuffixOf [] [] = True
myIsSuffixOf [] l = True
myIsSuffixOf l [] = False
myIsSuffixOf l (x:xs) = l == (x:xs) || (myIsSuffixOf l xs)

--19 v2)
isSuffixOfff :: Eq a => [a] -> [a] -> Bool 
isSuffixOfff [] [] = True
isSuffixOfff [] l = True
isSuffixOfff l [] = False
isSuffixOfff l (x:xs) | l == (x:xs) = True 
                      | otherwise = isSuffixOfff l xs  
--20)
isSubsequenceOf :: Eq a => [a] -> [a] -> Bool
isSubsequenceOf [] _ = True                 --Neste caso testa-se, quando procuramos uma sequência como a do vazio, ela existe sempre, 
isSubsequenceOf _ [] = False                --e neste caso também incluímos a situação em que temos 2 listas vazias que é igual a True.
isSubsequenceOf (x:xs) (y:ys) | x == y = isSubsequenceOf xs ys 
                              | otherwise = isSubsequenceOf (x:xs) ys 

--21)
elemIndices :: Eq a => a -> [a] -> [Int]
elemIndices c lista = aux3 c 0 lista
aux3 :: Eq a => a -> Int -> [a] -> [Int]
aux3 c n [] = []
aux3 c n (h:t) | h == c = n:(aux3 c (n+1) t)
                 | otherwise = aux3 c (n+1) t 

--22 v1)
nub ::Eq a => [a] -> [a]
nub [] = [] 
nub (h:t) | elem h l  = l
          | otherwise = (h:l)
          where l = nub t 

--22 v2)
nubb :: Eq a => [a] -> [a]
nubb [] = []
nubb (h:t) | elem h t = nubb t
           | otherwise = h:nubb t 

--22 v3)
nubbb [] = []
nubbb (h:t) = h:nubbb (limpa h t)

limpa :: Eq a => a -> [a] -> [a]
limpa x [] = [] 
limpa x (y:ys) | x == y = limpa x ys 
               | otherwise = y:limpa x ys 

--23)
deletee :: Eq a => a -> [a] -> [a]
deletee c [] = []
deletee c (h:t) = if h ==c then t else h:deletee c t 

--24) 
remove_equal :: Eq a => [a] -> [a] -> [a]
remove_equal [] l = []
remove_equal l [] = l
remove_equal (x:xs) l | x `elem` l = remove_equal xs (remove1 x l)
                      | otherwise = x:(remove_equal xs l)

remove1 :: Eq a => a -> [a] -> [a]
remove1 x [] = [] 
remove1 x (y:ys) | x == y = ys
                 | otherwise = y:remove1 x ys 

--25)
unionnn :: Eq a => [a] -> [a] -> [a]
unionnn l [] = l 
unionnn l (y:ys) | elem y l = unionnn l ys
                 | otherwise = unionnn (l++[y]) ys

--26) 
intersect :: Eq a => [a] -> [a] -> [a]
intersect l [] = []
intersect [] l = []
intersect (x:xs) l | elem x l = x:intersect xs l 
                   | otherwise = intersect xs l 

--27)
insertt :: Ord a => a -> [a] -> [a]
insertt x [] = [x]
insertt x (h:t) | x <= h = x:h:t
                | otherwise = h:insertt x t
--28)
maxinumm :: Ord a => [a] -> a
maxinumm (h:[])= h
maxinumm (h:t) | h > maxinumm t = h 
               | otherwise = maxinumm t

--29)
mininumm :: Ord a => [a] -> a
mininumm (h:[]) = h
mininumm (h:t) | h < mininumm t = h
               | otherwise = mininumm t 

--30)
summ :: Num a => [a] -> a
summ [] = 0 
summ (h:t) = h + summ t

--31)
productt :: Num a => [a] -> a
productt [] = 1
productt (h:t) = h * productt t

--32)
andd :: [Bool] -> Bool
andd [] = True
andd (h:t) | h == True = andd t
           | otherwise = False

--33)
orr :: [Bool] -> Bool
orr [] = False
orr (h:t) | h == True = True
          | otherwise = orr t  

--34)
--posso fazer desta forma 
unwordss :: [String] -> String 
unwordss [] = [] 
unwordss (h:[]) = h
unwordss (h:t) = h++" "++unwordss t            --temos que colocar [' '] pq eu estou a concatenar com ++

--35)
unliness :: [String] -> String 
unliness [] = [] 
unliness (h:t) = h++"\n"++unliness t           --temos que colocar [' '] pq eu estou a concatenar com ++

--36)
pMaior :: Ord a => [a] -> Int
pMaior lista = auxxx 0 lista 
auxxx :: Ord a => Int -> [a] -> Int 
auxxx pos (h:[]) = pos
auxxx pos (h:t) | h >= maxinumm t = pos
                | otherwise = auxxx (pos+1) t 

--37)
temRepetidos :: Eq a => [a] -> Bool 
temRepetidos [] = False
temRepetidos (h:t) | elem h t = True
                   | otherwise = temRepetidos t 

--38)
algarismos :: [Char] -> [Char]
algarismos [] = []
algarismos (h:t) | ord h >= ord '0' && ord h <= ord '9' = h:algarismos t
                 | otherwise = algarismos t 

--39 v1)
posImpares :: [a] -> [a]
posImpares lista = posImpares_aux 0 lista
posImpares_aux s [] = []
posImpares_aux s (h:t) | mod s 2 /= 0 = h:posImpares_aux (s+1) t
                       | otherwise = posImpares_aux (s+1) t 
--39 v2)
posImparess :: [a] -> [a]
posImparess [] = []
posImparess [x] = []
posImparess (x:y:t) =  y : posImparess t
--40)
posPares :: [a] -> [a]
posPares lista = posPares_aux 0 lista
posPares_aux s [] = [] 
posPares_aux s (h:t) | mod s 2 == 0 = h:posPares_aux (s+1) t 
                     | otherwise = posPares_aux (s+1) t  

--41)
isSorted :: Ord a => [a] -> Bool
isSorted [] = True
isSorted (h:[]) = True
isSorted (x:t) | x <= (head t) = isSorted t
               | otherwise = False

--42)
iSort :: Ord a => [a] -> [a]
iSort [] = [] 
iSort (h:t) = insertt h (iSort t)

--43)
menorr :: String -> String -> Bool
menorr [] [] = False  -- e igual
menorr [] l = True
menorr l [] = False
menorr (x:xs) (y:ys) | x < y = True
                     | x == y = menorr xs ys 
                     | x > y = False

--44)
elemMsett :: Eq a => a -> [(a,Int)] -> Bool
elemMsett x [] = False
elemMsett x (h:t) | x == l1 = True
                  | otherwise = elemMsett x t 
                  where (l1,l2) = h 

--45)
lengthMSet :: [(a,Int)] -> Int 
lengthMSet [] = 0
lengthMSet (h:t) = l2 + lengthMSet t
                  where (l1,l2) = h

--46)
converteMSet :: [(a,Int)] -> [a]
converteMSet [] = [] 
converteMSet ((x,y):t) | y > 0 = x:converteMSet ((x,y-1):t)
                       | otherwise = converteMSet t

--47)
insereMSet :: Eq a => a -> [(a,Int)] -> [(a,Int)]
insereMSet c [] = [(c,1)] 
insereMSet c ((x,y):t) | c == x = (x,y+1):t
                       | otherwise = (x,y):insereMSet c t 

--48 v1)
removeMSet :: Eq a => a -> [(a,Int)] -> [(a,Int)]
removeMSet _ [] = []
removeMSet c ((x,y):t) = if x == c 
                         then
                            if (y-1) == 0
                            then 
                              t 
                            else 
                              (x,y-1):t
                         else
                          (x,y):removeMSet c t

--48 v2)
removeMSett :: Eq a => a -> [(a,Int)] -> [(a,Int)]
removeMSett s [] = [] 
removeMSett s ((x,y):t) | s == x = if (y-1) == 0 then t else (x,y-1):removeMSett s t 
                        | otherwise = (x,y):(removeMSett s t)

--49)
constroiMSet :: Ord a => [a] -> [(a,Int)]
constroiMSet [] = []
constroiMSet (x:xs) = (x,n+1):constroiMSet r
                    where (n,r) = conta x xs 

conta :: Eq a => a -> [a] -> (Int,[a])
conta x [] = (0,[])
conta x (h:t) | x /= h = (0,h:t)
              | x == h = (1+n,l)
              where (n,l) = conta x t 
--50)
somaPares :: [Int] -> Int 
somaPares [] = 0
somaPares (h:t) | mod h 2 == 0 = h + somaPares t
                | otherwise = somaPares t 






