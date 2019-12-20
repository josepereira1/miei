module Main where
import System.Random
import Data.List

--explicação:
main = putStrLn "Hello World"

{-
putStrLn :: IO ()
getChar :: IO Char 
getLine :: IO String
-}
func :: Int -> IO Int 
func x = do 
    putStrLn "ola"
    c <- getChar
    let str = [c]
    return x

--1)
--a)
bingo :: IO ()
bingo = do 
    geraNumeros4 [1..90]

geraNumeros1 :: [Int] -> IO ()
geraNumeros1 [] = putStrLn "acabou."
geraNumeros1 ns = do
    v <- randomRIO (1,90)
    if (elem v ns) 
    then do -- o do serve para encandear vários IO's 
        c <- getChar
        putStrLn (show v)
        geraNumeros1 (filter (\x->x/=v) ns) -- (delete v ns)
    else geraNumeros1 ns 

geraNumeros2 :: [Int] -> IO ()
geraNumeros2 [] = putStrLn "acabou."
geraNumeros2 ns = do 
    let n = length ns
    i <- randomRIO (0,n-1) :: IO Int
    let v = ns !! i 
    c <- getChar  -- getChar 
    putStrLn (show v)
    geraNumeros2 (delete v ns)

geraNumeros3 :: [Int] -> IO ()
geraNumeros3 [] = putStrLn "acabou."
geraNumeros3 ns = do
    let n = length ns
    i <- randomRIO (0,n-1) :: IO Int 
    getChar
    newns <- retirarImpr i ns 
    geraNumeros3 newns

retirarImpr :: Int -> [Int] -> IO [Int]
retirarImpr i ns = do
    let v = ns !! i
    putStrLn (show v)
    return (delete v ns)

geraNumeros4 :: [Int] -> IO()
geraNumeros4 [] = putStrLn "Acabou!"
geraNumeros4 lista = do
    let size = length lista
    n <- randomRIO (0,size-1) :: IO Int
    let x = lista !! n
    getChar
    putStrLn (show x)
    --let resto = removeElem lista x 0
    geraNumeros4 (delete x lista)

removeElem :: [Int] -> Int -> Int -> [Int]
removeElem [] _ _ = []
removeElem (h:t) n flag 
    | n == flag = t 
    | otherwise = h:removeElem t n (flag+1)

--b)
{-
mastermind :: IO ()
mastermind = do 
    ns <- geraSeq
    testaSeq

geraSeq :: IO [Int]
testaSeq :: IO ()
 ... pede 4 numeros 
 ... calcula "ok" e "quase ok"
 ... se adivinhou todos: acabou
 ...    caso contrário: tente outra vez
-}
--2)
data Aposta = Ap [Int] (Int,Int)
ap1 = Ap [1,2,3,4,5] (3,5) :: Aposta
ap2 = Ap [1,2,3,4,7] (5,1) :: Aposta

--a)
valida :: Aposta -> Bool
valida ap@(Ap numeros (e1,e2)) = auxValida ap (length numeros) 

auxValida :: Aposta -> Int -> Bool
auxValida (Ap [] _ ) n = True 
auxValida (Ap (h:t) (e1,e2)) n
    | n /= 5 = False 
    | h `elem` t = False
    | e1 == e2 = False
    | h >= 1 && h <= 50 && e1 >= 1 && e1 <= 9 && e2 >=1 && e2 <= 9 = auxValida (Ap t (e1,e2)) n
    | otherwise = False

--b)
comuns :: Aposta -> Aposta -> (Int,Int)
comuns (Ap [] _) (Ap [] _) = (0,0)
comuns (Ap (h:t) (e1,e2)) (Ap (x:xs) (s1,s2)) = (numeros1+num, estrelas1 + estrelas2)
    where numeros1 = contaNumeros (x:xs) h
          estrelas1 = contaEstrelas (e1,e2) s1
          estrelas2 = contaEstrelas (e1,e2) s2
          (num,est) = comuns (Ap t (0,0)) (Ap xs (0,0))

contaNumeros :: [Int] -> Int -> Int 
contaNumeros [] n = 0
contaNumeros (h:t) n | h == n = 1 + (contaNumeros t n)
                     | otherwise = contaNumeros t n
contaEstrelas :: (Int,Int) -> Int -> Int
contaEstrelas (a,b) n | n == a = 1
                      | n == b = 1
                      | otherwise = 0

--c)
--i)
instance Eq Aposta where
    (Ap [x1,x2,x3,x4,x5] (e1,e2)) == (Ap [a1,a2,a3,a4,a5] (b1,b2)) =
        x1 == a1 && x2 == a2 && x3 == a3 && x4 == a4 && x5 == a5 && e1 == b1 && e2 == b2
--ii)
premio :: Aposta -> Aposta -> Maybe Int 
premio (Ap lista1 est) (Ap lista2 est2)
    | n == 5 && e == 2 = Just 1
    | n == 5 && e == 1 = Just 2
    | n == 5 && e == 0 = Just 3
    | n == 4 && e == 2 = Just 4
    | n == 4 && e == 1 = Just 5
    | n == 4 && e == 0 = Just 6
    | n == 3 && e == 2 = Just 7
    | n == 2 && e == 2 = Just 8
    | n == 3 && e == 1 = Just 9
    | n == 3 && e == 0 = Just 10
    | n == 1 && e == 2 = Just 11 
    | n == 2 && e == 1 = Just 12
    | n == 2 && e == 0 = Just 13
        where (n,e) = comuns (Ap lista1 est) (Ap lista2 est2)

--d)
--i)

leAposta :: IO Aposta
leAposta = do
   l <- leNumeros 0
   (e1,e2) <- leEstrelas
   if (valida (Ap l (e1,e2)))
   then do
   putStrLn ("Jogada válida, aguarde o prémio!") 
   return (Ap l (e1,e2))
   else do 
   putStrLn("Jogada inválida, coloque novamente os números e estrelas:")
   leAposta


   
leEstrelas :: IO (Int,Int)
leEstrelas = do
 putStrLn("Insira a primeira estrela:")
 y <- getLine
 let e1 = read y :: Int
 putStrLn("Insira a segunda estrela:")
 z <- getLine 
 let e2 = read z :: Int
 return (e1,e2)
 
leNumeros :: Int -> IO [Int]
leNumeros n = do
  if (n == 5) 
  then do return []
  else do
  putStrLn("Insira um número correspondente à posição "++(show (n+1))++":")
  a <- getLine
  let x = read a :: Int
  xs <- leNumeros (n+1)
  return (x:xs)