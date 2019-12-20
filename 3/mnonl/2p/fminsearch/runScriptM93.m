n = 2;
i = 1:n;
x1(i) = i-(n/2+0.5)
%[x,f,e,o] = fminsearch('m93',x1)