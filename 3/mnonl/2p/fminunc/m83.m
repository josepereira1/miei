function f = m83(x)
    f = x(1)+x(2)+x(3)+(2401/x(1)*x(2)*x(3)); %   falta qq coisa aqui
end

%   min z = x1 + x2 + x3 + x4
%   sa:
%   x1*x2*x3*x4 = A = 2401

%   x1*x2*x3*x4 = 2401 <=> x4 = 2401/(x1*x2*x3)

%   então, o problema sem restrições fica:

%   min z = x1 + x2 + x3 + 2401/(x1*x2*x3)