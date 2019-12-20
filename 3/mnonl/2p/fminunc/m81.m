function f = m81(x)
    f = 0.25*x(1)^4 -0.5*x(1)^2 + 0.1*x(1) + 0.5*x(2)^2;
end

%   [x,f,exitflag,output] = fminunc('m81',[-1,0.5]) --  diferenciável
%   [x,f,exitflag,output] = fminsearch('m81',[-1,0.5])  --  não diferenciável
%   fminunc -> algoritmo 'quasi-newton'
%   fminsearch -> algoritmo 'Nelder-Mead simplex direct search'