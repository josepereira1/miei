f = @(x) 4./(1+x.^2);
%   DEVEMOS METER PONTO ANTES DE DIVISÕES E POTÊNCIAS (^n)

I = integral(f,0,1, 'AbsTol',1e-20,'RelTol',1e-20) %   a função integral é usada qd temos funções;
%   o 0 e 1 indica os limites;
%   AbsTol = tolerância absoluta (erro absoluto)
%   RelTol = tolerância relativa (erro relativo)
%   se não a indicarmos o matlab usa a predefinição

%   o ponto indica que vai fazer isto para cada ponto do vetor