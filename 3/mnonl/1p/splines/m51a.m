%   metemos todos os valores da tabela qd ele não considera as derivadas
%   nos extremos, caso ele peça as derivadas, temos que remover o segundo e
%   penúltimo.
%   VERIFICAR SE TEMOS UMA FUNÇÃO !!!
x = 5:0.1:6;       
f = [0.0639 0.08 0.0988 0.1203 0.1442 0.1714 0.2010 0.2331 0.2673 0.3036 0.3414];

%s = spline(x,f,5.45); 

%   ATENÇÃO VERIFICAR SE É FUNÇÃO E REMOVER O SEGUNDO E PENÚLTIMO!!!

s = spline(x,f);
%   vamos à linha 5, pq fizemos 5 saltos desde o 5.0 até ao 5.5 onde se 
%   encontrava o valor que procuravamos, que era o 5.45
s.coefs


%   o segmento da spline é os valores da linha dos coefs*(x-x0)^grau 
%   IMPORTANTE: o x0 é o primeiro valor do intrevalo onde está o
%   valor aproximado, então fica:
%   -0.3521(x-5.4)^3 + 0.2004(x-5.4)^2 + 0.2555(x-5.4) + 0.1442

