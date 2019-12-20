
/**
 * Escreva a descrição da classe Ponto3D aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ponto3D extends Ponto
{
   private int z;
   
   public Ponto3D(){
       super();
       this.setZ(0);
   }
   
   public Ponto3D(int x, int y, int z){
       super(x,y);
       this.setZ(z);
   }
   
   public Ponto3D(Ponto3D umPonto){
       super();
       this.setZ(umPonto.getZ());
   }
   
   public Ponto clone(){
       Ponto3D ponto = new Ponto3D(this);
       return ponto;
   }
   
   public int getZ(){
       return this.z;
   }
   
   public void setZ(int z){
       this.z = z;
   }
   
   public void deslocamento(int deltaX, int deltaY, int deltaZ){
       super.deslocamento(deltaX,deltaY);
       this.setZ(deltaZ);
       
   }
   
   public double distancia(Ponto3D umPonto){
       return Math.sqrt(Math.pow(this.getX() - umPonto.getX(),2)+
                        Math.pow(this.getY() - umPonto.getY(),2)+
                        Math.pow(this.getZ() - umPonto.getZ(),2));
   }
   
   public boolean iguais(Ponto3D umPonto){
       return super.equals(umPonto) && this.z == umPonto.getZ(); 
   }
   
   public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || o.getClass() != this.getClass())return false;
       
       Ponto3D ponto = (Ponto3D) o;
       return this.iguais(ponto);
   }
}
