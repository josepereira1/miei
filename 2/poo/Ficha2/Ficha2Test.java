
/**
 * Escreva a descrição da classe Ficha2Test aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Scanner;
public class Ficha2Test
{
    public static void main(String[] args){
    int[] array = {12,22,4,42};
    Inteiros inteiros = new Inteiros(array);
        
    /*int min = inteiros.min();
    System.out.println(min);*/
    
    /*int[] dest = new int[5];
    dest = inteiros.subArray(1,2);
    Inteiros.viewArray(dest);*/
    
    /*int[] array1 = {1,2,3,4};
    int[] array2 = {4,3,7,1};
    
    array1 = inteiros.comuns(array1,array2);
    Inteiros.viewArray(array1);*/
    
    int[][] alunos = {{15,14,13,17,18},
                      {13,12,15,18,20},
                      {11,12,14,19,14},
                      {10,12,15,18,20},
                      {20,20,15,10,20}};
    // exercicio 2_b:
    /*System.out.println(inteiros.somaNota(alunos, 1));*/
    
    // exercicio 2_c:
    /*System.out.println(inteiros.mediaAluno(alunos, 1));*/
    
    //exercicio 2_d:
    /*System.out.println(inteiros.mediaUC(alunos, 0));*/
    
    //exercicio 2_e:
    /*
     * int l;
    
    for(l = 0; l < alunos.length; l++)
        System.out.println("Aluno "+l+" tem nota mais alta:"+inteiros.notaMaisAlta(alunos, l));
    */
    //exercicio 2_f:
    /* 
    int l;
    
    for(l = 0; l < alunos.length; l++)
        System.out.println("Aluno "+l+" tem nota mais baixa:"+inteiros.notaMaisBaixa(alunos, l));
    */
    //exercicio 2_h:
    /*inteiros.viewArray2D(inteiros.notasAMaisDe(alunos,15));*/
    
    //exercicio 2_i:
    /*System.out.println("UC com melhor media: "+inteiros.indiceUCMaisElevada(alunos));*/
    
    //exercicio 4_a:
    /*
    int[] array1 = {4,5,23,7,1,2};
    inteiros.sortArray(array1);
    inteiros.viewArray(array1);
    */
    
    //exercicio 4_b:
    /*
    int[] array1 = {1,2,3,4,5,6,11};
    System.out.println(inteiros.procuraBinaria(array1,30));
    */
    
    /*
    int i = 0;
    String[] words = new String[5];
    Scanner input = new Scanner(System.in);
    
    while(i < words.length){
        System.out.println(i+"-> Introduza uma palavra:");
        words[i] = input.nextLine();
        i++;
    }
    words = inteiros.removeRepetidos(words);
    inteiros.viewArrayStrings(words);
    */
   
   //exercício 7:
    
   Matrix mat1 = new Matrix();
   
   for(int i = 0; i < mat1.getLinhas(); i++){
       for(int j = 0; j < mat1.getColunasAtIndex(i); j++){
       mat1.setElemAtIndex(i,i,j); 
       }
   }
   
   Matrix mat2 = new Matrix(mat1);
   System.out.println("PRIMEIRA MATRIZ:");
   mat1.printMatrix();
   System.out.println("SEGUNDA MATRIZ:");
   mat2.printMatrix();
   }
}
