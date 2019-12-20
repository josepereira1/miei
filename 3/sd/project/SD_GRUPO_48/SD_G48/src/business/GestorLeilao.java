package business;

import java.util.ArrayList;
import java.util.List;

public class GestorLeilao extends Thread {

    private GS gs;
    private String chaveLeilao;

    public GestorLeilao(GS gs, String chaveLeilao) {
        this.gs = gs;
        this.chaveLeilao = chaveLeilao;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(Leilao.TEMPO_LEILAO); // adormece a THREAD
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ESTRUTURA DOS LEILOES -------------------------------------------------------------------------------------------------------

        gs.lleiloes.lock(); // lock() dos leiloes

        /** Garante que o leilao em causa existe */
        if (!gs.leiloes.containsKey(this.chaveLeilao)) {
            gs.lleiloes.unlock();
            return;
        }

        Leilao leilao = gs.leiloes.get(this.chaveLeilao);
        leilao.l.lock(); // lock() do leilao
        /**
         Copiar os valores para poder usar mais tarde, assim podemos "libertar" a estrutura dos leilões mais cedo
         NOTA: apenas podemos fazer isto (cópia temporária) e MANTER a sincronização de dados uma vez que
         a reserva vai ser removida imediatamente neste método
         */
        String clienteId = leilao.idCliente;
        String nomeProduto = leilao.nomeProduto;
        float maiorProposta = leilao.maiorProposta;
        leilao.l.unlock();
        gs.leiloes.remove(leilao.nomeProduto);
        gs.lleiloes.unlock(); // unlock() dos leiloes

        // ESTRUTURA DOS RESERVAS -------------------------------------------------------------------------------------------------------

        gs.lreservas.lock(); // lock() das reservas
        String reservaId = Integer.toString(gs.idAtual);
        Reserva reserva = new Reserva(reservaId,false, clienteId, nomeProduto, maiorProposta / 3600);
        gs.idAtual++;
        gs.reservas.put(reserva.id, reserva);
        gs.lreservas.unlock(); // unlock() das reservas

        // ESTRUTURA DOS ULTIMOS LEILOES -------------------------------------------------------------------------------------------------------

        gs.lultimosLeiloes.lock();
        if (gs.ultimosLeiloes.containsKey(nomeProduto)) gs.ultimosLeiloes.get(nomeProduto).add(reservaId);
        else {
            List<String> tmp = new ArrayList<>();
            tmp.add(reservaId);
            gs.ultimosLeiloes.put(nomeProduto, tmp);
        }
        gs.lultimosLeiloes.unlock();

        // ESTRUTURA DOS CLIENTES -------------------------------------------------------------------------------------------------------

        gs.lclientes.lock();
        if (!gs.clientes.containsKey(clienteId)) {
            gs.lclientes.unlock();
            return;
        }

        Cliente cliente = gs.clientes.get(clienteId);
        cliente.l.lock();
        gs.lclientes.unlock();
        cliente.reservas.add(reservaId);
        cliente.pw.println("t_");
        cliente.pw.flush();
        cliente.l.unlock(); // unlock() do cliente

        // System.err.println(gs.ultimosLeiloes);
    }
}