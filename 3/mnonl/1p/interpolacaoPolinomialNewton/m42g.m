x = [0.00 0.30 0.50 0.70 0.90 1.00 1.20 1.50 1.60 1.75 2.00 2.10];
f = [0.0000 0.2955 0.4794 0.6442 0.7833 0.8415 0.9320 0.9975 0.9996 0.9840 0.9093 0.8632];

p11 = polyfit(x,f,11);

xx = 0.00:0.001:2.10;       %   listar todos os pontos possíveis;
ff = polyval(p11,xx);       %   descobrir os valores de f para cada valor de x;

plot(x,f,'or',xx,ff,'k');   %   desenhar o gráfico, onde 'or' indica que são bolas vermelhas(RED);
