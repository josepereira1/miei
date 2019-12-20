clear all
n = 5;
i = 1:2:n;
x1(i) = 2;   %   x(1) = {2 se i = 1,3,5,... e 1 se i = 2,4,6,...
i = 2:2:n;
x1(i) = 1;
%t = pi/6;
%m  = 10;
[x,f,exitflag,output] = fminunc('m84',x1)