function f = m2(x)
    i = 1:1:21;
    t(i) = 0.25 + 0.75*(i-1)/20;
    u(i) = x(4) - ((x(1)*t(i).^2) + (x(2)*t(i)) +x(3)).^2 - sqrt(t(i));
    f = max(u.^2) - max(abs(u));
end 