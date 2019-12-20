
/**
 * Escreva a descrição da classe Lampada aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.lang.Math;

public class Lampada
{
   private int estado;  //  0 -> desligada  |   1 -> ligada   |   2 -> ECO;
   private double consumo;
   private LocalDateTime dataInicio;
   private LocalDateTime dataFim;
   private long tempo;
   private double gasto;
   private double ultimoGasto;
   
   public Lampada(){
       this.setEstado(0);
       this.setConsumo(0);
       this.setTempo(0);
       this.setGasto(0);
       this.setUltimoGasto(0);
   }
   
   public Lampada(double consumo){
       this.setConsumo(consumo);
   }
   
   public Lampada(Lampada umaLampada){
       this.setEstado(umaLampada.getEstado());
       this.setConsumo(umaLampada.getConsumo());
    }
   
   public int getEstado(){
    return this.estado;
   }
   
   public double getConsumo(){
       return this.consumo;
   }
   
   public LocalDateTime getDataInicio(){
       return this.dataInicio;
   }
   
   public LocalDateTime getDataFim(){
       return this.dataFim;
   }
   
   public long getTempo(){
       return this.tempo;
   }
   
   public double getGasto(){
       return this.gasto;
   }
   
   public double getUltimoGasto(){
       return this.ultimoGasto;
   }
   
   public void setEstado(int estado){
       this.estado = estado;
   }
   
   public void setConsumo(double consumo){
       this.consumo = consumo;
   }
   
   public void setDataInicio(LocalDateTime dataInicio){
       this.dataInicio = dataInicio;
   }
   
   public void setDataFim(LocalDateTime dataFim){
       this.dataFim = dataFim;
   }
   
   public void setTempo(long tempo){
       this.tempo = tempo;
   }
   
   public void setGasto(double gasto){
       this.gasto = gasto;
   }
   
   public void setUltimoGasto(double ultimoGasto){
       this.ultimoGasto = ultimoGasto;
    }
   
   public Lampada clone(){
       Lampada tmp = new Lampada(this);
       return tmp;
   }
   
   public void lampON(){
       this.setConsumo(15); //  consumo máximo
       this.setEstado(1);
       LocalDateTime dataInicio = LocalDateTime.now();
       this.setDataInicio(dataInicio);
       
   }
   
   public void lampOFF(){
       this.setEstado(0);
       LocalDateTime dataFim = LocalDateTime.now();
       this.setDataFim(dataFim);
       LocalDateTime tmpInicio;
       tmpInicio = getDataInicio();
       setTempo(Math.abs(tmpInicio.until(getDataFim(),ChronoUnit.MILLIS)));
       double gasto = getGasto();
       this.setGasto((gasto + this.getTempo()*this.getConsumo()));
       this.setUltimoGasto((this.getTempo()*this.getConsumo()));
       this.setConsumo(0);
   }
    
   public void lampECO(){
       this.setConsumo(1);
       this.setEstado(2);
       LocalDateTime dataInicio = LocalDateTime.now();
       this.setDataInicio(dataInicio);
   }
   
   public double totalConsumo(){
       return getGasto();
   }
   
   public double periodoConsumo(){
       return getUltimoGasto();
    }
   
   public String toString(){
       StringBuilder sb = new StringBuilder("Lampada={");
       sb.append("estado=").append(this.estado).append(" ;");
       sb.append("consumo=").append(this.consumo).append(" ;");
       sb.append("daInicio=").append(this.dataInicio).append(" ;");
       sb.append("dataFim=").append(this.dataFim).append(" ;");
       sb.append("tempo=").append(this.tempo).append(" ;");
       sb.append("gasto=").append(this.gasto).append("}");
       return sb.toString();
   }
}
