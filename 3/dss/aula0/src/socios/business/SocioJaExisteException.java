/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socios.business;

/**
 *
 * @author josepereira
 */
public class SocioJaExisteException extends Exception{
    public SocioJaExisteException(){
        super();
    }
    
    public SocioJaExisteException(String msg){
        super(msg);
    }
}
