--LI_2.pdf
--A)
--1) 

--a)
perimetro :: Float ->Float
perimetro cmp = 2*pi*cmp

inc :: Int->Int
inc num =  num+1

--b)
dist :: (Float, Float) ->(Float, Float)->Float
dist(x1,y1)(x2,y2) = sqrt(((x2-x1)^2) + (y2-y1)^2)

--c)
primUlt :: [a] ->(a,a)
primUlt l = (head l, last l)

--d)
multiplo :: Int -> Int -> Bool
multiplo m n = if mod m n == 0 then True else False 

multiplo2 m n = mod m n == 0 --2a versão do mesmo exercício

multiplo3 m n | mod m n == 0 = True --3a versão do mesmo exercício
			  |otherwise   =False

--e)
truncaImpar l = if (mod (length l) 2 /= 0) then tail l else l

--f)
max2 :: Int-> Int->Int
max2 n m = if(n>m)then n else m

--g)
max3 :: Int-> Int -> Int-> Int
max3 n m x =  if((max2 n m)>x)then max2 n m else x 

--2)

--a)
nRaizes :: Float -> Float -> Float -> Int
nRaizes a b c = 
    if((b^2-(4*a*c))>=0)then 
    length [((-b+sqrt(b^2-(4*a*c)))/(2*a)),((-b-sqrt(b^2-(4*a*c)))/(2*a))]
    else
        0

--b)
raizes :: Float -> Float -> Float -> [Float]
raizes a b c = 
    if ((b^2-(4*a*c))>=0) then
        if ((b==0) && (c==0))then
            [0]
        else
            [((-b+sqrt(b^2-(4*a*c)))/(2*a)),((-b-sqrt(b^2-(4*a*c)))/(2*a))]
    else 
        []

--3)

type Ponto = (Float, Float)
--esta função é do exercício 1
dist :: (Float, Float) -> (Float, Float) -> Float
dist (x1,y1) (x2,y2) = sqrt((x2-x1)^2 + (y2-y1)^2)

--a)
c_triangulo :: Ponto -> Ponto -> Ponto -> (Float, Float, Float)
c_triangulo (x1,y1)(x2,y2)(x3,y3) = (sqrt((x2-x1)^2 +(y2-y1)^2),sqrt((x3-x2)^2 +(y3-y2)^2), sqrt((x1-x3)^2 +(y1-y3)^2))

--b)
p_triangulo :: Ponto -> Ponto -> Ponto -> Float
p_triangulo (x1,y1) (x2,y2) (x3,y3) = 
    dist (x1,y1) (x2,y2) + dist (x2,y2) (x3,y3) + dist (x3,y3) (x1,y1)
    --sqrt((x2-x1)^2 +(y2-y1)^2) + sqrt((x3-x2)^2 +(y3-y2)^2) + sqrt((x1-x3)^2 +(y1-y3)^2) 

pontos_retangulo :: Ponto -> Ponto -> [Ponto]
pontos_retangulo (x1,y1) (x2, y2) = [(x1,y1), (x2,y1), (x2,y2), (x1,y2)]

--4)

type Hora = (Int, Int)
--a)
validarHora :: Hora -> Bool
validarHora (h,m) = if ((h>=0 && h<=24)&&(m>=0 && m<=59)) then True else False

--b)
comp_horas :: Hora -> Hora -> Bool
comp_horas (h1,m1) (h2, m2) = if((h1,m1)>=(h2,m2)) then True else False

--c)
conv_h_m :: Hora -> Int
conv_h_m (h,m) = h*60 + m

--d)
-- Eu aqui tive que alterar a estrutura Hora para (Float, Float), posso fazê-lo?
conv_m_h :: (Float, Float) -> Float 
conv_m_h (h,m) = (m/60) + h

--e)
dife_hora :: Hora -> Hora -> Int
dife_hora (h1,m1) (h2,m2) = if((h1,m1)>=(h2,m2)) then conv_h_m ((h1-h2), (m1-m2)) else conv_h_m ((h2-h1), (m2-m1)) 

--f)
add_minutos :: Hora -> Int -> (Int, Int)
add_minutos (h,m) minutos = if ((m+minutos) >= 60) 
    then 
    (((div (m+minutos) 60) + h), mod (m+minutos) 60) 
    else 
    (h, m + minutos)

--B)
module Main where 
import System.IO
soma :: Int -> Int -> Int
soma x y = x+y

main = do hSetBuffering stdout NoBuffering
          putStr "x= "
          x_inp <- getLine 
          putStr "y= "
          y_inp <- getLine
          let y = read y_inp
          putStrLn ("x + y = " ++ show (soma x y))

