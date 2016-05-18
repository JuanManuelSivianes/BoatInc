/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;

/**
 *
 * @author Joanmi
 */
public class MainJoanmi {
    public static void main(String[] args) {
        
        try{
            Client toni = new Client("Paco", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso");
            CompteCorrent com = new CompteCorrent("NUMEROIBAN");
            TargetaCredit tar = new TargetaCredit(111111111111L, 10, 2000, 221);
            
            
            toni.afegirFormaPagament(tar);
            toni.afegirFormaPagament(com);
            
            System.err.println(toni.getFormesPagament());
            

            
        }catch(NoAfegitException e){
            System.err.println(e.getMessage());
        }
    }
    
}
