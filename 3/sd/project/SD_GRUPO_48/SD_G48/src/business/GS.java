package business;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GS {

    public Map<String, Cliente> clientes;
    public Lock lclientes;

    public Map<String, Reserva> reservas;
    public Lock lreservas;
    public int idAtual;

    public Map<String, Produto> produtos;
    public Lock lprodutos;

    public Map<String,Leilao> leiloes;
    public Lock lleiloes;

    public Map<String, List<String>> ultimosLeiloes;
    public Lock lultimosLeiloes;

    /**
     * Construtor vazio do Gestor de Clientes.
     */
    public GS() {
        this.clientes = new HashMap<>();
        this.reservas = new HashMap<>();
        this.produtos = new HashMap<>();
        this.leiloes = new HashMap<>();
        this.ultimosLeiloes = new HashMap<>();
        this.idAtual = 0;

        this.lclientes = new ReentrantLock();
        this.lreservas = new ReentrantLock();
        this.lprodutos = new ReentrantLock();
        this.lleiloes = new ReentrantLock();
        this.lultimosLeiloes = new ReentrantLock();
    }

    /**
     * Adiciona um produto.
     * @param nome nome do produto.
     */
    public void criarProduto(String nome, float preco) throws ProdutoExisteException {
        this.lprodutos.lock(); // lock() do "leque" de produtos
        try {
            if (this.produtos.containsKey(nome)) throw new ProdutoExisteException(nome);
            this.produtos.put(nome, new Produto(nome, preco/3600f));
        } finally {
            this.lprodutos.unlock(); // unlock() do "leque" de produtos
        }
    }

    /**
     * Cria um cliente e adiciona o mesmo ao Gestor de Clientes.
     * @param email email/ ID do cliente.
     * @param password password do cliente.
     * @throws ClienteExisteException caso o ID do cliente a adicionar já existe no Gestor de Clientes.
     */
    public void criarCliente(String email, String password) throws ClienteExisteException {
        this.lclientes.lock();
        try {
            if (this.clientes.containsKey(email)) throw new ClienteExisteException(email);
            Cliente cliente = new Cliente(email, password);
            this.clientes.put(cliente.email, cliente);
        } finally {
            this.lclientes.unlock();
        }
    }

    /**
     * Indica sucesso ou insucesso de autenticação.
     * @param email email/ ID do cliente.
     * @param password password do cliente.
     * @return true caso a password coincide, false caso contrário.
     * @throws ClienteNaoExisteException caso o ID do cliente a adicionar não existe no Gestor de Clientes.
     */
    public boolean autenticar(String email, String password, PrintWriter pw) throws ClienteNaoExisteException {
        this.lclientes.lock(); // lock() da estrutura
        if (!this.clientes.containsKey(email)) {
            this.lclientes.unlock(); // unlock() da estrutura caso seja excepção
            throw new ClienteNaoExisteException(email);
        }
        Cliente cliente = this.clientes.get(email);
        cliente.l.lock(); // lock() do cliente
        this.lclientes.unlock(); // unlock() da estrutura
        boolean res = cliente.password.equals(password);
        if (res) cliente.pw = pw; // atualizamos o PrintWriter mais recente do cliente
        cliente.l.unlock(); // unlock() do cliente
        return res;
    }

    /**
     * Indica o saldo em dívida do cliente.
     * @param email email/ ID do cliente.
     * @throws ClienteNaoExisteException caso o ID do cliente a adicionar não existe no Gestor de Clientes.
     */
    public float consulta(String email) throws ClienteNaoExisteException,ReservaNaoExisteException {
        float res;
        this.lclientes.lock(); // lock() da estrutura
        if (!this.clientes.containsKey(email)) {
            this.lclientes.unlock(); // unlock() da estrutura caso seja excepção
            throw new ClienteNaoExisteException(email);
        }
        Cliente cliente = this.clientes.get(email);
        cliente.l.lock(); // lock() do cliente
        this.lclientes.unlock(); // unlock() da estrutura

        Set<Reserva> reservasOrdenadas = new TreeSet<>();
        this.lreservas.lock();
        for(String idReserva : cliente.reservas) {
            if (!this.reservas.containsKey(idReserva)){
                this.lreservas.unlock();
                throw new ReservaNaoExisteException(idReserva);
            }
            Reserva r = this.reservas.get(idReserva);
            reservasOrdenadas.add(r);
        }

        //  fazer o lock ordenado das reservas
        for(Reserva reserva : reservasOrdenadas) reserva.l.lock();

        this.lreservas.unlock();    //  unlock da estrutura das reservas

        //  fazer o unlock ordenado das reservas
        for(Reserva reserva : reservasOrdenadas) {
            cliente.saldo += reserva.total();
            reserva.l.unlock();
        }

        res = cliente.saldo;    //  retorno
        cliente.l.unlock(); //  unlock do cliente
        return res;
    }

    public String reservarPedido(String chaveProduto, String chaveCliente) throws ProdutoNaoExisteException, ReservaExisteException, ClienteNaoExisteException, ReservaNaoExisteException {

        // ESTRUTURA DOS PRODUTOS -------------------------------------------------------------------------------------------------------

        this.lprodutos.lock(); // lock() dos produtos
        if (!this.produtos.containsKey(chaveProduto)) {
            this.lprodutos.unlock();
            throw new ProdutoNaoExisteException(chaveProduto);
        }

        Produto produto = this.produtos.get(chaveProduto);
        produto.l.lock(); // lock() do produto
        this.lprodutos.unlock(); // unlock() dos produtos

        // ESTRUTURA DAS RESERVAS -------------------------------------------------------------------------------------------------------

        this.lreservas.lock(); // lock() das reservas
        /** Provavelmente nunca vai ocorrer, no entanto por motivos de segurança garantimos que o programa está "à prova de bala"*/
        if (this.reservas.containsKey(idAtual)) {
            produto.l.unlock();
            this.lreservas.unlock();
            throw new ReservaExisteException(String.valueOf(idAtual));
        }

        /** Como sabes que a reserva vai ser atribuida, podes efetuar aqui pq assim podemos libertar o lock mais cedo */
        Reserva reserva = new Reserva(String.valueOf(idAtual), true, chaveCliente, produto.nome, produto.preco);
        reserva.l.lock();
        this.reservas.put(reserva.id, reserva);
        idAtual++;
        this.lreservas.unlock(); // unnlock() das reservas

        // ESTRUTURA DOS CLIENTES -------------------------------------------------------------------------------------------------------

        this.lclientes.lock();
        if (!this.clientes.containsKey(chaveCliente)) {
            produto.l.unlock();
            reserva.l.unlock(); // unlock() da reserva
            this.lclientes.unlock();
            throw new ClienteNaoExisteException(chaveCliente);
        }

        Cliente cliente = this.clientes.get(chaveCliente);
        cliente.l.lock();
        this.lclientes.unlock();
        cliente.reservas.add(reserva.id);
        cliente.l.unlock();

        // VERIFICACAO SE EXISTE RESERVA EM LEILAO --------------------------------------------------------------------------------------

        boolean vaiEsperar = true;

        // System.err.println(this.ultimosLeiloes);

        if (produto.ocupados == Produto.NUMERO_MAX_PRODUTOS) { // só vai tentar "roubar" um leilão quando tiver cheio
            this.lultimosLeiloes.lock();
            if (this.ultimosLeiloes.containsKey(produto.nome)) { // singifica que existe um leilao
                List<String> tmp = this.ultimosLeiloes.get(produto.nome);
                String id = tmp.get(0); // id da reserva do leilao (à mais tempo)
                tmp.remove(0); // remove dos ultimos leiloes
                if (tmp.isEmpty()) this.ultimosLeiloes.remove(produto.nome);
                this.lultimosLeiloes.unlock();

                this.lreservas.lock(); // lock() das reservas
                /** Provavelmente nunca vai ocorrer, no entanto por motivos de segurança garantimos que o programa está "à prova de bala"*/
                if (!this.reservas.containsKey(id)) {
                    produto.l.unlock();
                    reserva.l.unlock(); // unlock() da reserva
                    this.lreservas.unlock();
                    throw new ReservaNaoExisteException(id);
                }
                Reserva r = this.reservas.get(id);
                r.l.lock();
                String clienteId = r.clienteId;
                float valor = r.total();
                r.l.unlock();
                this.reservas.remove(r.id);
                this.lreservas.unlock(); // unlock() das reservas

                this.lclientes.lock();
                /** Provavelmente nunca vai ocorrer, no entanto por motivos de segurança garantimos que o programa está "à prova de bala"*/
                if (!this.clientes.containsKey(chaveCliente)) {
                    produto.l.unlock();
                    reserva.l.unlock(); // unlock() da reserva
                    this.lclientes.unlock();
                    throw new ClienteNaoExisteException(chaveCliente);
                }
                cliente = this.clientes.get(clienteId);
                cliente.l.lock();
                this.lclientes.unlock();
                cliente.saldo += valor;
                cliente.reservas.remove(id);
                cliente.pw.println("y_"+id);
                cliente.pw.flush();
                cliente.l.unlock();

                vaiEsperar = false;
            } else this.lultimosLeiloes.unlock();
        }

        if(vaiEsperar) produto.reservar(); // pode ficar à espera...
        produto.l.unlock(); // unlock() do produto

        /** apenas para corrigir o tempo de contabilização enquanto esperou pela atribuição do servidor */
        reserva.inicio = LocalDateTime.now();
        String res = reserva.id;
        reserva.l.unlock(); // unlock() da reserva

        return res;
    }

    /**
     * Liberta a reserva inidicada.
     * Remove a reserva da estrutura.
     * Atualiza o valor em dívida do cliente e remove o identificador da reserva da lista de reservas do cliente.
     * Liberta o produto (servidor) indicado.
     * @param chaveReserva identificador da reserva.
     * @param clienteId identificador do cliente.
     * @throws ReservaNaoExisteException caso o id da reserva não exista
     * @throws ProdutoNaoExisteException caso o id do produto associado a reserva não exista
     * @throws ClienteNaoExisteException caso o id do cliente não exista
     * @throws ReservaNaoCorrespondente caso a reserva não seja do cliente indicado
     */
    public void libertarReserva(String chaveReserva, String clienteId) throws ReservaNaoExisteException, ProdutoNaoExisteException, ClienteNaoExisteException, ReservaNaoCorrespondente, UltimoLeilaoNaoSincronizadoException {

        boolean isLeilao = false;

        // ESTRUTURA DAS RESERVAS -------------------------------------------------------------------------------------------------------

        this.lreservas.lock(); // lock() das reservas
         if (!this.reservas.containsKey(chaveReserva)) {
             this.lreservas.unlock();
             throw new ReservaNaoExisteException(chaveReserva);
         }

         Reserva reserva = this.reservas.get(chaveReserva);
         reserva.l.lock(); // lock() da reserva

         /** Caso entre nesta condição, não vale a pena continuar o método e "liberta" o que previamente "adquiriu" */
         if (!clienteId.equals(reserva.clienteId)) {
             this.lreservas.unlock();
             reserva.l.unlock();
             throw new ReservaNaoCorrespondente(chaveReserva);
         }

         if (reserva.tipo == false) isLeilao = true;

         /**
          Copiar os valores para poder usar mais tarde, assim podemos "libertar" a estrutura da reserva mais cedo
          NOTA: apenas podemos fazer isto (cópia temporária) e MANTER a sincronização de dados uma vez que
          a reserva vai ser removida imediatamente neste método
          */
         float valor = reserva.total();
         String servidorId = reserva.servidorId;
         reserva.l.unlock();

         this.reservas.remove(reserva.id);
         this.lreservas.unlock();

        // ESTRUTURA DOS ULTIMOS LEILOES -------------------------------------------------------------------------------------------------------

         if (isLeilao) {
             this.lultimosLeiloes.lock();
             if (this.ultimosLeiloes.containsKey(servidorId)) { // para aquele servidor existem leiloes
                 List<String> tmp = this.ultimosLeiloes.get(servidorId);
                 tmp.remove(chaveReserva);
                 if (tmp.isEmpty()) this.ultimosLeiloes.remove(servidorId);
             } else {
                 this.lultimosLeiloes.unlock();
                 throw new UltimoLeilaoNaoSincronizadoException(chaveReserva);
             }
             this.lultimosLeiloes.unlock();

             // System.err.println(this.ultimosLeiloes);
         }

        // ESTRUTURA DOS CLIENTES -------------------------------------------------------------------------------------------------------

         this.lclientes.lock(); // lock() dos clientes
         /** Provavelmente nunca vai ocorrer, no entanto por motivos de segurança garantimos que o programa está "à prova de bala"*/
         if (!this.clientes.containsKey(clienteId)) {
             this.lclientes.unlock();
             throw new ClienteNaoExisteException(clienteId);
         }

         Cliente cliente = this.clientes.get(clienteId);

         cliente.l.lock(); // lock() do cliente
         this.lclientes.unlock(); // unlock() dos clientes
         cliente.reservas.remove(chaveReserva);
         cliente.saldo += valor;
         cliente.l.unlock(); // unlock() do cliente

        // ESTRUTURA DOS PRODUTOS -------------------------------------------------------------------------------------------------------

        this.lprodutos.lock(); // lock() dos produtos


         if (!this.produtos.containsKey(servidorId)) {
             this.lprodutos.unlock();
             throw new ProdutoNaoExisteException(servidorId);
         }


         Produto produto = this.produtos.get(servidorId);
         produto.l.lock(); // lock() do produto


         this.lprodutos.unlock(); // unlock() dos produtos

         produto.libertar();
         produto.l.unlock(); // unlock() do produto
    }

    public boolean PropostaLeilao(String idCliente, String chaveProduto, float valor) throws ProdutoNaoExisteException, LeilaoTerminouException {
        boolean res;

        this.lleiloes.lock();   //  lock da estrutura do leilão
        if(!this.leiloes.containsKey(chaveProduto)) {   //  verificar se o leilão procurado já existe

            /** Cria o leilão agora para poder libertar a estrutura mais cedo, depois atualizo o valor inical */
            Leilao leilao = new Leilao(chaveProduto, 0f, idCliente);
            leilao.l.lock();
            this.leiloes.put(chaveProduto, leilao); //  adicionar este novo leilão à estrutura dos leilões
            this.lleiloes.unlock();

            this.lprodutos.lock();  //  lock da estrutura dos produtos
            if(!this.produtos.containsKey(chaveProduto)) {  //  verifica-se se o produto existe
                leilao.l.unlock();
                this.lprodutos.unlock();    //  unlock dos produtos
                throw new ProdutoNaoExisteException();
            }

            Produto p = this.produtos.get(chaveProduto);    //  buscar a info do produto
            p.l.lock(); //  lock do produto
            this.lprodutos.unlock();    //  unlock da estrutura dos produtos
            p.reservar();   //  verificar se a reserva é possível, ou seja, se existem servidores livres
            p.l.unlock();

            leilao.valorInicial = p.preco * 0.5f;
            try {
                res = leilao.proposta(idCliente,valor);   //  fazer a proposta ao leilão
            } catch (LeilaoTerminouException e) {
                throw e;
            } finally {
                leilao.l.unlock();
            }

            new GestorLeilao(this, chaveProduto).start(); // inicia o business.Leilao

        } else {

            Leilao leilao = this.leiloes.get(chaveProduto);  //  buscar a informação do leilão que já existe
            leilao.l.lock(); //  lock do leilão
            this.lleiloes.unlock(); //  unlock de toda a estrutura que guarda leilões
            res = leilao.proposta(idCliente, valor);   //  fazer proposta para o leilão
            leilao.l.unlock();   //  unlock do leilão

        }
        return res; //  retorna true se a proposta foi aceitada, false caso contrário
    }

    public String getTodosProdutos() {
        StringBuilder sb = new StringBuilder("");
        this.lprodutos.lock();                   //lock dos produtos
        for(Produto p : produtos.values()){
            p.l.lock();                          //lock do produto
            sb.append("[nome do servidor = "+p.nome).append("] ");
            p.l.unlock();                        //unlock do produto
        }
        this.lprodutos.unlock();                 //unlock dos produtos
        sb.deleteCharAt((sb.length() - 1));
        return sb.toString();
    }

    /**
     * Devolve os identificadores de todas as reservas atuais do cliente.
     * @param idCliente identificador do cliente
     * @return
     * @throws ClienteNaoExisteException
     * @throws ReservaNaoExisteException
     */
    public String getReservasCliente(String idCliente) throws ClienteNaoExisteException, ReservaNaoExisteException {

        StringBuilder sb = new StringBuilder("");

        this.lclientes.lock();
        if (!this.clientes.containsKey(idCliente)) {
            this.lclientes.unlock();
            throw new ClienteNaoExisteException(idCliente);
        }
        Cliente cliente = this.clientes.get(idCliente);
        cliente.l.lock();
        this.lclientes.unlock();

        Set<Reserva> reservasOrdenadas = new TreeSet<>();

        this.lreservas.lock();
        for(String id: cliente.reservas){
            if (!this.reservas.containsKey(id)) {
                cliente.l.unlock();
                this.lreservas.unlock();
                throw new ReservaNaoExisteException(id);
            }
            reservasOrdenadas.add(this.reservas.get(id));   //  adiciona de forma ordenada pelo id
        }

        for(Reserva reserva : reservasOrdenadas)
            reserva.l.lock();

        this.lreservas.unlock();    //  unlock da estrutura das reservas, após das reservas que me interessam

        for(Reserva reserva : reservasOrdenadas)sb.append("[id da reserva = "+reserva.id).append(", nome do servidor = ").append(reserva.servidorId).append("] ");

        for(Reserva reserva : reservasOrdenadas)reserva.l.unlock(); //  unlock das reservas de forma ordenada

        cliente.l.unlock();

        //  este equals é para evitar se delete quando o sb está vazio, pois dava erro!
        if(!sb.toString().equals("")) sb.deleteCharAt((sb.length())-1);

        return sb.toString();
    }

    /**
     * Devolve o Gestor de Sistema em formato String.
     * @return retorna o business.GS em formato String.
     */
    @Override
    public String toString() {
        return "GS{" +
                "clientes=" + clientes +
                ", lclientes=" + lclientes +
                ", reservas=" + reservas +
                ", lreservas=" + lreservas +
                ", idAtual=" + idAtual +
                ", produtos=" + produtos +
                ", lprodutos=" + lprodutos +
                ", leiloes=" + leiloes +
                ", lleiloes=" + lleiloes +
                '}';
    }
}