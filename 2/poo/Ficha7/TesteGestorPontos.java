
/**
 * Escreva a descrição da classe TesteGestorPontos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class TesteGestorPontos
{
    public static void main(String[] args){
    Ponto3D p1 = new Ponto3D(1,1,1);
    Ponto3D p2 = new Ponto3D(2,2,2);
    Ponto p3 = new Ponto(3,3);
    Ponto p4 =  new Ponto(4,4);
    GestorPontos2 gp = new GestorPontos2();
    gp.addPonto(p3);
    gp.addPonto(p4);
    }
}
