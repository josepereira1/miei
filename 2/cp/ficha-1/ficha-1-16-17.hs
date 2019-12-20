module Main where

--2)
length' :: [a] -> Int
length' [] = 0
length' (x:xs) = 1 + length' xs

reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = (reverse xs)++[x]

--3)
catMaybes :: [Maybe a] -> [a]
catMaybes [] = []
catMaybes (Nothing:xs) = catMaybes xs
catMaybes ((Just x):xs) = x:(catMaybes xs)

--5)
data LTree a = Leaf a | Fork (LTree a,LTree a)
    deriving Show

lt = Fork (Leaf 1,Leaf 2)

flatten :: LTree a -> [a]
flatten (Leaf a) = [a]
flatten (Fork (x1,x2)) = (flatten x1)++(flatten x2)

mirror :: LTree a -> LTree a
mirror (Leaf x) = Leaf x
mirror (Fork (x1,x2)) = Fork (mirror x2, mirror x1)

fmap' :: (b -> a) -> LTree b -> LTree a
fmap' f (Leaf x) = Leaf (f x)
fmap' f (Fork (x1,x2)) = Fork ((fmap' f x1),(fmap' f x2))

--6)
length'' :: [a] -> Int
length'' = foldr (\ _ xs -> 1 + xs) 0

--8)
f :: [Int] -> [Int]
f s = foldr (\ x xs -> if x > 0 then (x+1):xs else xs) [] s
-- (map (+1)).(filter (>0))
--primeiro, gera a lista sem os negativos, e depois com essa lista aplica o map.

--9)
m :: (a -> b) -> [a] -> [b]
m f l = foldr (\x xs -> (f x):xs) [] l
