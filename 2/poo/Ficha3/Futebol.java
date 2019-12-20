
/**
 * Escreva a descrição da classe Futebol aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Futebol
{
    private int estado;
    private int golosVisitante;
    private int golosVisitado;
    
    public Futebol(){
        this.setEstado(0);
        this.setGolosVisitante(0);
        this.setGolosVisitado(0);
    }
    
    public Futebol(int estado, int golosVisitante, int golosVisitado){
        this.setEstado(estado);
        this.setGolosVisitante(golosVisitante);
        this.setGolosVisitado(golosVisitado);
    }
    
    public Futebol(Futebol umFutebol){
        this.setEstado(umFutebol.getEstado());
        this.setGolosVisitante(umFutebol.getGolosVisitante());
        this.setGolosVisitado(umFutebol.getGolosVisitado());
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public void setGolosVisitante(int golosVisitante){
        this.golosVisitante = golosVisitante;
    }
    
    public void setGolosVisitado(int golosVisitado){
        this.golosVisitado = golosVisitado;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public int getGolosVisitante(){
        return this.golosVisitante;
    }
    
    public int getGolosVisitado(){
        return this.golosVisitado;
    }
    
    public Futebol clone(){
        Futebol tmp = new Futebol(this);
        return tmp;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Estado:");
        sb.append(this.getEstado());
        sb.append("\nGolos do Visitante: ");
        sb.append(this.getGolosVisitante());
        sb.append("\nGolos do Visitado: ");
        sb.append(this.getGolosVisitado());
        return sb.toString();
    }
    
    public void startGame(){
        this.setEstado(1);
    }
    
    public void endGame(){
        this.setEstado(0);
    }
    
    public void goloVisitado(){
        int golos = this.getGolosVisitado();
        this.setGolosVisitado(++golos);
    }
    
    public void goloVisitante(){
        int golos = this.getGolosVisitante();
        this.setGolosVisitante(++golos);
    }
    
    public String resultadoActual(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getGolosVisitado());
        sb.append(" - ");
        sb.append(this.getGolosVisitante());
        sb.append("\n");
        return sb.toString();
    }
}
