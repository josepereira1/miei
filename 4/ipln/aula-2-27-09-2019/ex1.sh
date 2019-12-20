yes | nl | head -1000
# o comando yes, escreve uma quantidade de linhas com o caracter 'y'
# como a bash é lazy, então quando ela processar o texto, ao ver o head -1000, o comando yes apenas vai gerar 1000 linhas
seq 1000

# 1
head -50 exemplo.txt  | tail -11
