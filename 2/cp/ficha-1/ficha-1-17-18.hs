length1 :: [a] -> Int
length1 [] = 0
length1 (h:t) = 1 + length t

reverse1 :: [a] -> [a]
reverse1 [] = []
reverse1 (h:t) = (reverse1 t)++[h]

catMaybes :: [Maybe a] -> [a]
catMaybes [] = []
catMaybes (Nothing:t) = catMaybes t
catMaybes ((Just a):t) = a:catMaybes t

uncurry1 :: (a->b->c) -> (a,b)-> c
uncurry1 f (a,b) =  f a b

curry1 :: ((a,b)->c) -> a -> b -> c
curry1 f a b = f(a,b)

flip1 :: (a->b->c) -> b -> a -> c
flip1 f a b = f b a

data LTree a = Leaf a | Fork (LTree a,LTree a)

--ex_6
--a)

foldr' :: (a->b->b) -> b -> [a] -> b
foldr' g z [] = z
foldr' g z (x:xs) = g x (foldr' g z xs)

length2 :: [a] -> Int
length2 l = foldr' g 0 l
			where g x i = i + 1

--b)

--ex_7

concat1 :: [[a]] -> [a]
concat1 l = foldr (++) [] l

--ex_8

f :: [Int] -> [Int]
f (h:t) | h > 0 = (h+1):f t
		| otherwise = f t

f1 :: (Num a, Ord a) => [a] -> [a]
f1 l = foldr g [] l 
		where g x xs | x > 0 = (x+1): xs
					 | otherwise = xs

--ex_9

m :: (a->b)->[a]->[b]
m f [] = []
m f (h:t) = (f h):m f t


m1 :: (a->b) -> [a] -> [b]
m1 f (h:t) = (foldr g [] [h]):m1 f t
			where g x y = f y
