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
public class PlatformNotExistsException extends Exception{
    public PlatformNotExistsException(){
        super();
    }
    
    public PlatformNotExistsException(String msg){
        super(msg);
    }
}
