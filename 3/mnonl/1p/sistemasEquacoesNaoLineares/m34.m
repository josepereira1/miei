function [f,J] = m34(x)
f = [x(1)
    (x(2)^2)+x(2)
    exp(x(3))-1];
    if nargout>1
        J = [1 0 0;0 2*x(2)+1 0;0 0 exp(x(3))]; 
    end
end

%   sistema: 
%   x1 = 0
%   x2^2 + x2 = 0
%   exp(x3) -1 = 0

%   run this commands on Command Window:  
%   >> options = optimset('Jacobian','on');
%   >> [x,f,exitflag,output] = fsolve('m34',[1,1,-1],options)
    
%   >>syms x y z
%   >>jacobian([x, y^2 + y, exp(z) -1],[x,y,z])

%   >>syms f(x)
%   >>f(x) = cos(x) - cos(3.1*x);
%   >>diff(f,x) 


        