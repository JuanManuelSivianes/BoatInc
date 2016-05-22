/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.empresa.Empresa;
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
            
            Iot iot1 = new Iot(4, 250, 200, true, 1234, "4444x", "Yamaha", "y23", 2, 10, 1, Proposit.REPARACIO, 20000, true);
            Iot iot2 = new Iot(4, 300, 400, true, 4321, "7799x", "Volvo", "v34", 2, 15, 1, Proposit.REPARACIO, 40000, true);
            Iot iot3 = new Iot(4, 400, 500, true, 5678, "8800x", "Menorqui", "m67", 2, 20, 1, Proposit.REPARACIO, 60000, true);
            
            Empresa empresa1 = new Empresa();
            
            Reparacio reparacio1 = new Reparacio(empresa1, "Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", client1, iot1, Estat.PENDENT, 1000);  
            Reparacio reparacio2 = new Reparacio(empresa1, "Sa Pobla", "21/05/2016", "24/05/2016", "Casc romput", client1, iot1, Estat.PENDENT, 2000);
            
            Reparador jose = new Reparador("Joseca", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");
            
            Comentari comentari1 = new Comentari("18/05/2016", jose, "Va be");
            Comentari comentari2 = new Comentari("19/05/2016", jose, "Va be");
            
            
            //Afegim empleat a reparacio1
            reparacio1.afegirEmpleat(jose);
            
            //Afegim habilitat al treballador
            jose.afegirHabilitat(Habilitat.FUSTERIA);
            
            //Afegim un comentari a la reparacio1
            reparacio1.afegirComentari(comentari1);
            
            //Afegim un empleat a la reparacio2
            reparacio2.afegirEmpleat(jose);
            
            //Afegim un comentari a la reparacio2
            reparacio2.afegirComentari(comentari2);
            
            //Afegim les reparacions que ha tengut iot1
            iot1.afegirReparacio(reparacio1);
            iot1.afegirReparacio(reparacio2);
            
            //Mostram les reparacions que ha tengut o estan pendents una embarcacio
            System.out.println(iot1.getHistoricReparacions());
            
            //Eliminam un reparacio de la llista
            iot1.eliminarReparacio(reparacio1);
            
            //Obtenim la informacio general de iot1
            System.out.println(iot1.infoGeneral());
            
            //Obtenim la informacio detallada de iot1
            System.out.println(iot1.infoDetallada());
            
            //Obtenim la informacio detallada de iot3
            System.out.println(iot3.infoDetallada());
            
            
            
        }catch(NoAfegitException | DataException | NoEliminatException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
