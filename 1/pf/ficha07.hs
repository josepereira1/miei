module LibFicha7 where 
--1)
data Contacto = Casa Integer  --Isto é uma função, a diferença é que começa por maíscula, mas denominam-se por construtores.
              | Trab Integer
              | Tlm Integer
              | Email String
    deriving Show --permite escrever amigos no ghci.
type Nome = String
type Agenda = [(Nome, [Contacto])]

amigos :: Agenda  -- amigos é uma função
amigos = [("To",[Casa 253]), ("Ze", [Trab 253, Tlm 96]), ("Ana",[Email "ana@gmail.com"])]

-- nc = nome dos contactos 
-- cs = contactos 

--a)
acrescEmail :: Nome -> String -> Agenda -> Agenda
acrescEmail n s [] = [(n,[Email s])]
acrescEmail n s ((nc,cs):t) | n == nc = (nc,Email s:cs):t
                            | otherwise = (nc,cs):acrescEmail n s t

--b)
{-
data Maybe a = Nothing 
             | Just a 
        deriving Show 
-}

--v1)
verEmails :: Nome -> Agenda -> Maybe [String] 
verEmails n [] = Nothing 
verEmails n ((nc,cs):t) | n == nc = Just (email cs)
                        | otherwise = verEmails n t                                  

email :: [Contacto] -> [String]
email [] = []
email (Email s :t) = s :email t
email (h:t) = email t

--v2)
--Ordem Superior (OS):
--Dúvida? -> Não funciona!
emailOS :: [Contacto] -> [String]
emailOS cs = map (\(Email s) -> s) lemail
    where lemail = filter f cs 

f :: Contacto -> Bool
f (Email _) = True
f _ = False

--c)
consTelefs :: [Contacto] -> [Integer]
consTelefs [] = []
consTelefs (Casa h:t) = h:consTelefs t
consTelefs (Trab h:t) = h:consTelefs t 
consTelefs (Tlm h:t) = h:consTelefs t 

--2)
type Dia = Int
type Mes = Int
type Ano = Int 
type Name = String

m1 = [("Nuno",(D 1 9 1995)),("Pedro", D 19 8 2000),("Joana", D 11 1 1997),("Martins", D 19 6 1997)] :: TabDN
type TabDN = [(Nome,Data)]

--a)
procura :: Name -> TabDN -> Maybe Data
procura n [] = Nothing
procura n ((nome,date):t) | n == nome = Just date
                          | otherwise = procura n t

--b)
idade :: Data -> Nome -> TabDN -> Maybe Int
idade _ nome [] = Nothing
idade atualDate@(D d1 m1 a1) nome ((n,(D d2 m2 a2)):t) 
  | nome == n && m1 > m2 = Just (a1 - a2)
  | nome == n && m1 < m2 = Just ((a1 - a2)-1)
  | nome == n && m1 == m2 && d1 >= d2 = Just (a1 - a2)
  | nome == n && m1 == m2 && d1 < d2 = Just ((a1 - a2)-1)
  | otherwise = idade atualDate nome t 

--c)
anterior :: Data -> Data -> Bool
anterior (D d1 m1 a1) (D d2 m2 a2)
  | a2 > a1 = True 
  | a2 == a1 && m2 > m1 = True 
  | a2 == a1 && m2 == m1 && d2 > d1 = True 
  | otherwise =  False

--d)
ordena :: TabDN -> TabDN
ordena [] = []
ordena (h:t) = insertData h (ordena t)

insertData :: (Nome,Data) -> TabDN -> TabDN
insertData d1 [] = [d1]
insertData inf1@(nome1,date1@(D d1 m1 a1)) inf2@((nome2,date2@((D d2 m2 a2))):t)
  | teste = inf1:inf2
  | otherwise = (nome2,date2):insertData inf1 t 
    where teste = anterior date1 date2
--3)
data Movimento = Credito Float --Credito é um construtor, tal como todos os outros.
               | Debito Float 
    deriving Show

data Data = D Int Int Int --Dia Mes Ano 
    deriving Show

data Extracto = Ext Float [(Data,String,Movimento)]
    deriving Show

e :: Extracto
e = Ext 154.5 [(D 2 10 2016, "MB", Debito 1000),
              (D 3 10 2016, "sal", Credito 200),
              (D 3 10 2016, "VV", Debito 3.4)] :: Extracto
--a) 
extValor' :: Extracto -> Float -> [Movimento]
extValor' (Ext v1 [])  _ = [] 
extValor' (Ext v1 ((_,_,m):t)) v | valor m > v = m:extValor' (Ext v1 t) v
                                 | otherwise = extValor' (Ext v1 t) v
-- extValor' (Ext t mvs) = extValor' mvs 

valor :: Movimento -> Float --esta função tem como objetivo "eliminar" o constructor Debito ou Credito.
valor (Debito x) = x 
valor (Credito x) = x

--b)
filtro :: Extracto -> [String] -> [(Data,Movimento)]
filtro (Ext t mvs) ldm = -- ldm = lista dos movimentos
  map (\(dt,ds,mo) -> (dt,mo)) (filter (\(d,ld,m) -> ld `elem` ldm) mvs) --mo = movimentos

--c)
creDeb :: Extracto -> (Float,Float)
creDeb (Ext vi []) = (0,0)
creDeb (Ext vi ((date,e,(Credito v)):t)) = 
  (v+c,d)
   where (c,d) = creDeb (Ext vi t)
creDeb (Ext vi ((date,e,(Debito v)):t)) = 
  (c,v+d)
   where (c,d) = creDeb (Ext vi t)

--e)
saldo :: Extracto -> Float
saldo est@(Ext vi ((date,e,mvs):t)) = (vi + d) - c
  where (c,d) = creDeb est