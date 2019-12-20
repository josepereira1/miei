package socios.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Socio extends Observable{
    private Map<String,Quota> quotas;
    private String nome;
    private String numero;
    private String idade;
    private char sexo;

    public Socio(String nome, String numero, String idade, char sexo, Map<String, Quota> quotas) {
        this.nome = nome;
        this.numero = numero;
        this.idade = idade;
        this.sexo = sexo;
        this.quotas = quotas;
        
        this.setChanged();
        this.notifyObservers();
    }

    public Socio() {
        this.nome = "";
        this.numero = "";
        this.idade = "";
        this.sexo = ' ';
        this.quotas = new HashMap<>();
        
        this.setChanged();
        this.notifyObservers();
    }

    public Socio(Socio socio) {
        this.nome = socio.nome;
        this.numero = socio.numero;
        this.idade = socio.idade;
        this.sexo = socio.sexo;
        this.quotas = socio.getQuotas();
        
        this.setChanged();
        this.notifyObservers();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        
        this.setChanged();
        this.notifyObservers();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        
        this.setChanged();
        this.notifyObservers();
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
        
        this.setChanged();
        this.notifyObservers();
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public Map<String, Quota> getQuotas() {
        HashMap<String,Quota> clone = new HashMap<>();
        for(Map.Entry<String,Quota> entry: this.quotas.entrySet())
            clone.put(entry.getKey(),entry.getValue().clone());

        return clone;
    }

    public void setQuotas(Map<String, Quota> cotas) {
        this.quotas = new HashMap<>();
        for(Map.Entry<String,Quota> entry: cotas.entrySet())
            this.quotas.put(entry.getKey(),entry.getValue().clone());
        
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Socio={");
        sb.append("nome=").append(this.getNome());
        sb.append(";numero:").append(this.getNumero());
        sb.append(";idade=").append(this.getIdade());
        sb.append(";sexo=").append(this.getSexo()).append("}");
        sb.append(";quotas=").append(this.quotas).append("}");
        
        return sb.toString();
    }

    public Socio clone(){
        return new Socio(this);
    }

    public void add(String id, Quota quota){
        this.quotas.put(id, quota.clone());
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || o.getClass() != this.getClass())return false;
        
        Socio socio = (Socio) o;
        
        return this.nome.equals(socio.nome) && this.numero.equals(socio.numero)
                && this.idade.equals(socio.idade) && this.sexo == (socio.sexo)
                && this.quotas.equals(socio.quotas);
    
    }
}
