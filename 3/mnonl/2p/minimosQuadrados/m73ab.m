x = [-1.00 -0.95 -0.85 -0.80 0.20 0.50 0.90];
f = [-1.00 -0.05 0.90 1.00 0.90 0.50 -0.30];


%   IMPORTANTE!!!!! NAS DIVISÕES, POTÊNCIAS NÃO ESQUECER DO PONTO ANTES!

%   a) um polinómio de grau 3 (p3(x))

p3 = polyfit(x,f,3) %   x,f,grau
%   [p,S1] = polyfit(x,f,3); ====> onde S1 é o resíduo

%   output:
%   p3 = 3.2764   -2.2107   -2.9271    1.8138

%   logo:
%   p3(x) = 3.2764*x^3 - 2.2107*x^2 - 2.9271*x + 1.8138

%   b)
valor1 = polyval(p3,0.6)


%   a) M(x) = c1 + c2 cos(x) + c3 sin(x)

%   [!!IMPORTANTE!!]: caso o problema não diga valores iniciais para os
%   coeficientes, assume-se um vetor com dimnesão igual ao número de coeficientes neste caso
%   3, (c1 c2 c3), com valores a 1

coeficientesDeM = lsqcurvefit('m73M',[1 1 1],x,f)
%   [m,S2] = lsqcurvefit('m73d',[1 1 1],x,f); ====> onde S2 é o resíduo  

%   c1 + c2 cos(x) + c3 sin(x), então:
%   M(x) = -2.6842 + 4.0344*cos(x) -0.4432*sin(x);

%   b)
valor2 = m73M(coeficientesDeM,0.6)

%   IMPORTANTE:
%   para calcular o valor de M(0.6), faz-se no terminal 
%   >> m73d(c1,0.6)


%   a)  N(x) = c1*e^x + c2*(1/x)
coeficientesDeN = lsqcurvefit('m73N',[1 1],x,f)

%   b)
valor3 = m73N(coeficientesDeN, 0.6)

%   a)  O(x) = c1 + c2*x + (c3/x)
coeficientesDeO = lsqcurvefit('m73O',[1 1 1],x,f)

%   b)
valor4 = m73O(coeficientesDeO, 0.6)

%   a)  Q(x) = c(1)*x + c(2)*exp(x)
coeficientesDeQ = lsqcurvefit('m73Q',[1 1],x,f)

%   b)
valor5 = m73Q(coeficientesDeQ,0.6)











