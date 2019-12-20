function f = m84(x)
    t = pi/6;
    n = length(x);  %   para saber o valor de N para o somatório;
    i = 1:2:n-1;    %   pq ele vai só até N-1 pq é < N;
    y(i) = x(i)*cos(t)-x(i+1)*sin(t);    %   t = teta
    i = 2:2:n-1;
    y(i) = x(i)*sin(t)+x(i+1)*cos(t);
    i = n;
    y(i) = x(i);
    i = 1:n;
    m = 10;
    f = -sum(sin(y).*(sin(i.*y.^2/pi)).^(2*m));
end

    %   não precisamos colocar o indice i;
    %   o ponto metemos antes dos vetores, potencias, divisões,
    %   multiplicações