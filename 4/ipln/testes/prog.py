#!/usr/bin/env python3
import re
import requests as req

x = "Oláa Olá tudou-o cat bem con4tiio contigo?"

r1 = "(u.*?i)"
r2 = "(?:[A-Z]\w+)a"

# res = re.findall(r2, x)

# res = re.sub(r"([A-Z])", f"\1" + "1", x)

# print(res)

# ------------------------------------------------------

# res = req.get("https://www.jonsay.co.uk/dictionary.php?langa=Portuguese&amp;langb=German&amp;category=flowers")
# print(res.text)

# ------------------------------------------------------

# meses="janeiro fevereiro março abril maio".split()
# estacoes="primavera verão outono inverno".split()

# print(meses)

# texto =  "|".join(meses+estacoes)
# print(texto)

# ------------------------------------------------------

res = re.findall(r"\bcat\b", x)

print(res)