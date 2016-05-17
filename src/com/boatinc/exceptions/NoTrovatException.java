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
public class NoTrovatException extends Exception{
    public NoTrovatException(){
        
    }
    
    public NoTrovatException(String text){
        super(text);
    }
    
}
