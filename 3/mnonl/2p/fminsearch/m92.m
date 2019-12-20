function f = m92(x)
u=[x(1)^2+x(2)^4 (2-x(1))^2+2+(2-x(2))^2 2*exp(-x(1)+x(2))];
f=max(u);
end

%   [x,f,e,o] = fminsearch('m92',[1 -0.1]) -> 123 funcCount
%   [x,f,e,o] = fminsearch('m92',[2,2])    -> 103 funcCount 
%   [x,f,e,o] = fminsearch('m92',[-10,-10])-> 126 funcCount

%   peso relacional dado pelo nº de cálculos feitos, sendo o que tem menos,
%   ou seja, [2,2] o melhor.