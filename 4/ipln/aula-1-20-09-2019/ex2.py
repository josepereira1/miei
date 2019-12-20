#!/usr/bin/env python3

def pares1(l):
	for n in l:
		if not n % 2:
			print(n)

def pares2(l):
	# o primeiro x é parar escrever na lista
	res = [x for x in l if not x % 2]
	print(res)

def pares3(l):
	# o filter aplica uma função a cada elemento da lista
	res = list(filter(lambda x : not x % 2, l))
	print(res)


pares3([1,2,3,4,5,6,7,8])