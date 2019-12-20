-- função perímetro
perimetro :: Float ->Float
perimetro cmp = 2*pi*cmp

--função inc
inc :: Int->Int
inc num =  num+1

--função distância
dist :: (Float, Float) ->(Float, Float)->Float
dist(x1,y1)(x2,y2) = sqrt(((x2-x1)^2) + (y2-y1)^2)

--função primUlt
primUlt :: [a] ->(a,a)
primUlt l = (head l, last l)

--multiplo
multiplo :: Int -> Int -> Bool
multiplo m n = if mod m n == 0 then True else False 

multiplo2 m n = mod m n == 0 --2a versão do mesmo exercício

multiplo3 m n | mod m n == 0 = True --3a versão do mesmo exercício
			  |otherwise   =False

truncaImpar l = if (mod (length l) 2 /= 0) then tail l else l

max2 :: Int-> Int->Int
max2 n m = if(n>m)then n else m

max3 :: Int-> Int -> Int-> Int
max3 n m x =  if((max2 n m)>x)then max2 n m else x 

