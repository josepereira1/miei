%Normal dar warning
%a)
x = [5.3 5.4 5.5]           %   apenas incluímos os 3 pontos(grau 2) mais próximos de 5.44
f = [0.1203 0.1442 0.1714]  %   e os respetivos valores de f

%   determina o polinómio interpolador de grau 2
p2 = polyfit(x,f,2)

%b)
resultado = polyval(p2,5.44)    %   retorna o resultado de f(5,44)

%   o polinómio é 0.1650*x^2  -1.5265*x    3.5759
