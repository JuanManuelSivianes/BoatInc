/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import static com.boatinc.operacio.Estat.PENDENT;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Document;
import com.boatinc.persona.*;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;

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
        
        TargetaCredit tarj1 = new TargetaCredit(123121321231231L, 10, 2004, 221);
        CompteCorrent compte = new CompteCorrent("4564564564es564546212154");
        
        System.err.println(tarj1);
        System.err.println(compte);
  
    }
    
}
