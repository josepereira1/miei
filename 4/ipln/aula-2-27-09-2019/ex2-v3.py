#!/usr/bin/env python3

import subprocess as sp
import sys
import fileinput
from getopt import getopt
opts, resto = getopt(sys.argv[1:],"i:f:")
dop = dict(opts)

f = int(dop.get('-f',20))
i = int(dop.get('-i',10))

# agora faz-se o mesmo exercício, sem utilizar systems calls, apenas python


# temos que colocar o resto como argumento da função input, mesmo que sem argumentos
# não seja necessário, pq quando tem argumentos, ele dá erro

# a razão pela qual fez-se o len(resto) >= 2, foi para que ele apenas
# imprima o nome do ficheiro se houver 2 ou mais ficheiros

for line in fileinput.input(resto):
	if fileinput.isfirstline() and len(resto) >= 2 : 
		print(f"== {fileinput.filename()}")
	if i <= fileinput.filelineno() <= f:
		print(line.rstrip())
	if fileinput.filelineno() > f: 
		fileinput.nextfile()

# o break é para finalizar o processo, para melhorar a eficiência
# time seq 10000000 | ./ex2-v3.py

# lineno = line number

# cat exemplo.txt | python3 ex2-v3.py
# podemos executar desta forma

