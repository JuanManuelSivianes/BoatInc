/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.persona.Document;
import com.boatinc.persona.*;

/**
 *
 * @author Arsenik
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Patro paco = new Patro("Paco","Anchoa",Document.DNI,"11111111E","C/ mar nº 2",902202122,"paco@gmail.com","Capitan mercante",120f);
        
        System.err.println(paco);
    }
    
}
