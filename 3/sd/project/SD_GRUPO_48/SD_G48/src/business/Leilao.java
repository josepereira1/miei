package business;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leilao {

    private final static long MILLI = 1;
    private final static long SEGUNDO = 1000*MILLI;
    public final static long TEMPO_LEILAO = 5*SEGUNDO;

    LocalDateTime inicio;
    LocalDateTime fim;
    String nomeProduto;
    float valorInicial;
    float maiorProposta;
    String idCliente;

    Lock l;

    /**
     * Construtor parametrizado.
     * @param nomeProduto nome do business.Produto (servidor).
     * @param valorInicial valor inicial/mínimo do leilão.
     * @param idCliente id do último cliente com maior proposta.
     */
    public Leilao(String nomeProduto, float valorInicial, String idCliente) {

        this.inicio = LocalDateTime.now();
        this.fim =  LocalDateTime.now().plus(TEMPO_LEILAO, ChronoUnit.MILLIS);
        this.nomeProduto = nomeProduto;
        this.valorInicial = valorInicial;
        this.maiorProposta = valorInicial;
        this.idCliente = idCliente;

        this.l = new ReentrantLock();
    }

    /**
     * Faz uma proposta de um valor a este business.Produto (servidor).
     * @param idCliente id do cliente.
     * @param valor valor da proposta.
     * @return retorn true se conseguiu uma melhor proposta, false caso contrário.
     * @throws LeilaoTerminouException exception caso o leilão já tenha terminado.
     */
    public boolean proposta(String idCliente, float valor) throws LeilaoTerminouException{
        if(LocalDateTime.now().isEqual(fim) || LocalDateTime.now().isAfter(fim)) throw new LeilaoTerminouException();

        if(valor > maiorProposta){
            maiorProposta = valor;
            this.idCliente = idCliente;

            return true;    //  sucesso
        }
        return false;   //  insucesso
    }

    /**
     * Coloca numa String toda a informação deste objeto.
     * @return retorna uma String com toda a informação deste objeto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("business.Leilao={");
        sb.append("inicio=").append(inicio);
        sb.append(";fim=").append(fim);
        sb.append(";nomeProduto=").append(nomeProduto);
        sb.append(";valorInicial=").append(valorInicial);
        sb.append(";maiorProposta=").append(maiorProposta);
        sb.append(";idCliente=").append(idCliente);
        sb.append(";l=").append(l).append("};");
        return sb.toString();
    }
}
