/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.empleat.Empleat;
import com.boatinc.persona.empleat.Habilitat;
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
            Empleat empleat1 = new Empleat("Pep", "Serra", Document.DNI, "74125896v", "C/ Major", 632478942, "pep@email.com", 1200, "14/07/1990");
            Client client1 = new Client("Xavier", "Valens", Document.DNI, "98745632x", "Carrer sol", 123456789, "xavier@email.com");
            Iot iot1 = new Iot(4, 200, true, 1234, "4444x", "Yamaha", "y23", 2, 10, 1, Proposit.REPARACIO, 20000, true);
            Reparacio reparacio1 = new Reparacio("Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", 1000, client1, iot1, Estat.PENDENT);
            Reparacio reparacio2 = new Reparacio("Sa Pobla", "18/05/2016", "20/05/2016", "Motor averiat", 1000, client1, iot1, Estat.PENDENT);
            Reparador jose = new Reparador("Joseca", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");
            Comentari comentari1 = new Comentari("18/05/2016", jose, "Va be");
            Comentari comentari2 = new Comentari("19/05/2016", jose, "Va be");
            
            reparacio1.afegirEmpleat(jose);
            jose.afegirHabilitat(Habilitat.FUSTERIA);
            reparacio1.afegirComentari(comentari1);
            reparacio2.afegirEmpleat(jose);
            reparacio2.afegirComentari(comentari2);
            iot1.afegirReparacio(reparacio1);
            iot1.afegirReparacio(reparacio2);
            System.out.println(iot1.getHistoricReparacions());
            System.out.println(reparacio1.getIdentificador());
            iot1.eliminarReparacio(reparacio1);
            //System.out.println(iot1.infoGeneral());
            System.out.println(iot1.infoDetallada());
        }catch(NoAfegitException | DataException | NoEliminatException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
