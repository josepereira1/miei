
/**
 * Escreva a descrição da classe Ponto aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ponto
{
    
    private int x;
    private int y;
    
    public Ponto(){
        this.setX(0);
        this.setY(0);
    }
    
    public Ponto(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    public Ponto(Ponto umPonto){
        this.setX(umPonto.getX());
        this.setY(umPonto.getY());
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public Ponto clone(){
        Ponto ponto = new Ponto(this);
        return ponto;
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || o.getClass() != this.getClass())return false;
        
        Ponto ponto = (Ponto) o;
        
        return ponto.getX() == this.getX() && ponto.getY() == this.getY();
    }
    
    public void deslocamento(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    
}
