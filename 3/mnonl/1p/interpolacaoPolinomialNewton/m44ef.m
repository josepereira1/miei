t = [0 1 4 7 8 10 14];
h = [2.1 2.0 1.8 1.5 1.4 1.1 0];

p6 = polyfit(t,h,6)

resultado = polyval(p6,5)