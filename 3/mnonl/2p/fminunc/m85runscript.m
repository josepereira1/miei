clear all
n = 10;
op = optimset('HessUpdate','DFP');
x1 = ones(1,n); %   facilitamos ao usar o ones, que faz um vetor de uns
[x,f,exitflag,output] = fminunc('m85',x1,op)