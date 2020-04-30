/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uminho.di.aa;

/**
 *
 * @author josepereira
 */
public class UserNotExistsException extends Exception{
    public UserNotExistsException(){
        super();
    }
    
    public UserNotExistsException(String msg){
        super(msg);
    }
}
