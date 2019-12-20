function f = m91(x)
u = [abs(x(1)) abs(x(2)-1)];
f = max(u);
end
%   [x,f,e,o] = fminsearch('m91',[1,1])

%   isto é um curiosidade que pode dar jeito no teste: pq a professora pode
%   perguntar o que é que o algoritmo fez na iteração 10, portanto temos
%   que fazer o seguinte:
%   options = optimset('Display','iter'); -- isto serve para ele fazer o display por iteração, para conseguirmos ver os vértices que ele uso etc ..
%   [x,f,e,o] = fminsearch('m91',[1,1],options)