--2)
type TabTemp = [(Data,Temp,Temp)]
type Data = (Int,Int,Int)
type Temp = Float
--a)
medias :: TabTemp -> [(Data,Temp)]
medias [] = []
medias ((d,t1,t2):t) = (d,((t1+t2)/2)):medias t
--b)
decrescente :: TabTemp -> Bool
decrescente [] = True
decrescente (h1:h2:t) | a1 > a2 = decrescente t
                      | a1 == a2 && m1 > m2 = decrescente t
                      | a1 == a2 && m1 == m2 && d1 >= d2 = decrescente t
                      | otherwise = False
                        where ((a1,m1,d1),t11,t12) = h1 
                              ((a2,m2,d2),t21,t22) = h2 