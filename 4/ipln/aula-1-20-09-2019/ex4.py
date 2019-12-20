#!/usr/bin/env python3

import re

def limpa1(text):
	# \1 para apanhar um caracter
	# r antes significa para ignorar os espaços, ou seja, não são caracteres
	text = re.sub("([a-zA-Z]),",r"\1 ,", text)
	return text

def limpa2(text):
	text = text.lower();
	# \1 para apanhar um caracter
	# r antes significa para ignorar os espaços, ou seja, não são caracteres
	text = re.sub("([a-z]),",r"\1 ,", text)
	return text

def limpa3(text):
	text = text.lower();
	text = re.sub(r"áàâã", "a", text)
	# \1 para apanhar um caracter
	# r antes significa para ignorar os espaços, ou seja, não são caracteres
	text = re.sub("([a-z]),",r"\1 ,", text)
	return text


text = "Ola, tudo bem?"
print(limpa2(text))