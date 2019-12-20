/*********************************************
 * OPL 12.6.2.0 Model
 * Author: falvelos
 * Creation Date: 6 de Abr de 2017 at 12:05:11
 *********************************************/

 int n=...;
 int prefs[1..n][1..n]=...;
 
 dvar boolean x[1..n][1..n];

minimize sum (i in 1..n, j in 1..n) prefs[i][j]*x[i][j];

subject to {

	forall (i in 1..n) sum (j in 1..n) x[i][j]==1;
	forall (j in 1..n) sum (i in 1..n) x[i][j]==1;

}
 
 
// int n=...;
// int prefs[1..n][1..n]=...;
// 
// dvar boolean x[1..n][1..n];
// dvar int u;
//
//minimize u;
//
//subject to {
//
//	forall (i in 1..n) sum (j in 1..n) x[i][j]==1;
//	forall (j in 1..n) sum (i in 1..n) x[i][j]==1;
//	forall (j in 1..n) u >= sum(i in 1..n) prefs[i][j]*x[i][j];
//
//}