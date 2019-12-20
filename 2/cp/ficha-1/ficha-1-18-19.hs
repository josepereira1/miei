data Maybe a = Nothing | Just a

catMaybes :: [Maybe a] -> [a]
catMaybes [] = []
catMaybes (Nothing:t) = catMaybes t
catMaybes ((Just a):t) = a:catMaybe t
