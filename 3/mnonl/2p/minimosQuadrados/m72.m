x = [1.2 1.75 1.1 2.0 0.5 0.8 1.0 1.5];
f = [16 18 16 19 10 11 14 16];

%   a)  a reta que melhor aproxima os dados da tabela?
p1 = polyfit(x,f,1)

%   p6.0011*x + 7.6112

%   b)  qual o resíduo do erro obtido?
[p,r] = polyfit(x,f,1);

residuo = 2.8087^2

%   c)  qual o valor de p1(0.6)?
valor = polyval(p1,1.6)
