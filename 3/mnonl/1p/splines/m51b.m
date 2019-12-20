%   TABELA INICIAL ANTES DE REMOVER OS ELEMENTOS:
%   x = [5 5.1 5.2 5.3 5.4 5.5 5.6 5.7 5.8 5.9 6];
%   f = [0.0639 0.0800 0.0988 0.1203 0.1442 0.1714 0.2010 0.2331 0.2673 0.3036 0.3414];

x = [5.0 5.2 5.3 5.4 5.5 5.6 5.7 5.8 6.0];   %   removi o segundo e o penúltimo
f = [0.0639 0.0988 0.1203 0.1442 0.1714 0.2010 0.2331 0.2673 0.3414];   %   removi o segundo e o penúltimo

d0 = (0.0639-0.0800)/(5-5.1);       %   dd0 (usa-se tb os valores que sairam da tabela, que neste caso é o 0.0800
dn = (0.3036 - 0.3414)/(5.9-6);     %   ddn

s = spline(x,[d0 f dn], 5.45)

%   s.coefs

    %   o segmento da spline é os valores da linha dos coefs*(x-x0)^grau 
    %   IMPORTANTE: o x0 é o primeiro valor do intrevalo onde está o
    %   valor aproximado