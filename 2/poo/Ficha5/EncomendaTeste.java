
/**
 * Escreva a descrição da classe EncomendaTeste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.List;
import java.util.ArrayList;
public class EncomendaTeste
{
    public static void main(String[] args){
    ArrayList<LinhaDeEncomenda> encomendas = new ArrayList();
    LinhaDeEncomenda l1 = new LinhaDeEncomenda("1212", "bolachas" ,  1.5 , 1000 , 0.23, 0.50);
    LinhaDeEncomenda l2 = new LinhaDeEncomenda("1213", "arroz" ,  0.70 , 5000 , 0.23, 0.10);
    
    encomendas.add(l1.clone());
    encomendas.add(l2.clone());
    
    Encomenda enc = new Encomenda("João Carvalho", "123456789", "Braga", 1, encomendas);
    
    System.out.println(enc);
    
    enc.removeProduto("1212");
    
    System.out.println(enc);
    }
}
