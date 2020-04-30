/*
 * GMSFacade
 * ruicouto in 10/abr/2017
 */
package business;

import data.GameDAO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 *
 * @author ruicouto  (IJ project: jfc)
 */
public class GMSFacade {
    public static List<Game> listGames() {
        List<Game> games = GameDAO.list();
        return games;
    }

    public static List<Game> listGames(int year) {
        List<Game> games = GameDAO.list().stream()
                .filter(g -> g.getYear() == year)
                .collect(Collectors.toList());
        return games;
    }


    public static Set<Integer> getYears() {
        return GameDAO.getYears();
    }

    public static List<Game> getGamesOfPage(int page, int sizeOfPage){
        return GameDAO.subList(page, sizeOfPage);
    }

    public static int numberOfPages(int pageSize){
        return GameDAO.getNumberPages(pageSize);
    }
}
