package business;

import data.GameDAO;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*List<Game> games = GameDAO.list();

        games = GameDAO.subList(0, 5);

        System.out.println(games);

        Set<Integer> years = GameDAO.getYears();
        System.out.println(years);

        System.out.println(GameDAO.getNumberPagesAllGames(5));*/

        /*System.out.println(GameDAO.myList());

        System.out.println(GameDAO.myGamesToJSON(1, 5));

        String res = GMSFacade.getMyGamesToJSON(1, 5);

        System.out.println(res);*/

        System.out.println(GMSFacade.getMyGamesToJSON(2, 5));
    }
}
