/*********************************************
 * OPL 12.6.2.0 Model
 * Author: falvelos
 * Creation Date: 5 de Abr de 2017 at 12:12:54
 *********************************************/

int d[1..9][1..9]=...;

dvar boolean x[1..9][1..9][1..9];

minimize x[1][1][1];

subject to {

	forall(i in 1..9, j in 1..9, k in 1..9) {
		if (d[i][j]==k) x[i][j][k]==1;
	}
	
// Todas as células têm um e só um algarismo
  forall (i in 1..9, j in 1..9) sum (k in 1..9) x[i][j][k] == 1;
 
  // Cada algarismo aparece uma e só uma vez em cada linha
  forall (i in 1..9, k in 1..9) sum (j in 1..9) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez em cada coluna
  forall (j in 1..9, k in 1..9) sum (i in 1..9) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco esquerdo cima
  forall (k in 1..9) sum (i in 1..3, j in 1..3) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco meio cima
  forall (k in 1..9) sum (i in 4..6, j in 1..3)  x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco direito cima
  forall (k in 1..9) sum (i in 7..9, j in 1..3) x[i][j][k] == 1;

  // Cada algarismo aparece uma e só uma vez no bloco esquerdo meio
  forall (k in 1..9) sum (i in 1..3, j in 4..6) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco meio meio
  forall (k in 1..9) sum (i in 4..6, j in 4..6) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco direito meio
  forall (k in 1..9) sum (i in 7..9, j in 4..6) x[i][j][k] == 1;

  // Cada algarismo aparece uma e só uma vez no bloco esquerdo meio
  forall (k in 1..9) sum (i in 1..3, j in 7..9) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco meio meio
  forall (k in 1..9) sum (i in 4..6, j in 7..9) x[i][j][k] == 1;
  
  // Cada algarismo aparece uma e só uma vez no bloco direito meio
  forall (k in 1..9) sum (i in 7..9, j in 7..9) x[i][j][k] == 1;
  
  
}

int y[1..9][1..9];

execute {

	for (var i=1; i<10;i++) {
		for (var j=1; j<10;j++) {
			for (var k=1; k<10;k++) {
				if (x[i][j][k]==1) {
					y[i][j]=k;
				 }								
			}					
		}	
	} 
}