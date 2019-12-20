function f = m33(x)
    f = [sin((x(1)+x(2))/2)-2*x(1)
        cos((x(1)-x(2))/2)-2*x(2)];
end

%   run this command on Command Window: 
%   >> [x,f,exitflag,output] = fsolve('m33',[0,0])