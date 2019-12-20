
/**
 * Escreva a descrição da classe GestorPontos2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorPontos2
{
    private List<Ponto> pontos;
    
    public GestorPontos2(){
        pontos = new ArrayList<>();
    }
    
    public GestorPontos2(List<Ponto> pontos){
        
    }
    
    public GestorPontos2(GestorPontos2 obj){
        
    }
    
    public void setPontos(List<Ponto> pontos){
        this.pontos = pontos.stream().map(Ponto :: clone).collect(Collectors.toList());
    }
    
    public List<Ponto> getPontos(){
        return pontos.stream().map(Ponto :: clone).collect(Collectors.toList());
    }
    
    public void addPonto(Ponto p){
        this.pontos.add(p.clone());
    }
    
    public String toString(){
        return pontos.toString();
    }
}
