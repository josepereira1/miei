x = [-1.00 -0.95 -0.85 -0.80 0.20 0.50 0.90];
f = [-1.00 -0.05 0.90 1.00 0.90 0.50 -0.30];

[p,S1] = polyfit(x,f,3)

residuoPolinomio = 0.5473^2

%   [!!IMPORTANTE!!]: caso o problema não diga valores iniciais para os
%   coeficientes, assume-se um vetor com dimnesão igual ao número de coeficientes neste caso
%   3, (c1 c2 c3), com valores a 1

%   IMPORTANTE!!!!! NAS DIVISÕES, POTÊNCIAS NÃO ESQUECER DO PONTO ANTES!
%   COMO SE DETERMINA O RESÍDUO:
%   o resíduo é o valor que está na struct, no campo normr ao quadrado,
%   se normr = 0.5473, o resíduo é 0.5473^2 = 0.29995.

[coefsM,S2] = lsqcurvefit('m73M',[1,1,1],x,f)    %   valor do resíduo, fica em S2

[coefsN,S3] = lsqcurvefit('m73N',[1,1],x,f)

[coefsO,S4] = lsqcurvefit('m73O',[1,1,1],x,f)

[coefsQ,S5] = lsqcurvefit('m73Q',[1,1],x,f)


%   como o resíduo do polinómio é mais baixo ele é o melhor, no sentido dos
%   métodos quadrados.