x = [0.0 0.2 0.4 0.6 0.8 1.0 1.2 1.4];
f = [1.000 1.221 1.492 1.882 2.226 2.718 3.320 4.056];
%   a)
p3 = polyfit(x,f,3);

%   p3(x) = x^3*0.4050 + x^2*0.1559 + x*1.1740 + 0.9909

%   b)
valor = polyval(p3,0.5);

%   c)
[p,residuo] = polyfit(x,f,3);

%   normr: 0.0524 logo o resíduo é normr^2

residuo = 0.0524 ^ 2    %   residuo = 0.0027