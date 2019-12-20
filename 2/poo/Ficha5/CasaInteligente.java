
/**
 * Escreva a descrição da classe CasaInteligente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CasaInteligente
{
    List<Lampada> lampadas;
    
    public CasaInteligente(){
        this.lampadas = new ArrayList();
    }
    
    public CasaInteligente(List<Lampada> lampadas){
        this.setLampadas(lampadas);
    }
    
    public CasaInteligente(CasaInteligente umaCasaInteligente){
        this.lampadas = umaCasaInteligente.getLampadas();
    }
    
    public void setLampadas(List<Lampada> lampadas){
        this.lampadas = new ArrayList(lampadas);
    }
    
    public List<Lampada> getLampadas(){
        return new ArrayList(this.lampadas);
    }
    
    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || this.getClass() != o.getClass())return false;
        
        CasaInteligente casa = (CasaInteligente) o;
        
        return this.lampadas.equals(casa.getLampadas());
    }
    
    public String toString(){
        final StringBuilder sb = new StringBuilder("CasaInteligente={");
        sb.append("lampadas=").append(this.lampadas.toString());
        sb.append(" };");
        return sb.toString();
    }
    
    public void addLampada(Lampada l){
        this.lampadas.add(l);
    }
    
    public void ligaLampadaNormal(int index){
        Lampada lampada = this.lampadas.get(index);
        lampada.lampON();
        this.lampadas.set(index, lampada);
    }
    
    public void ligaLampadaEco(int index){
        Lampada lampada = this.lampadas.get(index);
        lampada.lampECO();
        this.lampadas.set(index, lampada);
    }
    
    public long qtEmEco(){
        return this.lampadas.stream().filter(a -> a.getEstado() == 2).count();
    }
    
    public void removeLampada(int index){
        this.lampadas.remove(index);
    }
    
    public void ligaTodasEco(){
        this.lampadas.stream().forEach(Lampada :: lampECO);
    }
    
    public void ligaTodasMax(){
        this.lampadas.stream().forEach(Lampada :: lampON);
    }
    
    public double consumoTotal(){
        double consumo = 0;
        long tempo;
        for(Lampada lampada: this.lampadas){
            tempo = lampada.getDataInicio().until(LocalDateTime.now(),ChronoUnit.MILLIS);
            consumo+= lampada.getConsumo() * tempo;
        }
        return consumo;
    }
    
    public void reset(){
        
    }
}
