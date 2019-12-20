clear all
w = 500;
[x,f,e,o] = fminsearch('m95',[-1 5],[],w)

%   Qual tem o processo iterativo mais eficiente?
%   w = 500 -> 188 cálculos de função
%   w = 1000 -> 190 cálculos de função
%   w = 1500 -> 192 cálculos de função

