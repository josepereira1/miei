
/**
 * Write a description of class Telemovel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Telemovel
{
    private String marca;
    private String modelo;
    private int x;
    private int y;
    private double dimMensagens;
    private double dimTotal;
    private double dimFotos;
    private double dimApps;
    private int espaco;
    private int nFotos;
    private int nApp;


    public Telemovel(){
        this.setMarca("");
        this.setModelo("");
        this.setX(0);
        this.setY(0);
        this.setDimMensagens(0);
        this.setDimTotal(0);
        this.setDimFotos(0);
        this.setDimApps(0);
        this.setEspaco(0);
        
        
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int Y){
        this.y = y;
    }
    
    public void setDimMensagens(double dimMensagens){
        this.dimMensagens = dimMensagens;
    }
    
    public void setDimTotal(double dimTotal){
        this.dimTotal = dimTotal;
    }
    
    public void setDimFotos(double dimFotos){
        this.dimFotos = dimFotos;
    }
    
    public void setDimApps(double dimApps){
        this.dimApps = dimApps;
    }
    
    public void setEspaco(int espaco){
        this.espaco = espaco;
    }
    
    public void setNFotos(int nFotos){
        this.nFotos = nFotos;
    }
    
    public void setNApp(int nApp){
        this.nApp = nApp;
    }
    
    public boolean existeEspaco(int numeroBytes){
       return true; 
    }
    }
    
