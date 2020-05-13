/*
 * GameDAO
 * ruicouto in 10/abr/2017
 */
package data;

import business.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author ruicouto (IJ project: jfc)
 */
public class GameDAO {
    List<Game> allGames = list();
    List<Game> myGames = myList();
    /**
     * Data is currently mocked
     *
     * @return
     */
    public static List<Game> list() {
        List<Game> r = new ArrayList<>();
        r.add(new Game(1, "Tetris", 1989, 10, "Tetris é um jogo electrônico muito popular, desenvolvido por Alexey Pajitnov, Dmitry Pavlovsky e Vadim Gerasimov, e lançado em Junho de 1984. Pajitnov e Pavlovsky eram engenheiros informáticos no Centro de Computadores da Academia Russa das Ciências e Vadim era um aluno com 16 anos.", "Megadrive"));
        r.add(new Game(2, "GTA V", 2013, 60, "Grand Theft Auto V é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PC"));
        r.add(new Game(3, "Assetto Corsa", 2014, 30, "Assetto Corsa é um jogo eletrônico de simulação de corrida desenvolvido pela italiana Kunos Simulazioni. Ele foi projetado com ênfase em uma experiência de corrida realista, com suporte para personalização e modabilidade extensivas. O jogo foi lançado para Microsoft Windows pela primeira vez através do programa Steam Early Access em 8 de novembro de 2013 e oficialmente saiu do Early Access como versão final em 19 de dezembro de 2014. O jogo foi lançado para consoles PlayStation 4 e Xbox One em 26 e 30 de agosto de 2016 na Europa e América do Norte, respectivamente.", "PC"));
        r.add(new Game(4, "Fallout 4", 2014, 30, "Fallout 4 é um jogo eletrônico do gênero RPG de ação ambientado em mundo aberto produzido pela Bethesda Game Studios, sendo o quinto título principal da série Fallout. O game foi lançado para Microsoft Windows, PlayStation 4 e Xbox One no dia 10 de Novembro de 2015 pela Bethesda Softworks.", "PC"));
        r.add(new Game(5, "Breath of The Wild", 2017, 60, "The Legend of Zelda: Breath of the Wild é um jogo eletrônico de ação-aventura desenvolvido pela Nintendo Entertainment Planning & Development e publicado pela Nintendo. É o décimo nono título da série The Legend of Zelda e foi lançado mundialmente para Wii U e Nintendo Switch em 3 de março de 2017.", "PC"));
        r.add(new Game(6, "GTA 1", 2000, 10, "Grand Theft Auto 1 é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PS2"));
        r.add(new Game(7, "GTA 2", 2003, 15, "Grand Theft Auto 2 é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PS3"));
        r.add(new Game(8, "GTA 3", 2005, 20, "Grand Theft Auto 3 é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PS3"));
        r.add(new Game(9, "GTA Vice City", 2000, 15, "Grand Theft Auto Vice city é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PC"));
        r.add(new Game(10, "PUBG", 2018, 30, "PlayerUnknown's Battlegrounds é um jogo eletrônico multiplayer desenvolvido pela PUBG Corp., subsidiária da produtora coreana Bluehole, utilizando o motor de jogo Unreal Engine 4.", "PC"));
        r.add(new Game(11, "Fortnite", 2017, 10, "Fortnite é um jogo eletrônico multijogador online revelado originalmente em 2012, desenvolvido pela Epic Games e lançado como diferentes modos de jogo que compartilham a mesma jogabilidade e motor gráfico de jogo.", "PC"));
        r.add(new Game(12, "PAYDAY", 2012, 15, "Payday 2 é um videogame cooperativo de tiro em primeira pessoa desenvolvido pela Overkill Software e publicado pela 505 Games. O jogo é uma continuação de Payday: The Heist de 2011. Foi lançado em agosto de 2013 para Windows, PlayStation 3 e Xbox 360.", "PC"));
        return r;
    }

    //  lista dos jogos de um utilizador, estática, ou seja, igual para todos
    public static List<Game> myList(){
        List<Game> r = new ArrayList<>();
        r.add(new Game(1, "Tetris", 1989, 10, "Tetris é um jogo electrônico muito popular, desenvolvido por Alexey Pajitnov, Dmitry Pavlovsky e Vadim Gerasimov, e lançado em Junho de 1984. Pajitnov e Pavlovsky eram engenheiros informáticos no Centro de Computadores da Academia Russa das Ciências e Vadim era um aluno com 16 anos.", "Megadrive"));
        r.add(new Game(2, "GTA V", 2013, 60, "Grand Theft Auto V é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PC"));
        r.add(new Game(3, "Assetto Corsa", 2014, 30, "Assetto Corsa é um jogo eletrônico de simulação de corrida desenvolvido pela italiana Kunos Simulazioni. Ele foi projetado com ênfase em uma experiência de corrida realista, com suporte para personalização e modabilidade extensivas. O jogo foi lançado para Microsoft Windows pela primeira vez através do programa Steam Early Access em 8 de novembro de 2013 e oficialmente saiu do Early Access como versão final em 19 de dezembro de 2014. O jogo foi lançado para consoles PlayStation 4 e Xbox One em 26 e 30 de agosto de 2016 na Europa e América do Norte, respectivamente.", "PC"));
        r.add(new Game(4, "Fallout 4", 2014, 30, "Fallout 4 é um jogo eletrônico do gênero RPG de ação ambientado em mundo aberto produzido pela Bethesda Game Studios, sendo o quinto título principal da série Fallout. O game foi lançado para Microsoft Windows, PlayStation 4 e Xbox One no dia 10 de Novembro de 2015 pela Bethesda Softworks.", "PC"));
        r.add(new Game(9, "GTA Vice City", 2000, 15, "Grand Theft Auto Vice city é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PC"));
        r.add(new Game(10, "PUBG", 2018, 30, "PlayerUnknown's Battlegrounds é um jogo eletrônico multiplayer desenvolvido pela PUBG Corp., subsidiária da produtora coreana Bluehole, utilizando o motor de jogo Unreal Engine 4.", "PC"));
        r.add(new Game(8, "GTA 3", 2005, 20, "Grand Theft Auto 3 é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto e foi lançado originalmente em 17 de setembro de 2013 para PlayStation 3 e Xbox 360, com remasterizações lançadas em 18 de novembro de 2014 para PlayStation 4 e Xbox One, e em 14 de abril de 2015 para Microsoft Windows. O jogo se passa no estado ficcional de San Andreas, com a história da campanha um jogador seguindo três criminosos e seus esforços para realizarem assaltos sob a pressão de uma agência governamental. O mundo aberto permite que os jogadores naveguem livremente pelas áreas rurais e urbanas de San Andreas.", "PS3"));

        return r;
    }

    public static Game getGame(String name){
        for(Game g : list())
            if(g.getName().equals(name))return g;

            return null;
    }

    //  aqui aproveitamos o facto de a estrutura Set ordenar e remover repetidos
    public static Set<Integer> getYears() {
        Set<Integer> years = new TreeSet<>();
        for(Game g : list())years.add(g.getYear());
        return years;
    }

    //  aqui aproveitamos o facto de a estrutura Set ordenar e remover repetidos
    public static Set<String> getPlatforms(){
        Set<String> platforms = new TreeSet<>();
        for(Game g : list())platforms.add(g.getPlatform());
        return platforms;
    }

    /**
     * Determina a lista de jogos de uma determinada página, consoante o número de jogos por página.
     * @param page número da página, começando, em 1 até ao número máximo possível
     * @param pageSize número de jogos apresentados por página.
     * @return retorna a lista de jogos que devem ser apresentados numa determinada página.
     */
    public static List<Game> subList(List<Game> games, int page, int pageSize) {
        int start = Math.min(page * pageSize, games.size());
        int end = Math.min(start + pageSize, games.size());
        return games.subList(start, end);
    }

    /**
     * Cálcula o número de páginas necessárias na apresentação dos jogos, dado o número de jogos por página.
     * @param pageSize número de jogos por página
     * @return retorna o número de páginas necessárias com base no número de jogos existentes, bem como o número de jogos por página.
     */
    public static int getNumberPagesAllGames(int pageSize){
        float res = (float)list().size() / (float)pageSize;
        if(res == (int)res) return (int) res;
        else return (int) (res+1);
    }

    public static int getNumberPagesMyGames(int pageSize){
        float res = (float)myList().size() / (float)pageSize;
        if(res == (int)res) return (int) res;
        else return (int) (res+1);
    }

    //  start on page 1 to oo
    public static String allGamesToJSON(int page, int pageSize){
        return listGamesJson(subList(list(), page - 1, pageSize));
    }

    public static String myGamesToJSON(int page, int pageSize){
        return listGamesJson(subList(myList(), page - 1, pageSize));
    }

    public static String toJSON(){
        return listGamesJson(list());
    }

    private static String listGamesJson(List<Game> games) {
        StringBuilder json = new StringBuilder("[");
        for (Game g : games) {
            json.append(g.toJson()).append(",");
        }
        if (json.length() != 1) json.deleteCharAt(json.length() - 1); // remover a última vírgula
        json.append("]");
        return json.toString();}
}
