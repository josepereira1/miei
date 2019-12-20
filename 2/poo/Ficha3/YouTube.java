
/**
 * Escreva a descrição da classe YouTube aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.time.LocalDate;
import java.lang.System;

import java.time.temporal.ChronoUnit;
public class YouTube
{
    private String nome;
    private byte[] conteudo;
    private LocalDate data;
    private String resolucao;
    private int[] tempo;    //  guardo o tempo como array, onde na primeira posição guardo os minutos e na segunda os segundos;
    private String[] comentarios;
    private int likes;
    private int dislikes;
    
    
    public YouTube(){
        this.setNome("");
        byte[] tmp = new byte[10];
        this.setConteudo(tmp);
        LocalDate date = LocalDate.of(1,1,1);
        this.getResolucao();
        this.setData(date);
        String[] str = {""};
        this.setComentarios(str);
        this.setLikes(0);
        this.setDislikes(0);
    }
    
    public YouTube(String nome, byte[] conteudo, LocalDate data, String resolucao, int[] tempo, String[] comentarios, int likes, int dislikes){
        this.setNome(nome);
        this.setConteudo(conteudo);
        this.setData(data);
        this.setResolucao(resolucao);
        this.setTempo(tempo);
        this.setComentarios(comentarios);
        this.setLikes(likes);
        this.setDislikes(dislikes);
    }
    
    public YouTube(YouTube umVideo){
        this.nome = umVideo.getNome();
        this.conteudo = umVideo.getConteudo();
        this.data = umVideo.getData();
        this.resolucao = umVideo.getResolucao();
        this.tempo = umVideo.getTempo();
        this.comentarios = umVideo.getComentarios();
        this.likes = umVideo.getLikes();
        this.dislikes = umVideo.getDislikes();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public byte[] getConteudo(){
        byte[] tmp = new byte[this.conteudo.length];
        System.arraycopy(this.conteudo, 0, tmp, 0, this.conteudo.length);
        return tmp;
    }
    
    public LocalDate getData(){
        return this.data;
    }
    
    public String getResolucao(){
        return this.resolucao;
    }
    
    public int[] getTempo(){
        int[] tmp = new int[this.tempo.length];
        System.arraycopy(this.tempo, 0, tmp, 0, this.tempo.length);
        return tmp;
    }
    
    public int getMin(){
        return this.tempo[0];
    }
    
    public int getSegundos(){
        return this.tempo[1];
    }
    
    public String[] getComentarios(){
        return this.comentarios;
    }
    
    public int getLikes(){
        return this.likes;
    }
    
    public int getDislikes(){
        return this.dislikes;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setConteudo(byte[] conteudo){
        byte[] tmp = new byte[conteudo.length];
        System.arraycopy(conteudo, 0, tmp, 0, conteudo.length);
        this.conteudo = tmp;
    }
    
    public void setData(LocalDate data){
        this.data = data;
    }
    
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    
    public void setTempo(int[] tempo){
        this.tempo = new int[tempo.length];
        System.arraycopy(tempo, 0, this.tempo, 0, tempo.length);
    }
    
    public void setComentarios(String[] comentarios){
        /*
        for(int i = 0; i < comentarios.length; i++)
            System.arraycopy(comentarios, 0, this.comentarios, 0, comentarios[i].length());
        */
       this.comentarios = comentarios;  //  posso fazer assim porque isto é um array de strings, mas caso não fosse, fazia como está em cima.
    }
    
    public void setLikes(int likes){
        this.likes = likes;
    }
    
    public void setDislikes(int dislikes){
        this.dislikes = likes;
    }
    
    public YouTube clone(){
        YouTube tmp = new YouTube(this);
        return tmp;
    }
    
    public void insereComentario(String comentario){
        String[] tmp = new String[this.comentarios.length+1];
        System.arraycopy(this.comentarios,0, tmp, 0, this.comentarios.length);
        tmp[this.comentarios.length] = comentario;
        setComentarios(tmp);
    }
    
    public long qtsDiasDepois(){
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataVideo;
        dataVideo = getData();
        long dias = dataHoje.until(dataVideo, ChronoUnit.DAYS);
        return dias;
    }
    
    public void thumbsUp(){
        int likes = this.getLikes();
        this.setLikes(likes+1);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("nome:");
        sb.append(this.getNome());
        sb.append("\nconteúdo:");
        for(int j = 0; j < this.conteudo.length; j++){
            sb.append(this.conteudo[j]);
        }
        sb.append("\ndata:");
        sb.append(this.getData());
        sb.append("\nresolução");
        sb.append(this.getResolucao());
        sb.append("\ntempo:");
        sb.append(this.getMin());
        sb.append("m");
        sb.append(this.getSegundos());
        sb.append("s\n");
        for(int i = 0; i < this.comentarios.length; i++){
            sb.append("Comentário número");
            sb.append(i+1);
            sb.append(": ");
            sb.append(this.comentarios[i]);
            sb.append("\n");
        }
        sb.append("likes:");
        sb.append(this.getLikes());
        sb.append("\ndislikes:");
        sb.append(this.getDislikes());
        
        return sb.toString();
    }
    
}
