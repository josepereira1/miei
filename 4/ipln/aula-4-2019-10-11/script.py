#!/usr/bin/python3

# exercício: isolar nomes de textos

import re
import subprocess;
import sys;
from getopt import getopt;
import fileinput;

texto = ""

# \W filtra espaços, vírgulas, pontos, ...

# [A-Z]\w+ estamos a capturar palavras que comecem por maiúscula e que tenham pelo menos duas letras

# (?<=\W) é um look behind, verifica se existe, ou seja, neste caso verifica que existe a expressão regular \W, que representa tudo que não é letras
# (?<=\W)[A-Z]\w+ neste caso, o <<look behind>> está a garantir que não há uma letra antes da letra maiúscula


pM = r"(?<=\W)[A-Z]\w+"	# palavas maiúsculas
nP = pM + r"(?: (?:[A-Z]\w+|da|do|de))*" # nomes próprios
fimfrase = r"[.?!:]\s*"


# lê-se o texto do ficheiro, e linha a linha vamos acrescentar a uma variável texto
for line in fileinput.input():
    texto += line

# divide-se o texto em frases
frases = re.split(fimfrase,texto)

# para cada frase vamos procurar por nomes próprios, utilizando a expressão regular definida acima
entidades = []
for frase in frases:
    entidades += re.findall(nP,frase)

print(entidades)

    