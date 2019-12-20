function f = m96(x)
i = 1:21;
t = 0.25+0.75*(i-1)/20;
u=x(4)-(x(1)*t.^2+x(2)*t+x(3)).^2-sqrt(t);
f = max(abs(u));
end

%   [x,f,e,o] = fminsearch('m96', ones(1,4))