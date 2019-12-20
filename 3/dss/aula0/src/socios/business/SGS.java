package socios.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class SGS extends Observable{  /*  Sistema de gestão de sócios */

    private Map<String, Socio> socios;
    private String lastQuotaId;

    public SGS(Map<String, Socio> socios, String lastQuotaId) {
        this.socios = socios;
        this.lastQuotaId = lastQuotaId;
        
        this.setChanged();
        this.notifyObservers();
    }

    public SGS() {
        this.socios = new HashMap<>();
        this.lastQuotaId = "0";
        
        this.setChanged();
        this.notifyObservers();
    }

    public SGS(SGS sgs) {
        this.socios = sgs.socios;
        this.lastQuotaId = sgs.lastQuotaId;
        
        this.setChanged();
        this.notifyObservers();
    }

    public Map<String, Socio> getSocios() {
        HashMap<String,Socio> clone = new HashMap<String, Socio>();

        for(Map.Entry<String,Socio> entry : this.socios.entrySet())
            clone.put(entry.getKey(), entry.getValue().clone());
        return socios;
    }

    public void setSocios(Map<String, Socio> socios) {
        this.socios = new HashMap<String, Socio>();
        for(Map.Entry<String, Socio> entry : this.socios.entrySet())
            this.socios.put(entry.getKey(), entry.getValue());
        
        this.setChanged();
        this.notifyObservers();
            
    }
    
    public String getLastQuotaId() {
        return lastQuotaId;
    }

    public void setLastQuotaId(String lastCotaId) {
        this.lastQuotaId = lastCotaId;
        
        this.setChanged();
        this.notifyObservers();
    }

    public SGS clone(){
        this.setChanged();
        this.notifyObservers();
        
        return new SGS(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SGS={");
        sb.append("socios=").append(this.socios);
        sb.append("lastQuotaId=").append(this.lastQuotaId).append("}");
        
        return sb.toString();
    }

    /***
     * Regista um sócio.
     * @param nome nome do sócio
     * @param numero número do sócio
     * @param idade idade do sócio
     * @param sexo sexo do sócio
     * @param quotas quotas do sócio, inicialmente devem ser nenhumas
     * @throws SocioJaExisteException exception que verifica se já existe um sócio com os dados introduzidos
     */
    public void add(String nome, String numero, String idade, char sexo, Map<String, Quota> quotas) throws SocioJaExisteException{
        Socio socio = new Socio(nome, numero, idade, sexo, quotas);
        if(contains(socio)){
            throw new SocioJaExisteException();
        }else{
            this.socios.put(socio.getNumero(), socio);
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public void add(Socio socio){
        if(contains(socio)){
            new SocioJaExisteException(String.valueOf(socio.getNumero()));
        }else{
            this.socios.put(socio.getNumero(), socio);
        }
    }
    
    public boolean contains(Socio socio){
        return this.socios.containsKey(socio.getNumero());
    }
}
