
module Main where
type Hora = (Int,Int)
type Etapa = (Hora,Hora)
type Viagem = [Etapa]

validaHora :: Hora -> Bool
validaHora (a,b) | a > 0 && a < 24 && b >= 0 && b < 60 = True 
				 | otherwise = False
--4)
--a)
validarEtapa :: Etapa -> Bool
validarEtapa ((x1,y1),(x2,y2)) | v1 && v2 && x2 > x1 = True
							   | v1 && v2 && x2 == x1 && y2 > y1 = True
							   | otherwise = False
							   where v1 = validaHora (x1,y1)
						     		 v2 = validaHora (x2,y2)

viagem1 = [((9,30),(9,25)),((11,20),(12,45)),((13,30),(14,45))]

--b)
validarViagem :: Viagem -> Bool
validarViagem [] = True
validarViagem (h:t) | p1 = validarViagem t
                    | otherwise = False
                        where p1 = validarEtapa h