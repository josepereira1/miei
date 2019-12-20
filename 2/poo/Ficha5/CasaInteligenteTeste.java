
/**
 * Escreva a descrição da classe CasaInteligenteTeste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CasaInteligenteTeste
{
    public static void main(String[] args){
        Lampada l1 = new Lampada(1);
        Lampada l2 = new Lampada(1);
        Lampada l3 = new Lampada(1);
        Lampada l4 = new Lampada(1);
        Lampada l5 = new Lampada(1);
        Lampada l6 = new Lampada(1);
        
        CasaInteligente casa = new CasaInteligente();
        
        casa.addLampada(l1.clone());
        casa.addLampada(l2.clone());
        casa.addLampada(l3.clone());
        casa.addLampada(l4.clone());
        casa.addLampada(l5.clone());
        casa.addLampada(l6.clone());
        
        System.out.println(casa.toString());
        
        casa.ligaLampadaNormal(2);
        casa.ligaLampadaEco(0);
        
        System.out.println(casa.toString());
        
        System.out.println("número de lâmpadas ECO="+casa.qtEmEco());
        
        casa.removeLampada(0);
        
        casa.ligaTodasEco();
        
        System.out.println(casa.toString());
        
        System.out.println("consumo total="+casa.consumoTotal());
        
        
    }
}
