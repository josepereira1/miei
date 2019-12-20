module Main where
type Polinomio = [Monomio]
type Monomio = (Float,Int)

m1 = [(2,3),(3,4),(5,3),(4,5)] :: Polinomio
--a)
conta :: Int -> Polinomio -> Int
conta n [] = 0
conta n ((a,b):t) | (fromIntegral n) == b = 1 + conta n t
                  | otherwise = conta n t

--b)
grau :: Polinomio -> Int
grau l = maximum (toNum l)

toNum :: Polinomio -> [Int]
toNum l = map (\(a,b)-> b) l

--c)
selgrau :: Int -> Polinomio -> Polinomio
selgrau _ [] = []
selgrau n  ((a,b):t) | n == b = (a,b):selgrau n t
                     | otherwise = selgrau n t
selgrau' n l = filter (\(a,b) -> if b == n then True else False) l

--d)
deriv :: Polinomio -> Polinomio
deriv p = map (\(a,b) -> (a*(fromIntegral b),b-1)) p

--h)
normaliza :: Polinomio -> Polinomio
normaliza [] = []
normaliza ((c,e):t) = (c+n,e):normaliza (deleteR e t)
                        where p = selgrau e t
                              n = sum (map (fst) p)

deleteR :: Int -> Polinomio -> Polinomio
deleteR _ [] = []
deleteR n ((c,e):t) | n == e = deleteR n t
                    | otherwise = (c,e):deleteR n t
{-
produto :: Polinomio -> Polinomio -> Polinomio
produto [] _ = []
produto (m:t) p2 = soma (mult m p) (produto t p)
-}

--k)
ordena :: Polinomio -> Polinomio
ordena [] = []
ordena ((c,e):t) = inst (c,e) (ordena t)

inst :: Monomio -> Polinomio -> Polinomio
inst (c,e) [] = [(c,e)]
inst (c,e) ((a,b):t) | e <= b = (c,e):(a,b):t
                     | otherwise = (a,b):inst (c,e) t

--4)
--a)
zipwith' :: (a->b->c) -> [a] -> [b] -> [c]
zipwith' f (x:xs) (y:ys) = (f x y) : zipwith' f xs ys
zipwith' _ _ _ = []

--b)
takewhile' :: (a->Bool) -> [a] -> [a]
takewhile' f [] = []
takewhile' f (h:t) | f h = h : takewhile' f t 
                   | otherwise = []

--c)
dropwhile' :: (a->Bool) -> [a] -> [a]
dropwhile' f [] = []
dropwhile' f (h:t) | f h = dropwhile' f t
                   | otherwise = (h:t)

span' :: (a->Bool) -> [a] -> ([a],[a])
span' f [] = ([],[])
span' f (h:t) | f h = (h:l1,l2)
              | otherwise = (l1,h:l2)
                where (l1,l2) = span f t
