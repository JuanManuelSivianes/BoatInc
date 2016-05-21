/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Proposit;
import com.boatinc.embarcacio.Veler;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Document;
import com.boatinc.persona.*;
import com.boatinc.persona.empleat.Comercial;
import com.boatinc.persona.empleat.Reparador;

/**
 *
 * @author Arsenik
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Client toni = new Client("Toni", "Dalmau", Document.DNI, "11111111E", "C/ mar nº 2", 44, "tonidalmau@gmail.com");

            Comercial paco = new Comercial("Paco", "Jemez", Document.DNI, "11111111E", "C/ mar nº 2", 44, "tonidalmau@gmail.com", 23.215f, "18/11/2016", 10);

            Veler concordia = new Veler(5, 4, 2, 00001, "BNX105", "Goleto", "Turca", 10, 50, 20, Proposit.REPARACIO, 23.215f,true);

            Reparador jose = new Reparador("Jose", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");

            Empresa marineland = new Empresa();
            
            Reparacio reparacioVeler = new Reparacio(marineland,"Taller", "18/05/2016", "18/05/2016", "Manguitos", 23.215f, toni, concordia, Estat.INICIADA);
            Comentari comentariU = new Comentari("18/11/2016", jose, "He apretao to");
            
            reparacioVeler.afegirComentari(comentariU);
            
            System.out.println(reparacioVeler.getComentarisReparacio());
            
            reparacioVeler.eliminarComentari(1);
            System.out.println(reparacioVeler.getEmpleats());
            reparacioVeler.afegirEmpleat(jose);
            System.out.println("Lista de trabajadores" + reparacioVeler.getEmpleats());
            System.out.println(marineland.getLlistaOperacions());
            
            System.out.println(marineland.getLlistaOperacions());
        } catch (DataException | NoAfegitException | NoEliminatException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
