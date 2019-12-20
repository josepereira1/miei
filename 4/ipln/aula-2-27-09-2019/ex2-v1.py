#!/usr/bin/env python3

import subprocess as sp

# help(subprocess) mostra os comandos/funções possíveis deste import

output = sp.getoutput("head -50 exemplo.txt | tail -11")

print(output)