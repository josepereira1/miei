n = 5;
options = optimset('MaxFunEvals',5000);
i = 1:n;
x1 = i -(n/2+0.5);
[x,f,e,o] = fminsearch('m94', x1, options)

%   TEMOS QUE ESTAR ATENTOS AO VALOR DA EXITFLAG PARA SABER SE ISTO ESTÁ A
%   FAZER BEM, E CASO A EXITFLAG = 0, TEMOS QUE MUDAR OS VALORES. 

%   NESTE CASO METEMOS OS MAXFUNEVALS a 5000, 