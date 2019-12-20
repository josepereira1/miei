data BTree a = Empty
             | Node a (BTree a) (BTree a)   --Node é um construtor, que vai ser usado para "construir" a árvore.
    deriving (Show,Eq)

arB = (Node 4 (Node 5 (Empty) (Empty)) (Node 7 (Empty) (Empty)))

--1)
--a)
altura :: BTree a -> Int    -- r = right; l = left
altura Empty = 0
altura (Node _ l r) = 1 + max (altura l) (altura r) 

--b)
contaNodos :: BTree a -> Int 
contaNodos Empty = 0
contaNodos (Node _ l r) = 1 + (contaNodos l) + (contaNodos r)

--c)
folhas :: Eq a => (BTree a) -> Int 
folhas Empty = 0
folhas (Node x e d) | e == Empty && d == Empty = 1 + (folhas e) + (folhas d)
                    | otherwise = (folhas e) + (folhas d)
--d)
a = Node 24 (Node 10 (Empty) (Empty)) (Node 7 Empty Empty)

prune :: Int -> BTree a -> BTree a  --aqui podemos pensar no exemplo da videira.
prune _ Empty = Empty
prune n (Node x l r) | n > 0 = (Node x) (prune (n-1) l) (prune (n-1) r) 
                     | otherwise = Empty

--e)
--b = Node 7 ((Node 4 Empty (Node 6 ((Node 5 Empty Empty) Empty)) (Node 8 Empty Node 15 (Empty Empty))))
path :: [Bool] -> BTree a -> [a]
path _ Empty = []
path [] (Node x l r) = [x]  --se eu não tenho instruções, mas estive pelo menos no primeiro.
path (h:t) (Node x l r) | h = x:(path t r)
                        | otherwise = x:(path t l)  

--f) 

-- Não está certa!
mirror :: BTree a -> BTree a
mirror Empty = Empty
mirror (Node x l r) = Node x  (mirror r) (mirror l)


--g)
zipWithBT :: (a -> b -> c) -> (BTree a) -> (BTree b) -> BTree c
zipWithBT f Empty _ = Empty
zipWithBT f _ Empty = Empty
zipWithBT f (Node v1 l1 r1) (Node v2 l2 r2) = Node (f v1 v2) (zipWithBT f l1 l2) (zipWithBT f r1 r2)

--h)
{-
unzipBT :: (BTree (a,b,c)) -> (BTree a,BTree b,BTree c)
unzipBT Empty = (Empty,Empty,Empty)
unzipBT (Node (a,b,c) e d) = ((Node a (unzipBT e) (unzipBT d)),(Node b (unzipBT e) (unzipBT d)),(Node c (unzipBT e) (unzipBT d)))
-}

--2)
--a)
minimo :: (Ord a) => BTree a -> a
minimo arv@(Node x e d) = auxMinimo arv x

auxMinimo :: (Ord a) => BTree a -> a -> a
auxMinimo Empty n = n 
auxMinimo (Node x e d) n | x < n = auxMinimo e x
                         | otherwise = auxMinimo e n

--b)
semMinimo :: (Ord a) => BTree a -> BTree a
semMinimo Empty = Empty
semMinimo arvB = auxSemMinimo arvB (minimo arvB)
auxSemMinimo :: (Ord a) => BTree a -> a -> BTree a
auxSemMinimo Empty n = Empty
auxSemMinimo (Node x e d) n | x == n = Empty
                            | otherwise = (Node x (auxSemMinimo e n) d)

--c)
minSmin :: (Ord a) => BTree a -> (a,BTree a)
minSmin (Node x e d) = auxMinSmin (Node x e d) x
auxMinSmin (Node x e d) n | x < n && e == Empty && d == Empty 
                            = (x ,Empty)
                          | x < n = (x,Node x (arB2) d)
                          | otherwise = (min1, Node x (arB1) d)
                            where (min1,arB1) = auxMinSmin e n
                                  (min2,arB2) = auxMinSmin e x
--3)
type Aluno = (Numero,Nome,Regime,Classificacao)
type Numero = Int 
type Nome = String
data Regime = ORD 
            | TE
            | MEL
    deriving (Show,Eq)
data Classificacao = Aprov Int 
                   | Rep 
                   | Faltou
    deriving (Show,Eq)
type Turma = BTree Aluno --árvore binária de procura (ordenada por número)

t1 :: Turma 
t1 = (Node (1,"Nuno",TE,Faltou) (Empty) (Node (82880,"Martins",TE,Faltou) (Empty) (Empty))) 

--a)
inscNum :: Numero -> Turma -> Bool
inscNum n Empty = False
inscNum n (Node v e d) | n == num v = True 
                       | n < num v = inscNum n e 
                       | n > num v = inscNum n d

num :: Aluno -> Numero  --criamos esta função para retornar o número do aluno.
num (n,_,_,_) = n 

--b)
inscNome :: Nome -> Turma -> Bool 
inscNome n Empty = False
inscNome n (Node v e d) | n == nome v = True
                        | otherwise = (inscNome n e) || (inscNome n d)

--c)
trabEst :: Turma -> [(Numero,Nome)]
trabEst Empty = []
trabEst t = ordena (auxTrabEst t)

auxTrabEst :: Turma -> [(Numero,Nome)]
auxTrabEst Empty = []
auxTrabEst (Node x e d)
  | reg == TE = [(n,nome)]++(auxTrabEst e)++(auxTrabEst d)
  | otherwise = (auxTrabEst e)++(auxTrabEst d)
    where (n,nome,reg,clss) = x

ordena :: [(Numero,Nome)] -> [(Numero,Nome)]
ordena [] = []
ordena (h:t) = insertAluno h (ordena t)

insertAluno :: (Numero,Nome) -> [(Numero,Nome)] -> [(Numero,Nome)]
insertAluno n [] = [n]
insertAluno (n,nome) ((a,b):t)
  | n < a = (n,nome):((a,b):t)
  | otherwise = (a,b):insertAluno (n,nome) t

nome :: Aluno -> Nome
nome (_,n,_,_) = n

--d)
nota :: Numero -> Turma -> Maybe Classificacao
nota n Empty = Nothing
nota n (Node v e d) | n == num v = Just (classif v)
                    | n > num v = nota n d 
                    | n < num v = nota n e   

classif :: Aluno -> Classificacao
classif (_,_,_,c) = c

--e)
percFaltas :: Turma -> Float
percFaltas Empty = 0
percFaltas arvB = (auxPercFaltas arvB)/(fromIntegral (altura arvB))

auxPercFaltas :: Turma -> Float
auxPercFaltas Empty = 0
auxPercFaltas (Node x e d)
  | clas == Faltou = 1 + (auxPercFaltas e) + (auxPercFaltas d)
  | otherwise = (auxPercFaltas e) + (auxPercFaltas d)
    where (n,nome,reg,clas) = x

--f)










