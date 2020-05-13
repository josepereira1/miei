/*
 * GMSFacade
 * ruicouto in 10/abr/2017
 */
package business;

import data.GameDAO;
import data.UserDAO;

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

    public static List<Game> getAllGamesPage(int page, int sizeOfPage){
        return GameDAO.subList(GameDAO.list(),page, sizeOfPage);
    }

    //  JSON -----------------------------------------------------------------
    public static int numberOfPagesAllGames(int pageSize){
        int pages = GameDAO.getNumberPagesAllGames(pageSize);
        if(pages <= 1)return 0; //  não vale apena colocar o botão quando temos uma página.
        else return pages;
    }

    public static int numberOfPagesMyGames(int pageSize){
        int pages = GameDAO.getNumberPagesMyGames(pageSize);
        if(pages <= 1)return 0; //  não vale apena colocar o botão quando temos uma página.
        else return pages;
    }

    public static String getAllGamesToJSON(int page, int pageSize){
        return GameDAO.allGamesToJSON(page, pageSize);
    }

    public static String getMyGamesToJSON(int page, int pageSize){
        return GameDAO.myGamesToJSON(page,pageSize);
    }

    public static Game getGame(String name){
        return GameDAO.getGame(name);
    }

    public static boolean login(String username, String password){
        UserDAO userDAO = new UserDAO();
        return userDAO.login(username, password);
    }
}
