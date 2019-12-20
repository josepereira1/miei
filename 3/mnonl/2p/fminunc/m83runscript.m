clear all
x1=[6 7 5]; %   valores iniciais
op = optimset('TolX',0.0001,'TolFun',0.0001, 'HessUpdate','DFP');
[x,f,exitflag,output] = fminunc('m83',x1,op)
x4 = 2401/(x(1)*x(2)*x(3))  %   cálculo do x4 apartir dos valores de x

%   NÃO ESQUECER DE CALCULAR AS VARIÁVEIS QUE NÃO APARECEM NA FUNçÃO
%   OBJETIVO COMO AQUI O X4