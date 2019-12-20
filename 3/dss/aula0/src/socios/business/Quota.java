package socios.business;

import java.time.LocalDate;

public class Quota {
    private LocalDate data;
    private float valor;
    private String id;

    public Quota(LocalDate data, float valor, String id) {
        this.data = data;
        this.valor = valor;
        this.id = id;
    }

    public Quota() {
        this.data = LocalDate.now();
        this.valor = 0;
        this.id = "0";
    }

    public Quota(Quota quotas) {
        this.data = quotas.getData();
        this.valor = quotas.getValor();
        this.id = quotas.getId();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Quota={");
        
        sb.append("data=").append(this.data);
        sb.append(";valor=").append(this.valor);
        sb.append(";id =").append(this.id);
        
        return sb.toString();
    }

    public Quota clone(){
        return new Quota(this);
    }

    public boolean equals(Object obj){
        if(obj == this)return true;
        if(obj == null || obj.getClass() != this.getClass())return false;

        Quota quotas = (Quota) obj;

        return quotas.getData().equals(this.getData()) && quotas.getValor() == this.getValor() && quotas.getId() == this.getId();
    }


}