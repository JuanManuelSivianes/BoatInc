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
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Habilitat;
import com.boatinc.persona.empleat.Reparador;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;

/**
 *
 * @author Joanmi
 */
public class MainJoanmi {
    public static void main(String[] args) {
        
        try{
            Client client1 = new Client("Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com");
            Client client2 = new Client("Manel", "Ferrer Mir", Document.DNI, "22222222G", "C/ tucan nº7, Sa Pobla", 600224455, "manel@gmail.com");
            Client client3 = new Client("Ana", "Johansen", Document.NIE, "X1234567P", "C/ perla nº 1, 2c, Manacor", 600111111, "ana@gmail.com");
            Client client4 = new Client("Clara", "Wassenger", Document.PASSAPORT, "O123456", "C/ marisc, nº2, Inca", 712557744, "clara@gmail.com");
            Client client5 = new Client("Rafel", "Pol Vich", Document.DNI, "23847521G", "C/ mussol, planta baixa, Soller", 600334488, "rafel@yahoo.es");
            Client client6 = new Client("Pau", "Fernández Mas", Document.DNI, "66771144V", "C/ General Luque, nº23, 4b, Palma", 612784595, "pau@msn.es");
            Client client7 = new Client("Joan Miquel", "Fernández Cifre", Document.DNI, "21487652E", "C/ Joan Mas nº1, Vilafranca", 575232565, "joanmiquel@hotmail.com");
            
            Patro patro1 = new Patro("Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);
            Patro patro2 = new Patro("Raul", "Valls", Document.NIE, "X3245124C", "C/ Tord, nº4, escalera 2, Inca", 900114455, "raul@msn.es", "Patró embarcació bàsica", 120f);
            Patro patro3 = new Patro("Lucia", "Ferrer Sanchez", Document.DNI, "9545512422G", "C/ Faissan, nº2, 3c, Soller", 906314575, "lucia@gmail.com", "Patró embarcació de recreo", 170f);
            
            
            
            
            
            CompteCorrent com = new CompteCorrent("NUMEROIBAN");
            TargetaCredit tar = new TargetaCredit(111111111111L, 10, 2000, 221);
            Reparador pep = new Reparador("Pepet", "Riutort", Document.DNI, "22224444", "C/ coral", 902202122, "sivianes@gmail.com", 20.00f, "12/10/2014");
            
            System.out.println(pep.getHabilitats());
            pep.afegirHabilitat(Habilitat.MECANICA);
            System.out.println(pep.getHabilitats());
            pep.eliminarHabilitat(Habilitat.FIBRA_DE_VIDRE);
            
            toni.afegirFormaPagament(tar);
            toni.afegirFormaPagament(com);
            
            System.err.println(toni.getFormesPagament());
            

            
        }catch(NoAfegitException | DataException | NoEliminatException e){
            System.err.println(e.getMessage());
        }
    }
    
}
