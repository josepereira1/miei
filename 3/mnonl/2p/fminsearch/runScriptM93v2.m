clear all
%   options = optimset('TolX',1e-20);
%   options = optimset('TolX',1e-20,'MaxFunEvals',10000)
   options = optimset('TolX',1e-20,'MaxFunEvals',10000,'MaxIter', 10000);

n = 5;
i=1:n;
x1 = i-(n/2+0.5);
[x,f,e,o] = fminsearch('m93',x1)

%   exitflag > 0 converge
%   exitflag < 0 não converge
%   exitflag == 0 o máximo do MATLAB 5*n,
%   ou seja, 1000, e neste caso ele ultrapassa os 1000 e a exitflag = 0,
%   para avisar isso, e ele sugere uma resolução do problema increase MaxFunEvals option.

%   para resolver este problema:
%   options = optimset('TolX',1e-20,'MaxFunEvals',10000);


%   Agr está a queixar-se do máximo das iterações, pq exitflag = 0 e eles
%   sugerem o aumento do MAX ITERAÇÕES, então:
%   options = optimset('TolX',1e-20,'MaxFunEvals',10000,'MaxIter', 10000);

