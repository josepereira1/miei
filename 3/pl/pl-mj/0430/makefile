mj: mj.fl mj.y 
	flex mj.fl
	yacc -v mj.y
	cc -o mj y.tab.c 

test: mj exemplo.mj
	./mj < exemplo.mj > resultado.vm
	vms resultado.vm
	echo "\n"
