t = [0 1 4 7 8 10];
h = [2.1 2.0 1.8 1.5 1.4 1.1];

p5 = polyfit(t,h, 5)

resultado = polyval(p5,5)