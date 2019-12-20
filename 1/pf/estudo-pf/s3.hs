module Study3 where

import System.Random
advinha :: IO()
advinha = do putStrLn "Qual é o número (0,9) que escolhi?"
		  	 x <- randomRIO (0,9)
		  	 n <- joga x 1
		  	 putStrLn ("usou "++(show n)++" tentativas para acertar.");

joga :: Int -> Int -> IO Int
joga x n = do s <- getLine 
			  y <- tryIOError (readIO s)
			  case y of
			  Left _ -> putStrLn "Error ..." >> x n
			  Right r -> if x == r 
			  				then
			  				return n 
			  				else
			  				if r < x 
			  					then
			  					putStrLn "É baixo ... tente de novo!" >> joga x (n+1)
			  					else
			  					do putStrLn "É alto ... tente de novo"
			  					joga x (n+1) 