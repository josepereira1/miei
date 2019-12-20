getnp: getnp.fl
	flex getnp.fl
	cc -o getnp lex.yy.c
	
install: getnp
	cp getnp /usr/local/bin/

clean:
	rm -f lex.yy.c

uninstall:
	rm -f /usr/local/bin/getnp
