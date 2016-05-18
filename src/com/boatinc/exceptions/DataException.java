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
public class DataException extends Exception{
    public DataException(){
        
    }
    
    public DataException(String text){
        super(text);
    }
    
}
