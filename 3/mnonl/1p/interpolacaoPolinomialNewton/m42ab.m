x = [1.00 1.20 1.50 1.60];
f = [0.8415 0.9320 0.9975 0.9996];

p3 = polyfit(x,f,3)

resultado = polyval(p3,1.57)