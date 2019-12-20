function [f,d] = m32(x)
f = cos(x)-cos(3.1*x);
    if(nargout > 1)
        d=-sin(x)+3.1*sin(3.1*x);
    end
end

%   run this commands on Command Window:  
%   >> options = optimset('Jacobian','on');
%   >> [x,f,exitflag,output] = fsolve('m32',-1,options)

%   derivadas (como calcular):
%   >> syms x
%   >> diff(x^2)
%   >> ans=2*x


%   (exp(x))' = x'*exp(x)
%   (sin(x))' = (x)'*cos(x)
%   (cos(x))' = (x)'*(-sin(x))

%   >>syms x y z
%   >>jacobian([x, y^2 + y, exp(z) -1],[x,y,z])

%   >>syms f(x)
%   >>f(x) = cos(x) - cos(3.1*x);
%   >>diff(f,x) 