package business;

import data.GameDAO;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Game> games = GameDAO.list();

        games = GameDAO.subList(0, 5);

        System.out.println(games);

        Set<Integer> years = GameDAO.getYears();
        System.out.println(years);

        System.out.println(GameDAO.getNumberPages(5));
    }
}
