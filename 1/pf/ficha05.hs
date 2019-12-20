import Data.Char (isDigit)
type Polinomio = [Monomio]
type Monomio = (Float,Int)

--1)
--a)
conta :: Int -> Polinomio -> Int 
conta _ [] = 0
conta e ((a,b):t) | e == b = 1 + conta e t 
                  | otherwise = conta e t

-- usando ordem superior 
conta' e p = length pe 
            where pe = filter (\(mc,me)-> me == e ) p     --pe -> polinómio com o (e)

--esta função foi usada, antes de usarmos a função anónima.
{-
g :: Int -> Monomio -> Bool
g e (mc,me) = e == me
-} 

--b)
grau :: Polinomio -> Int 
grau p = maximum p2 
        where p2 = toNum p 
toNum [] = [] 
toNum ((x,y):xs) = y :toNum xs 

--usando ordem superior 
toNum' p = map snd p 

 --c)
selgrau :: Int -> Polinomio -> Polinomio
selgrau n [] = []
selgrau n ((x,y):t) | n == y = (x,y):(selgrau n t) 
                    | otherwise = selgrau n t 

selgrau' x l = filter (\(c,e) -> e == x) l 

--d)
deriv :: Polinomio -> Polinomio 
deriv p = map (\(x,y) -> (x*(fromIntegral y),y-1)) p

--e)
calcula _ [] = 0 
calcula n ((x,y):t) = x*n^y + calcula n  t

calcula' :: Float -> Polinomio -> Float 
calcula' x p = sum (map (\(a,b) -> a*(x^b)) p)

--f)
simp :: Polinomio -> Polinomio 
simp l = filter (\(a,b) -> a/=0 ) l

--g)
mult :: Monomio -> Polinomio -> Polinomio 
mult (c,e) p = map (\(x,y) -> (c*x,e+y)) p  

--h)
normaliza :: Polinomio -> Polinomio
normaliza ((c,e):t) = (c+n,e):normaliza (deleteR e t)
                      where p = selgrau e t
                            n = sum (map (fst) p)

deleteR :: Int -> Polinomio -> Polinomio
deleteR _ [] = []
deleteR n ((c,e):t) | n == e = deleteR n t
                    | otherwise = (c,e):deleteR n t

--i)
soma :: Polinomio -> Polinomio -> Polinomio
soma p1 p2 = normaliza (p1++p2)

--j)
produto :: Polinomio -> Polinomio -> Polinomio
produto [] _ = []
produto (m:t) p2 = soma (mult m p) (produto t p)

--k)
ordena :: Polinomio -> Polinomio
ordena [] = []
ordena ((a,b):t) = inst (a,b) (ordena t)

inst :: Monomio -> Polinomio -> Polinomio
inst m [] = [m]
inst (a,b) ((c,d):t) | b <= d = (a,b):(c,d):t
                     | otherwise = (c,d):inst (a,b) t 

--l)
equiv :: Polinomio -> Polinomio -> Polinomio
equiv p1 p2 = ordena (normaliza p1) == ordena (normaliza p2) 

--2)
nzp :: [Int] -> (Int,Int,Int)
nzp [] = (0,0,0)
nzp (h:t) | h < 0 = (1+n,z,p)
          | h == 0 = (n,1+z,p)
          | h > 0 = (n,z,1+p)
            where (n,z,p) = nzp t

--3)
digitAlpha :: String -> (String,String)
digitAlpha [] = ([],[])
digitAlpha (h:t) | isDigit h = (letras,h:numeros)
                 | otherwise = (h:letras,numeros)
                where (letras,numeros) = digitAlpha t

--4)
--a)
a1 = [x | x <- [1..20], mod x 2 == 0, mod x 3 == 0]

--b)
b1 = [x | x <-[y | y <- [1..20],mod y 2 == 0], mod x 3 == 0]

--c)
c1 = [(x,y) | x <- [1..20], y <- [1..20], x+y==30]

--d)
d1 = [sum [y | y <- [1..x], odd y] | x <- [1..10]]

--5)
--a)
a2 = [2^x | x <- [1..10]]

--b)
b2 = [(x,y) | x <- [1..5], y <- [5,4..1]]

--c)
c2 = [take n [1..] | n <- [1..5]]

--d)
d2 = [take n [1,1..] | n <- [1..5]]

--6)
--a)
zipWith' :: (a->b->c) -> [a] -> [b] -> [c]
zipWith' f (x:xs) (y:ys) = (f x y):zipWith' f xs ys
zipWith' f _ _ = []

--b)
takeWhile' :: (a-> Bool) -> [a] -> [a]
takeWhile' f [] = []
takeWhile' f (h:t) | f h = h:takeWhile' f t 
                   | otherwise = []

--c)
dropWhile' :: (a->Bool) -> [a] -> [a]
dropWhile' f [] = []
dropWhile' f (h:t) | f h = dropWhile f t 
                   | otherwise =  (h:t)

--d)
span' :: (a-> Bool) -> [a] -> ([a],[a])
span' f [] = ([],[])
span' f (h:t) | f h = (h:l1,l2)
              | otherwise = ([],(h:t))
                where (l1,l2) = span' f t 