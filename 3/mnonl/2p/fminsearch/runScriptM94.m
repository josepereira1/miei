n = 2;
%   options = optimset('MaxFunEvals',5000); %  neste caso não é preciso
%   isto options pq o funcCount não ultrapassa o 1000
i = 1:n;
x1 = i -(n/2+0.5);
[x,f,e,o] = fminsearch('m94', x1)

%   TEMOS QUE ESTAR ATENTOS AO VALOR DA EXITFLAG PARA SABER SE ISTO ESTÁ A
%   FAZER BEM, E CASO A EXITFLAG = 0, TEMOS QUE MUDAR OS VALORES. 

%   NESTE CASO METEMOS OS MAXFUNEVALS a 5000, 