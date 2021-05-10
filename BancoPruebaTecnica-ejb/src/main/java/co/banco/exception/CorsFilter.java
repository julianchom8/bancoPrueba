/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.banco.exception;

import javax.ws.rs.ext.Provider;

/**
 *
 * @author usuario
 */
@Provider
public class CorsFilter extends Exception{

    public CorsFilter(String message) {
        super(message);
    }
    
}
