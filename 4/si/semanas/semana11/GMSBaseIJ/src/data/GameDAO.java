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
    /**
     * Data is currently mocked
     *
     * @return
     */
    public static List<Game> list() {
        List<Game> r = new ArrayList<>();
        r.add(new Game(1, "Tetris", 1989, 10, "", "Megadrive"));
        r.add(new Game(2, "GTA V", 2013, 60, "", "PC"));
        r.add(new Game(3, "Assetto Corsa", 2014, 30, "", "PC"));
        r.add(new Game(4, "Fallout 4", 2014, 30, "", "PC"));
        r.add(new Game(5, "Breath of The Wild", 2017, 60, "", "PC"));
        r.add(new Game(6, "GTA 1", 2000, 10, "", "PS2"));
        r.add(new Game(7, "GTA 2", 2003, 15, "", "PS3"));
        r.add(new Game(8, "GTA 3", 2005, 20, "", "PS3"));
        r.add(new Game(9, "GTA Vice City", 2000, 15, "", "PC"));
        r.add(new Game(10, "PUBG", 2018, 30, "", "PC"));
        r.add(new Game(11, "Fortnite", 2017, 10, "", "PC"));
        r.add(new Game(12, "PAYDAY", 2012, 15, "", "PC"));
        return r;
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
    public static List<Game> subList(int page, int pageSize) {
        int start = Math.min(page * pageSize, list().size());
        int end = Math.min(start + pageSize, list().size());
        return list().subList(start, end);
    }

    /**
     * Cálcula o número de páginas necessárias na apresentação dos jogos, dado o número de jogos por página.
     * @param pageSize número de jogos por página
     * @return retorna o número de páginas necessárias com base no número de jogos existentes, bem como o número de jogos por página.
     */
    public static int getNumberPages(int pageSize){
        float res = (float)list().size() / (float)pageSize;
        if(res == (int)res) return (int) res;
        else return (int) (res+1);
    }
}
