#!/usr/bin/env python3

def inverter1(f):
	linhas = open(f).readlines()
	for l in linhas.reverse():
		print(l)


def inverter2(f):
	linhas = open(f).readlines()
	for l in linhas[::-1]:
		print(l.rstrip())


# reversed() faz apenas o print da lista invertida
# reverse() reverte mesmo a lista

inverter2("file.txt")