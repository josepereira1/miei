dobros l = map (*2) l

soPos l = filter (>0) l 

tresUlt [] = []
tresUlt [x1,x2,x3] = [x1,x2,x3]
tresUlt [x1,x2] = [x1,x2]
tresUlt [x1] = [x1]
tresUlt (h:t) = tresUlt t