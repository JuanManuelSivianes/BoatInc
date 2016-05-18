/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Document;
import com.boatinc.persona.*;
import com.boatinc.persona.empleat.Reparador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arsenik
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Patro paco = new Patro("Paco","Anchoa",Document.DNI,"11111111E","C/ mar nº 2",902202122,"paco@gmail.com","Capitan mercante",120f);
        
        System.err.println(paco);
        
        TargetaCredit tarj1 = new TargetaCredit(123121321231231L, 10, 2004, 221);
        CompteCorrent compte = new CompteCorrent("4564564564es564546212154");
        
        System.err.println(tarj1);
        System.err.println(compte);*/
        Client toni = new Client("Paco", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso");

        Embarcacio concordia = new Embarcacio(00001, "BNX105", "opel", "Corsa", 10, 50, 20, Proposit.REPARACIO, 23.215f);
        Reparador jose;
        Reparador paco;
        try {
            jose = new Reparador("Jose", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");
            paco = new Reparador("paco", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");
            Reparacio uno = new Reparacio("Taller", "18/05/2016", "18/05/2016", "Manguitos", 23.215f, toni, concordia, Estat.INICIADA);

            Comentari coment = new Comentari("18/11/2016", jose, "He apretao to");
            Comentari coment2 = new Comentari("18/11/2016", jose, "He apretao to");

            uno.afegirEmpleat(jose);
            uno.afegirEmpleat(paco);
            
            System.out.println(uno.getEmpleats());
            
            

            uno.eliminarEmpleat(jose);

        } catch (DataException | NoAfegitException | NoEliminatException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
