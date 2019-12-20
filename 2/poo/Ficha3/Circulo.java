import java.lang.Math;
/**
 * Escreva a descrição da classe Circulo aqui.
 * 
 * @author Jose Pereira
 * @version 1
 */
public class Circulo
{
    private double x;
    private double y;
    private double r;
    
    /**Contrutor vazio.
       */
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.r = 0;
    }
    /**
     * Contrutor parametrizado.
     * @param coordX - coordenada x.
     * @param coordY - coordenada y.
     * @param raio - raio;
     */
    public Circulo(double coordX, double coordY, double raio){
        this.x = coordX;
        this.y = coordY;
        this.r = raio;
    }
    /**
     * Construtor cópia.
     * 
     * @param umCirculo - é o objeto que vai ser copiado.
     */
    public Circulo(Circulo umCirculo){
        this.x = umCirculo.x;
        this.y = umCirculo.y;
        this.r = umCirculo.r;
    }
    /**
     * Função que vai buscar o valor da coordenada x.
     */
    //ex_1_a:
    public double getX(){
       return this.x;
    }
    
    /**
     * Função que vai buscar o valor da coordenada y.
     */
    //ex_1_b:
    public double getY(){
        return this.y;
    }
    
    /**
     * Função que vai buscar o valor do raio.
     */
    //ex_1_c:
    public double getR(){
        return this.r;
    }
    
    /**
     * Função que coloca o valor enviado como parâmetro na coordenada x.
     * 
     * @param x - coordenada x.
     */
    //ex_1_d:
    public void setX(double x){
        this.x = x;
    }
    
    /**
     * Função que coloca o valor enviado como parâmetro na coordenada y.
     * 
     * @param x - coordenada y.
     */
    public void setY(double y){
        this.y = y;
    }
    
    /**
     * Função que coloca o valor enviado como parâmetro no valor do raio.
     * 
     * @param r - raio.
     */
    public void setR(double r){
        this.r = r;
    }
    
    /**
     * Função que retorna uma cópia deste objeto.
     */
    public Circulo clone(){
        Circulo clonado = new Circulo(this);
        return clonado;
    }
    public Boolean equals(Circulo umCirculo){
        if(this == umCirculo) return true; //   comparar com o proprio objeto;
        
        if(umCirculo == null || this.getClass() != umCirculo.getClass())return false;
        
        return (this.x == umCirculo.getX() && this.y == umCirculo.getY() && this.r == umCirculo.getR());
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Coord x =");
        sb.append(this.getX());
        sb.append("\nCoord y =");
        sb.append(this.getY());
        sb.append("\nRaio =");
        sb.append(this.getR());
        return sb.toString();
    }
    
    //ex_1_e:
    public void alteraCentro(double x, double y){
        this.setX(x);
        this.setY(y);
    }
    
    //ex_1_f:
    public double calculaArea(){
        return Math.PI*(this.r)*(this.r);
    }
    
    //ex_1_g:
    public double calculaPerimetro(){
        return 2*(Math.PI)*(this.r);
    }
}
