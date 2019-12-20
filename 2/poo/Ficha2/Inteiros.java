
/**
 * Escreva a descrição da classe Inteiros aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Inteiros
{
    private int[] listaInt;
    
    public Inteiros(int[] li){
    listaInt = li;
    }
    
    //exercicio 1_a:
    public int min(){
    int m = this.listaInt[0];
        for(int v:  listaInt){
        if(v < m )
        m=v;
        }
        return m;
     
    }
    
    //exercicio 1_b:
    public int[] subArray(int a, int b){
        int[] x = null;
        if(a<listaInt.length && b < listaInt.length && a < b){
        x = new int[b-a+1];
        System . arraycopy ( listaInt, a ,x , 0, b-a+1);
        }
        return x;
    }
    
    public static void viewArray(int[] array){
        
        int i, size=array.length;
        for(i=0;i<size;i++){
        System.out.println("Array["+i+"]:"+array[i]);
    }
    }
    
    public static void viewArrayStrings(String[] array){
        
        int i, size=array.length;
        for(i=0;i<size;i++){
        System.out.println("Array["+i+"]:"+array[i]);
    }
    }
    
    //exercicio 1_c:
    public static int[] comuns(int[] array1, int[] array2){
        int i,j,w = 0;
        int size1 = array1.length, size2 = array2.length;
        int[] com = null;
        
        if(size1 < size2){
            com = new int[size1];
        }else{
            com = new int[size1];
        }
        
        for(i=0;i < size1;i++){
            for(j=0;j < size2;j++){
                if(array1[i] == array2[j]){
                    com[w] = array1[i];
                    w++;
                }
            }
        }
        return com;
    }
    //exercicio 2_a:
    public static int[][] update(int[][] matrix){
        int i,j;
        int tmp[][] = new int[5][5];
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[i].length;j++){
            tmp[i][j] = matrix[i][j];
            }
        }
        return tmp;
    }
    //exercicio 2_b:
    public static int somaNota(int[][] matrix, int Cadeira){
        int l, soma = 0;
        for(l = 0; l < matrix.length; l++){
            soma = soma + matrix[l][Cadeira];
        }
        return soma;
    }
    //exercicio 2_c:
    public static double mediaAluno(int[][] matrix, int aluno){
        int c;
        double media = 0;
        for(c = 0; c < matrix[aluno].length; c++){
            media = media + matrix[aluno][c];
        }
        media = media / matrix[aluno].length;
        return media;
    }
    //exercicio 2_d:
    public static double mediaUC(int[][] matrix, int uc){
        int l, media = 0;
        
        for(l=0; l < matrix.length; l++)
            media += matrix[l][uc];
            media = media / matrix.length;
        return media;
    }
    //exerciico 2_e:
    public static int notaMaisAlta(int[] [] matrix, int aluno){
        int c, max;
        
        for(max = matrix[aluno][0], c=1;c < matrix[aluno].length; c++)
            if(matrix[aluno][c] > max)max = matrix[aluno][c];
        return max;
    }
    //exercicio 2_f:
    public static int notaMaisBaixa(int[] [] matrix, int aluno){
        int c, min = 21;
        
        for(c=1;c < matrix[aluno].length; c++)
            if(matrix[aluno][c] < min)min = matrix[aluno][c];
        return min;
    }
    //exercicio 2_h:
    public static int[][] notasAMaisDe(int[][] matrix, int nota){
        int l,c;
        for(l = 0; l < matrix.length; l++){
            for(c = 0; c < matrix[l].length; c++){
                if(matrix[l][c] < nota)
                    matrix[l][c] = 0;
            }
        }
        return matrix;
    }
    public static void viewArray2D(int[][] array){
        
        int l,c, size=array.length;
        for(l=0;l<size;l++){
            for(c=0;c<array[l].length;c++){
            System.out.println("Array["+l+"]["+l+"]:"+array[l][c]);
        }
        }
    }
    //exercicio 2_i:
    public static int indiceUCMaisElevada(int[][] matrix){
        int indice = 0,uc;
        double max;
        for(max = 0, uc=0;uc<matrix.length;uc++){
            if(mediaUC(matrix, uc)> max){
                max = mediaUC(matrix, uc);
                indice = uc;
            }
        }
        return indice;
    }
    //exercicio 4_a:
    public static void sortArray(int[] array){
        int i, j;
        for(i=0;i<array.length;i++){
            for(j=i+1;j<array.length;j++){
            if(array[i]>array[j])swap(array,i,j);
            }
        }
    
    }
    public static void swap(int[] array, int i, int j){
        int tmp;
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    //exercicio 4_b:
    public static int procuraBinaria(int[] array, int elem){
        int i = 0, flag = 0;
        
        for(i=0;i<array.length;i++){
            if(array[i] == elem){
                flag++;
                break;
            }
        }
        
        if(flag == 0){
            return 0;
        }else{
            return 1;
        }
    }
    //exercicios 5_a:
    public static String[] removeRepetidos(String[] words){
        int i,j, flag = 0, h = 0;
        String[] newWords = new String[words.length];
        
        for(i = 0; i < words.length-1; i++){
            for(j = i+1; j < words.length; j++){
                System.out.println(words[i]+" "+words[j]);
                if(words[i] == words[j])flag++; //  AQUI ESTA A COMPARAR OS PONTEIROS , TENHO QUE FAZER O METODO PARA COMPARAR;
            }
            if(flag == 0){
                newWords[h] = words[i];
                h++;
                flag = 0;
            }
        }
        
        return words;
    }
    }
