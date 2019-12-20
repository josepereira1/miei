clear all
i = 1:1:4;
x(i) = 1;
[x,f,exitflag,output] = fminsearch('m2',x)