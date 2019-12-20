
-- tratamento de chamadas de telemóvel
f :: String -> [String] -> [String]
f c l =  take 10 (c:(filter (/=c) l)) 
