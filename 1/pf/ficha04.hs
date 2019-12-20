type Ponto = (Float,Float)   --(abcissa,ordenada)
type Rectangulo = (Ponto, Float, Float)  --(canto sup.esq., larg,alt)
type Triangulo = (Ponto, Ponto, Ponto)
type Poligonal = [Ponto]

--1
--a)
distancia :: Ponto -> Ponto -> Float 
distancia (a,b) (c,d) = sqrt (((c-a)^2) + ((b-d)^2))

comprimento :: Poligonal -> Float
comprimento (p:[]) = 0
comprimento (p1:p2:t) = distancia p1 p2 + comprimento (p2:t)

--b)
tri2pol :: Triangulo -> Poligonal
tri2pol (p1,p2,p3) = [p1,p2,p3,p1]

--c)
rec2pol :: Rectangulo -> Poligonal
rec2pol (p1,l,h) = [p1,p2,p3,p4,p1] 
                    where (x,y) = p1
                          p2 =(x+l,y)
                          p3 = (x+l,y-h)
                          p4 = (x,y-h)

--d)
fechada :: Poligonal -> Bool
--isto está bem só que é um "mau cheiro!"
fechada [] = False
fechada (h:t) | h == last t = True 
              | otherwise = False 

fechada' :: Poligonal -> Bool
fechada' (h:t) = h == last t
--??
fechada'' (h:t) | length (h:t) > 3 = h == last (h:t)
                | otherwise = False

--e)
triangula  :: Poligonal -> [Triangulo]
triangula [p1,p2,p3,_] = [(p1,p2,p3)] 
triangula (p:p2:p3:t) = (p,p2,p3) : (triangula (p:p3:t))                      

--f)
areaTriangulo (x,y,z)
    = let a = distancia x y
          b = distancia y z
          c = distancia z x 
          s = (a+b+c) / 2     --semi-perimetro
      in --formula de Heron
        sqrt (s*(s-a)*(s-b)*(s-c))

areaPoligonalFechada :: Poligonal -> Float
areaPoligonalFechada p = let lt = triangula p   -- lt = lista de triângulos 
                         in areaTriangulos lt

                    where areaTriangulos [] = 0
                          areaTriangulos (h:t) = areaTriangulo h + areaTriangulos t  
