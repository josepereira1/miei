p :: Int -> Bool 
p 0 = True 
p 1 = False
p x | x > 1 = p (x-2) 

f :: [a] -> [a]
f l = g [] l 
g l [] = l
g l (h:t) = g (h:l) t 

fun (x:y:t) =  fun t
fun (h:[]) = []
fun [] = []


--2) 
--a v1)
segundos :: [(a,b)] -> [b]
segundos [] = []
segundos (h:t) = l2 : segundos t
                where (l1,l2) = h
--a v2)
segundoss :: [(a,b)] -> [b]
segundoss [] = [] 
segundoss (h:t) = (snd h) : segundoss t

--b v1)
nosPrimeiros :: (Eq a) => a -> [(a,b)] -> Bool
nosPrimeiros _ [] = False
nosPrimeiros c (h:t) | c == l1 = True 
                     | otherwise = nosPrimeiros c t  
                     where (l1,l2) = h

--b v2)
nosPrimeiross :: (Eq a) => a -> [(a,b)] -> Bool
nosPrimeiross _ [] = False
nosPrimeiross c ((x,y):t) | c==x = True
                          | otherwise = nosPrimeiross c t 

--c)
minFst :: (Ord a) => [(a,b)] -> a  
minFst (x:[]) = fst x 
minFst ((n,m):t) = if  n < r then n
                             else  r
                 
                 where r = minFst t 

--d v1)
sndMinFst :: Ord a => [(a,b)] -> b 
sndMinFst (x:[]) = snd x
sndMinFst ((x,y):t) | x < minFst t = y
                    | otherwise = sndMinFst t 

--d v2)
sndMinFstt :: Ord a => [(a,b)] -> b 
sndMinFstt ((a,b):[]) = b
sndMinFstt ((a,b):(c,d):t) = if a > c then sndMinFstt ((c,d):t)
                                      else sndMinFstt ((a,b):t)

--e v1)
sumTriplos :: (Num a, Num b, Num c) => [(a,b,c)] -> (a,b,c)
sumTriplos (v:[]) = v
sumTriplos ((a,b,c):t)= let (a1,b1,c1) = sumTriplos t 
                        in (a+a1, b+b1, c+c1)

--e v2)
sumTriploss :: (Num a, Num b, Num c) => [(a,b,c)] -> (a,b,c)
sumTriploss (v:[]) = v
sumTriploss ((a,b,c):t)= (a+a1, b+b1, c+c1)
                        where (a1,b1,c1) = sumTriploss t

--f) 
maxTriplo :: (Ord a,Num a) => [(a,a,a)] -> a 
maxTriplo lista  = aux_maxTriplo lista 0
aux_maxTriplo [] soma_maior = soma_maior
aux_maxTriplo ((a,b,c):t) soma_maior | soma_maior < (a+b+c) = aux_maxTriplo t (a+b+c)
                                 | otherwise = aux_maxTriplo t soma_maior

--3)
--a)
(><) :: Int -> Int -> Int 
(><) n 0 = 0
(><) n 1 = n
(><) n m = n + (n >< (m-1))
--(><) n m = n + ((><) n (m-1))

--b)
{-div :: Int -> Int -> Int 
div n 0 = 0
div n 1 = n 
div n m = (n / m)-}

--c 
power :: Int -> Int -> Int
power a b | b > 0 = a*(power a (b-1))
          | otherwise = 1
--4)
type Hora = (Int, Int)
type Etapa = (Hora,Hora)
type Viagem = [Etapa]

--a)
horaValida :: Hora -> Bool
horaValida (h,m) = h `elem` [0..23] && m `elem` [0..59]

maiorhora :: Hora -> Hora -> Bool
maiorhora (h1,m1) (h2,m2) | h1 > h2 = True
                          | h1 == h2 && m1 > m2 = True
                          | otherwise = False

validaEtapa :: Etapa -> Bool
validaEtapa (h1,h2)   | maiorhora h2 h1 && horaValida h1 && horaValida h2 = True
                      | otherwise = False

--b)
validaViagem :: Viagem -> Bool
validaViagem [] = False
validaViagem (h:t) | validaEtapa (a,b) && (maiorhora c a) = True
                   | otherwise = False  
                  where (a,b) = h 
                        (c,d) = (head t)

--d) 
tempo_viagem_efect :: Viagem -> (Int,Int)
tempo_viagem_efect (h:t) | (d-b) < 0 =  (((c-a)-1),(60+(d-b)))
                         | otherwise = ((c-a),(d-b))
                        where ((a,b),(c,d)) = h 

--e) 
tempo_total_espera :: Viagem -> (Int,Int)
tempo_total_espera (x:y:t) | (h-f) < 0 = (((g-e)-1),(60+(h-f)))
                           | otherwise = ((g-e),(h-f))
                        where (a,b) = x
                              (c,d) = y
                              (e,f) = b
                              (g,h) = c  

tempo_total_viagem lista =  ((a+c),(b+d))
                        where (a,b) = tempo_viagem_efect lista
                              (c,d) = tempo_total_espera lista 

