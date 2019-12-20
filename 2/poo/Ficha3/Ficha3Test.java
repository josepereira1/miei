
/**
 * Escreva a descrição da classe Ficha3Test aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
import java.time.LocalDate;
import java.lang.Math;
import java.util.ArrayList;

public class Ficha3Test {
    /*Resumo Teorico:
       -> Numa Class temos que ter sempre definidos os metodos: toString(), equal(), clone();
       -> O equals() do java compara os ponteiros dos objetos, logo temos que fazer um equals adequado a nossa Class;
       -> O mesmo se diz toString, pois funciona mal para arrays que nao estejam 100% ocupados;
       -> Nao precisamos de fazer encapsulamento para tipos simples, Strings e LocalDates;
       -> 
       */
    
    public static void main(String[] args) {
        //exercício 1:
        
        Circulo circulo1 = new Circulo();
        Circulo circulo2 = new Circulo(3,2,4);
        Circulo circulo3 = new Circulo(circulo2);
        Circulo circulo4 = new Circulo(3,2,5);
        //System.out.println(circulo4.toString());
        //System.out.println(circulo1.calculaArea());
        //System.out.println(circulo2.calculaArea());
        //System.out.println(circulo2.equals(circulo4));
        
        
        
        //exercício 7_a:
        LinhaDeEncomenda enc1 = new LinhaDeEncomenda("123", "leite", 1.55, 2000, 0.23, 0.1);
        LinhaDeEncomenda enc2 = new LinhaDeEncomenda();
        LinhaDeEncomenda enc3 = enc1.clone();
        //System.out.println(enc1.equals(enc3));
        //exercício 7_b:
        //System.out.println(enc1.calculaValorLinhaEnc());
        //exercício 7_c:
        //System.out.println(enc1.calculaValorDesconto());
        //exercício 8:
        
       
        YouTube video1 = new YouTube();
        byte[] conteudo = new byte[5];
        conteudo[0] = 1;
        conteudo[1] = 1;
        conteudo[2] = 1;
        conteudo[3] = 0;
        conteudo[4] = 1;
        LocalDate data = LocalDate.of(2018,4,10);
        int[] tempo = {1,30};
        String[] comentarios = {"Video muito bom", "Gostei muito do video"};
        
        YouTube video2 = new YouTube("HELLO WORLD",conteudo, data, "1080X860HD", tempo, comentarios, 150, 10);
        
        //System.out.println(video2.toString());
        //ex_3_b:
        video2.insereComentario("NÃO GOSTEI DO VÍDEO");
        //System.out.println(video2.toString());
        //System.out.println("dias:"+Math.abs(video2.qtsDiasDepois()));
        
        //System.out.println("Antes do LIKE !");
        //System.out.println(video2.toString());
        video2.thumbsUp();
        //System.out.println("DEPOIS DO LIKES!");
        //System.out.println(video2.toString());
        
        
        //System.out.println("LIGUEI A LAMPADA!!!!!");
        Lampada l1 = new Lampada();
        l1.lampON();
        //System.out.println(l1.toString());
        for(int i = 0; i < 10000000; i++);
        l1.lampOFF();
        //System.out.println(l1.toString());
        //System.out.println("ÚLTIMO CONSUMO:"+ l1.periodoConsumo());
        //System.out.println("TOTAL CONSUMO:"+l1.totalConsumo());
        
        //System.out.println("LIGUEI A LAMPADA!!!!!");
        l1.lampON();
        //System.out.println(l1.toString());
        for(int i = 0; i < 10000000; i++);
        l1.lampOFF();
        //System.out.println(l1.toString());
        //System.out.println("ÚLTIMO CONSUMO:"+ l1.periodoConsumo());
        //System.out.println("TOTAL CONSUMO:"+l1.totalConsumo());
        
        //System.out.println("LIGUEI A LAMPADA!!!!!");
        l1.lampON();
        //System.out.println(l1.toString());
        for(int i = 0; i < 10000000; i++);
        l1.lampOFF();
        //System.out.println(l1.toString());
        //System.out.println("ÚLTIMO CONSUMO:"+ l1.periodoConsumo());
        //System.out.println("TOTAL CONSUMO:"+l1.totalConsumo());
        
        
        
        Futebol jogo1 = new Futebol();
        jogo1.startGame();
        //System.out.println(jogo1.toString());
        jogo1.goloVisitado();
        //System.out.println(jogo1.toString());
        jogo1.goloVisitado();
        //System.out.println(jogo1.toString());
        jogo1.goloVisitante();
        //System.out.println(jogo1.resultadoActual());
        
        LinhaDeEncomenda linha1 = new LinhaDeEncomenda("1","integral", 1, 2 , 0.23 , 0.10);
        LinhaDeEncomenda linha2 = new LinhaDeEncomenda("2","água", 1, 2 , 0.23 , 0.10);
        /*
         * 
        LinhaDeEncomenda linha3 = new LinhaDeEncomenda("20103","integral", 0.70, 1500 , 0.23 , 0.10);
        LinhaDeEncomenda linha4 = new LinhaDeEncomenda("20103","integral", 0.70, 1500 , 0.23 , 0.10);
        LinhaDeEncomenda linha5 = new LinhaDeEncomenda("20103","integral", 0.70, 1500 , 0.23 , 0.10);
        LinhaDeEncomenda linha6 = new LinhaDeEncomenda("20103","integral", 0.70, 1500 , 0.23 , 0.10);
        LinhaDeEncomenda linha7 = new LinhaDeEncomenda("20103","integral", 0.70, 1500 , 0.23 , 0.10);
        */
        ArrayList<LinhaDeEncomenda> linha = new ArrayList<LinhaDeEncomenda>(7);
        
        linha.add(linha1);
        linha.add(linha2);
        /*
        linha.add(linha3);
        linha.add(linha4);
        linha.add(linha5);
        linha.add(linha6);
        linha.add(linha7);
        */
        
        
        
        Encomenda e1 = new Encomenda("Empresa1", "12312313123","Vilarinho", 1 , linha);
        
        System.out.println(e1.toString());
        
        System.out.println("VALOR TOTAL:"+ e1.calculaValorTotal());
        System.out.println("NÚMERO DE PRODUTOS:"+e1.numeroTotalProdutos());
        System.out.println(e1.existeProdutoEncomenda("teste"));
        System.out.println("ANTES DE REMOVER:");
        System.out.println(e1.toString());
        e1.removeProduto("1");
        System.out.println("DEPOIS DE REMOVER:");
        System.out.println(e1.toString());
    }
}