doubleMe :: Float -> Float
doubleMe n = n+n

doubleUs :: Float -> Float -> Float
doubleUs n m = n*2 + m*2
--doubleUs x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x<100 then x*2 else x

boomBangs :: [Int] -> [[Char]]
boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

--let nouns = ["hobo", "frog", "pope"]
--let adjectives = ["lazy", "grouchy", "scheming"]

--imprime nouns adjectives = [ adjective++" "++noun | adjective <- adjectives, noun <- nouns]

length' xs = sum[1 | _<-xs]

--init'(x:xs) = [x | x<-(x:xs), ]

triangulos_retangulos = [ (a,b,c) | a <- [1..10], b <- [1..10], c <- [1..10], a^2 + b^2 == c^2]

removeNOnUppercase :: [Char] -> [Char]
removeNOnUppercase st = [ c | c <- st , elem c ['A'..'Z']]

lucky :: (Integral a) => a -> String 
lucky 7 = "LUCKY NUMBER SEVEN!"
lucky x = "Sorry, you're out luck, pal!"

sayMe :: (Integral a) => a -> String
sayMe 1 = "One!"
sayMe 2 = "Two!"
sayMe 3 = "Three!"
sayMe 4 = "Four!"
sayMe 5 = "Five!"
sayMe x = "Not between 1 and 5!"