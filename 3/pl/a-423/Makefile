calc: compilador.fl compilador.y
	flex compilador.fl
	yacc compilador.y
	cc -o compilador y.tab.c -ly -lm

clean:
	rm -f y.tab.c lex.yy.c calc




