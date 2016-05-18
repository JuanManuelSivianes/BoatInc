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

            Embarcacio concordia = new Embarcacio(00001, "BNX105", "Goleto", "Turca", 10, 50, 20, Proposit.REPARACIO, 180.251f);

            Reparador jose = new Reparador("Jose", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 44, "jsoso", 23.215f, "18/11/2016");

            Reparacio reparacioVeler = new Reparacio("Taller", "18/05/2016", "18/05/2016", "Manguitos", 23.215f, toni, concordia, Estat.INICIADA);

            Comentari comentariU = new Comentari("18/11/2016", jose, "He apretao to");

            reparacioVeler.eliminarEmpleat(jose);
        } catch (DataException | NoEliminatException ex) {
            System.out.println(ex.getMessage());
    }

}
}
