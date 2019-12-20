data ExpInt = Const Int 
            | Simetrico ExpInt 
            | Mais ExpInt ExpInt
            | Menos ExpInt ExpInt
            | Mult ExpInt ExpInt
    deriving Show

--Mais :: ExpInt -> ExpInt -> ExpInt
--Const :: Int -> ExpInt

--pergunta prof:
--Represente a expressão através do data ExpInt.
e1 :: ExpInt -- "10 + 5 * (3 -2)" 
e1 = Mais (Const 10) (Mult (Const 5) (Menos (Const 3) (Const 2))) 

e2 :: ExpInt
e2 = Mult (Mais (Const 10) (Const 5)) (Menos (Const 3) (Const 2))

--1)
--a)
calcula :: ExpInt -> Int 
calcula (Const v) = v 
calcula (Simetrico e) = - (calcula e)
calcula (Mais e d) = (calcula e) + (calcula d)
calcula (Menos e d) = (calcula e) - (calcula d)
calcula (Mult e d) = (calcula e) * (calcula d) 

--b)
infixa :: ExpInt -> String
infixa (Const v) = show v
infixa (Simetrico e) = "-("++(infixa e)++")" 
infixa (Mais e d) = "("++(infixa e)++" + "++(infixa d)++")"
infixa (Menos e d) = "("++(infixa e)++" - "++(infixa d)++")"
infixa (Mult e d) = "("++(infixa e)++" * "++(infixa d)++")"

--2)
data RTree a = R a [RTree a]
rt :: RTree Int 
rt = R 5 [R 3 [] , R 10 [], R 4 [R 7 []]]

--            5
--           /|\
--          / | \
--         /  |  \
--        /   |   \
--       3    10   4
--       *     *   |
--                 |
--                 | 
--                 |  
--                 7
--                 *

--a)
soma :: (Num a) => (RTree a) -> a
soma (R v rs) = v + sum' (map (soma) rs)
                    --foldr (+) 0 = sum -> Caso não pudesse usar o sum
-- isto é para o caso de não podermos usar o sum do prelude, temos que
-- ser nós a definir.
sum' :: Num a => [a] -> a
sum' [] = 0
sum' (x:xs) = x+(sum' xs)

--b)
altura :: (RTree a) -> Int
altura (R v []) = 1 
altura (R _ rt) = 1 + maximum (map altura rt)

--c)
--v1)
prune :: Int -> (RTree a) -> (RTree a)
prune 1 (R v _) = R v []
prune n (R v rt) = R v (map (prune (n-1)) rt)
--v2)
prune' n (R x xs) | n > 0 =  (R x (map (prune' (n-1)) xs ))
                  | otherwise = (R x [])

--d)
--v1)
mirror :: (RTree a) -> (RTree a)
mirror (R v rt) = R v (reverse (map mirror rt))
--v2)
mirror' (R x xs) = (R x (map mirror' (reverse xs)))

--e)

postorder :: (RTree a) -> [a]
postorder (R v rs) =
    (foldr1 (++) (map postorder rs))++[v]


mapaRT :: (a->b) -> RTree a -> RTree b
mapaRT f (R v []) = R (f v) []
mapaRT f (R v rs) = R (f v) (map (mapaRT f ) rs)


-- Vamos fazer uma instância Show. (Professor -> Dúvida de alguém)
instance Show a => Show (RTree a) where
    show = showRT


showRT :: Show a => RTree a -> String
showRT (R v rs) = "["++(show v)++(concat (map showRT rs))++"]" 
-- Notas: 
{-
		1
	   /\
	  2  3
	 /\
	4  5

inorder: 4,2,5,1,3
preorder: 1,2,4,5,3
postorder: 4,5,2,3,1


-}
-- Exercício do Professor:
-- Fazer uma função que vá pelo comigo mais à esquerda ou mais à direita.

descEsq ::Num a => RTree a -> [a]
descEsq (R v []) = v:[]
descEsq (R v xs) = v:(descEsq (head xs))

--3) 
data LTree a = Tip a | Fork (LTree a) (LTree a)
    deriving (Show,Eq)

--a)
--i)
ltSum :: (Num a) => (LTree a) -> a
ltSum (Tip x) = x
ltSum (Fork l r) = (ltSum l) + (ltSum r)

--ii)
listaLT :: (LTree a) -> [a]
listaLT (Tip a) = [a]
listaLT (Fork l r) = (listaLT l) ++ (listaLT r)

--iii)
ltHeigth :: (LTree a) -> Int
ltHeigth (Tip a) = 1
ltHeigth (Fork l r) = 1 + (max (ltHeigth l) (ltHeigth r))

--b)
data FTree a b = Leaf b | No a (FTree a b) (FTree a b)
    deriving (Show,Eq)
data BTree a = Empty | Node a (BTree a) (BTree a)
    deriving (Show,Eq)
--i)
splitFTree :: (FTree a b) -> (BTree a, LTree b)
splitFTree (Leaf x) = (Empty,Tip x)
splitFTree (No x e d) = (((Node x (tronco1) (tronco2))),(Fork (folhas1) (folhas2)))
                        where (tronco1,folhas1) = splitFTree e
                              (tronco2,folhas2) = splitFTree d