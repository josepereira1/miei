
/**
 * Escreva a descrição da classe Carro aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Carro
{
    private String marca;
    private String modelo;
    private int ano;
    private float consumoInsta; //  consumo a uma velocidade de 100 km/h;
    private int km;
    private float media;
    private float kmUltimoPercurso;
    private float mediaUltimoPercurso;
    private float capacidade;
    private int estado;
    
    public Carro(){
        this.setMarca("");
        this.setModelo("");
        this.setAno(0);
        this.setConsumoInsta(0);
        this.setKm(0);
        this.setMedia(0);
        this.setKmUltimoPercurso(0);
        this.setMediaUltimoPercurso(0);
        this.setCapacidade(0);
        this.setEstado(0);
    }
    
    public Carro(String marca, String modelo, int ano, float consumoInsta, int km, float media, float kmUltimoPercurso, float mediaUltimoPercurso, int capacidade, int estado){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setConsumoInsta(consumoInsta);
        this.setKm(km);
        this.setMedia(media);
        this.setKmUltimoPercurso(kmUltimoPercurso);
        this.setMediaUltimoPercurso(mediaUltimoPercurso);
        this.setCapacidade(capacidade);
        this.setEstado(estado);
    }
    
    public Carro(Carro umCarro){
        this.setMarca(umCarro.getMarca());
        this.setModelo(umCarro.getModelo());
        this.setAno(umCarro.getAno());
        this.setConsumoInsta(umCarro.getConsumoInsta());
        this.setKm(umCarro.getKm());
        this.setMedia(umCarro.getMedia());
        this.setKmUltimoPercurso(umCarro.getKmUltimoPercurso());
        this.setMediaUltimoPercurso(umCarro.getMediaUltimoPercurso());
        this.setCapacidade(umCarro.getCapacidade());
        this.setEstado(umCarro.getEstado());
    }
    
    
    
    public String getMarca(){
        return this.marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public float getConsumoInsta(){
        return this.consumoInsta;
    }
    
    public int getKm(){
        return this.km;
    }
    
    public float getMedia(){
        return this.media;
    }
    
    public float getKmUltimoPercurso(){
        return this.kmUltimoPercurso;
    }
    
    public float getMediaUltimoPercurso(){
        return this.mediaUltimoPercurso;
    }
    
    public float getCapacidade(){
        return this.capacidade;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    
    public void setConsumoInsta(float consumoInsta){
        this.consumoInsta = consumoInsta;
    }
    
    public void setKm(int km){
        this.km = km;
    }
    
    public void setMedia(float media){
        this.media = media;
    }
    
    public void setKmUltimoPercurso(float kmUltimoPercurso){
        this.kmUltimoPercurso = kmUltimoPercurso;
    }
    
    public void setMediaUltimoPercurso(float mediaUltimoPercurso){
        this.mediaUltimoPercurso = mediaUltimoPercurso;
    }
    
    public void setCapacidade(float capacidade){
        this.capacidade = capacidade;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public Carro clone(){
        Carro newCar = new Carro(this);
        return newCar;
    }
    
    public void ligaCarro(){
        this.setEstado(1);
    }
    
    public void desligaCarro(){
        this.setEstado(0);
        
    }
    
}
