/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdl;

import aa.GMS;
import aa.Game;
import aa.GameNotExistsException;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@WebService(serviceName = "GamesWSDL")
public class GamesWSDL {

    @WebMethod(operationName = "search")
    public Game search(@WebParam(name = "name") String gameName) throws PersistentException, GameNotExistsException {
        return GMS.getGMS().getGame(gameName);
    }
    
    @WebMethod(operationName = "list")
    public Collection<Game> list() throws PersistentException{
        return GMS.getGMS().getAllGames();
    }
}
