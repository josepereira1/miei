
module Ficha10 where
data Frac = F Integer Integer

--1)
--a)
normaliza :: Frac -> Frac
normaliza (F n d) | n < 0 && d < 0 = (F (abs (div n m)) (abs(div d m)))
                  | n > 0 && d > 0 = (F (div n m) (div d m))
                  | n < 0 && d > 0 = (F (div n m) (div d m))
                  | n > 0 && d < 0 = (F ((-1)*(div n m)) ((-1)*(div d m)))
                  | otherwise = (F (div n m) (div d m))
                         where m = mdc (abs n) (abs d)  
normaliza' :: Frac -> Frac
normaliza' (F n d)  = (F (div n m) (div d m))
                        where m = mdc n d  

-- | Explicação no caderno.
mdc :: Integer -> Integer -> Integer
mdc 0 _ = error "can"
mdc x y | x /= y && (x-y) > 0 = mdc (x-y) y
        | x /= y && (y-x) > 0 = mdc x (y-x)
        | x == y = x 
--b)
instance (Eq Frac) where
    -- Eu posso fazer (a' == y') pq tal como podemos ver no data Frac a' e y' são Integer, logo o haskell sabe comparar inteiros, ele só não sabe comparar frações.
    (F a b) == (F x y) = (a' == x') && (b' == y')
        where (F a' b') = normaliza (F a b)
              (F x' y') = normaliza (F x y)

instance (Ord Frac) where
    (F a b) <= (F x y) = a' <= x' 
            where (F a' b') = (F (a*y) (b*x)) 
                  (F x' y') = (F (x*b) (y*a))

instance (Show Frac) where
     show (F a b) = "("++(show a)++"/"++(show b)++")"

instance (Num Frac) where
    (+) (F a b) (F x y) = normaliza (F (a' + x') b')
        where (F a' b') = (F (a*y) (b*x)) 
              (F x' y') = (F (x*b) (y*a))
    {-
    (-) (F a b) (F x y) = normaliza (F (a' - x') b')
        where (F a' b') = (F (a*y) (b*x)) 
              (F x' y') = (F (x*b) (y*a))
    -}
    (*) (F a b) (F x y) = (F (a'*x') (b'*y'))
            where (F a' b') = (F (a'*a) (b'*b))
                  (F x' y') = (F (x'*x) (y'*y))
    (fromInteger) a = (F a 1)
    negate (F n d) = (F ((-1)*n) d)
    abs (F n d) = (F n1 d1)
                  where n1 = abs n 
                        d1 = abs d
    signum (F a b) | a > 0 && b > 0 = 1
                   | a == 0 || b == 0 = 0
                   | otherwise = -1 

--2)
data Exp a = Const a
           | Simetrico (Exp a)
           | Mais (Exp a) (Exp a)
           | Menos (Exp a) (Exp a)
           | Mult (Exp a) (Exp a)
    deriving Ord
--a)
  
instance (Show a) => Show (Exp a) where
  show (Const c) = show c
  show (Simetrico a) = "(-"++(show a)++")"
  show (Mais a b) = "("++(show a)++"+"++(show b)++")"
  show (Menos a b) = "("++(show a)++"-"++(show b)++")"
  show (Mult a b) = "("++(show a)++"*"++(show b)++")"

--b)

instance Eq a => Eq (Exp a) where
  (Const a) == (Const b) = a == b
  (Simetrico a) == (Simetrico b) = a == b 
  (Mais a b) == (Mais c d) = (a == c && b == d) || (a == d) && (b == c)
  (Menos a b) == (Menos c d) = a == c && b == d
  (Mult a b) == (Mult c d) = a == c && b == d

--c)

instance (Ord a, Num a) => Num (Exp a) where 
  (+) (Const c) (Const b) = Const (c + b)
  (+) a b = maisExp a b
  (*) (Const a) (Const b) = Const (a * b)
  --fromInteger a = (Const a)
  negate (Const a) = (Const ((-1) * a))
  abs (Const a) = Const (abs a)
  signum (Const a) | a > 0 = (Const 1) 
                   | a == 0 = (Const 0)
                   | otherwise = (Const (-1))

--3)
data Movimento = Credito Float | Debito Float
data Data = D Int Int Int
  deriving Eq
data Extracto = Ext Float [(Data,String,Movimento)]

e :: Extracto
e = Ext 154.5 [(D 2 10 2016,"MB", Debito 1000),
              (D 3 10 2016,"sal", Credito 200),
              (D 3 10 2016,"VV", Debito 3.4),
              (D 20 3 2001,"Compra", Credito 10000),
              ((D 2 10 2014),"Deposito",Debito 100000)] :: Extracto

--a)

instance Ord Data where
  date1@(D d1 m1 a1) <= date2@(D d2 m2 a2) = menorIgual date1 date2 

menorIgual :: Data -> Data -> Bool
menorIgual (D d1 m1 a1) (D d2 m2 a2)
  | a2 > a1 = True
  | m2 > m1 = True
  | d2 > d1 = True
  | otherwise = False

instance Show Data where
  show (D d m a) = showData (D d m a)

showData :: Data -> String
showData (D d m a) = (show d)++"/"++(show m)++"/"++(show a)

--c)
ordena :: Extracto -> Extracto
ordena (Ext valor mvs) = (Ext valor ord)
    where ord = sort mvs

sort :: [(Data,String,Movimento)] -> [(Data,String,Movimento)]
sort [] = []
sort (h:t) = insertExt h (sort t)

insertExt :: (Data,String,Movimento) -> [(Data,String,Movimento)] -> [(Data,String,Movimento)]
insertExt date [] = [date]
insertExt (date1,str1,mv1) ((date2,str2,mv2):t) 
  | date1 < date2 = (date1,str1,mv1):((date2,str2,mv2):t)
  | otherwise = (date2,str2,mv2):(insertExt (date1,str1,mv1) t)

instance Show Extracto where
  show (Ext valorInicial ((d,s,m):t)) = showExtracto ord
    where ord = ordena (Ext valorInicial ((d,s,m):t))

showExtracto :: Extracto -> String
showExtracto ext@(Ext valorInicial ((date,str,mvs):t)) = 
  "Saldo anterior: "++(show valorInicial)++"\n"++"--------------------------------------------------\n"++"Data       Descricao   Credito   Debito\n"++"--------------------------------------------------\n"++showMovs ((date,str,mvs):t)++"--------------------------------------------------\n"++"Saldo atual: "++show (valorFinal)
    where valorFinal = saldo ext

showMovs :: [(Data,String,Movimento)] -> String
showMovs [] = []
showMovs ((d,s,Credito v):t) = ((show d)++"   "++(show s)++"      "++(show v))++"\n"++(showMovs t)
showMovs ((d,s,Debito v):t) = ((show d)++"   "++(show s)++"                 "++(show v))++"\n"++(showMovs t)

-- Funções da ficha 7
creDeb :: Extracto -> (Float,Float)
creDeb (Ext vi []) = (0,0)
creDeb (Ext vi ((date,e,(Credito v)):t)) = 
  (v+c,d)
   where (c,d) = creDeb (Ext vi t)
creDeb (Ext vi ((date,e,(Debito v)):t)) = 
  (c,v+d)
   where (c,d) = creDeb (Ext vi t)

saldo :: Extracto -> Float
saldo est@(Ext vi ((date,e,mvs):t)) = (vi + d) - c
  where (c,d) = creDeb est
