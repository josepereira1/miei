/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceclient;

import java.util.List;
import wsdl.Game;
import wsdl.GameNotExistsException_Exception;
import wsdl.GamesWSDL;
import wsdl.GamesWSDL_Service;
import wsdl.PersistentException_Exception;

/**
 *
 * @author Ricardo Petronilho
 */
public class GamesWebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GamesWSDL gameWS = new GamesWSDL_Service().getGamesWSDLPort();
        
        try {
            Game game = gameWS.search("GTA V");
            System.out.println(game);
        } catch (GameNotExistsException_Exception e) {
            e.printStackTrace();
        } catch (PersistentException_Exception e) {
            e.printStackTrace();
        }
        
        try {
            List<Game> games = gameWS.list();
            System.out.println(games);
        } catch (PersistentException_Exception e) {
            e.printStackTrace();
        }
    }
    
}
