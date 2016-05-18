/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.empleat.Reparador;

/**
 *
 * @author Xavier
 */
public class XaviMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        try{
            Embarcacio embarcacio1 = new Embarcacio(1111, "1992x", "Yamaha", "Y24", 4, 10, 2, Proposit.LLOGUER, 14000);
            Client client1 = new Client("Xavier", "Valens", Document.DNI, "98745632x", "Carrer sol", 123456789, "xavier@email.com");
            Reparacio reparacio1 = new Reparacio("Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", 1000, client1, embarcacio1, Estat.PENDENT);
            Reparador jose = new Reparador("Joseca", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");
            Comentari comentari1 = new Comentari("18/05/2016", jose, "Va be");
            reparacio1.afegirComentari(comentari1);
            embarcacio1.afegirReparacio(reparacio1);
            System.out.println(embarcacio1.getHistoricReparacions());
        }catch(NoAfegitException ex){
            System.out.println("No sa afegit");
        }
        
    }
    
}
