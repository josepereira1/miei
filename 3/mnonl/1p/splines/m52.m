x = [1 1.5 2 3 3.5];          %   AQUI NÃO TENHO QUE REMOVER O SEGUNDO E ÚLTIMO!!!
f = [0 0.4055 0.6931 1.0986 1.2528];

d0 = 1;
dn = 1/3.5; %    AQUI COMO TEMOS UMA FUNÇÃO ln(), temos que calcular
            %    a derivada dela e usar ela no d0 e dn
           
s = spline(x,[d0 f dn],2.5)

%s.coefs

    %   o segmento da spline é os valores da linha dos coefs*(x-x0)^grau 
    %   IMPORTANTE: o x0 é o primeiro valor do intrevalo onde está o
    %   valor aproximado
    
    %   0.0133(x-2)^3 +  -0.0982(x-2)^2 + 0.4905(x-2)^1 + 0.6931