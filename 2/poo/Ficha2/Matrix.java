
/**
 * Write a description of class Matrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.System;
import java.util.Scanner;

public class Matrix
{
    private int[][] matrix;
    
    public Matrix(){
    this.matrix = new int[5][5];
    }
    
    public Matrix(int linhas, int colunas){
        this.matrix = new int[linhas][colunas];
    }
    public Matrix(Matrix mat){
        int i;
        
        this.matrix = new int[mat.matrix.length][];
        
        for(i=0; i < this.matrix.length; i++){
            this.matrix[i] = new int[mat.matrix[i].length];
            System.arraycopy(mat.matrix[i],0,this.matrix[i],0,mat.matrix[i].length);
        }
    }
    
    public int getLinhas(){
        return this.matrix.length;
    }
    public int getColunasAtIndex(int index){
        return this.matrix[index].length;
    }
    
    //exercício 7 a):
    public void setElemAtIndex(int elem,int linha, int coluna){
        this.matrix[linha][coluna] = elem;
    }
    
    public int getElemAtIndex(int elem,int linha, int coluna){
        int tmp = this.matrix[linha][coluna];
        return tmp;
    }
    
    public void printMatrix(){
        for(int i = 0; i < this.matrix.length; i++)
            for(int j = 0; j < this.matrix[i].length; j++)
            System.out.println(this.matrix[i][j]); 
    }
    
    public Matrix clone(){
        Matrix tmp = new Matrix(this);
        return tmp;
    }
    
    //exercício 7 c):
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || o.getClass() != this.getClass())return false;
        
        Matrix mat = (Matrix) o;
        
        for(int i = 0; i < mat.matrix.length; i++)
            for(int j = 0; j < mat.matrix[i].length; j++)
                if(mat.matrix[i][j] != this.matrix[i][j])return false;
        return true;
    }
    
    
}
