/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.exceptions;

/**
 *
 * @author Joanmi
 */
public class NoAfegitException extends Exception{
    public NoAfegitException(){
        
    }
    
    public NoAfegitException(String text){
        super(text);
    }
    
}
