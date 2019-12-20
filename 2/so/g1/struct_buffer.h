typedef struct buffer_t{
	
	void *buf;	//	buffer com 10KB, que vai guardar todas as linhas lidas pelo read de uma só vez;
	int fildes;	//	file descriptor;
	size_t buffer_size;	//	size do buffer principal;
	void *line;	//	este ponteiro vai apontar para a linha que eu vou ler, a linha que o readln vai retornar;
	int last_line;
} Buffer_t, **p_buffer_t;


