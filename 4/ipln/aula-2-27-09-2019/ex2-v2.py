#!/usr/bin/env python3

import subprocess as sp
import sys
from getopt import getopt
opts, resto = getopt(sys.argv[1:],"i:f:")
dop = dict(opts)
# cria uma dicionário
# print(dop)

# output = sp.getoutput(f"head -{50+1} exemplo.txt | tail -11")
# o 'f' antes da string serve para avisar que vai ter uma expressão matemática/computacional (50+1)
# no meio da string, caso não se meta o 'f' antes da string, ele 
# iria imprimir {50+1} como caracteres

# '1:' quer dizer que queremos os elementos apenas da posição 1 até ao fim
# o segundo argumento é as letras que nos interessam como argumentos (flags)
# os dois pontos a seguir à letra "i:" significa que a seguir à letra vem um valor/argumeto

# python3 exe.py -i 10 -f 20
#                |---------|
#                   getopt

#python3 ex2-v2.py -i 10 -f 20
#[('-i', '10'), ('-f', '20')]

# com a adição do dop (Dicionário) ficamos com um dicionário
# python3 ex2-v2.py -i 10 -f 20
# {'-i': '10', '-f': '20'}
# [('-i', '10'), ('-f', '20')]

# como não queremos que isto seja fixo, vamos buscar os valores de -f e -i ao dop
# no entanto se não forem inseridos valores, ele utiliza como padrão o 20 e 10 respetivamente
f = int(dop.get('-f',20))
i = int(dop.get('-i',10))

# resto[0] é onde se encontra o nome do ficheiro
output = sp.getoutput(f"head -{f} {resto[0]} | tail -{f - i + 1}")


print(output)