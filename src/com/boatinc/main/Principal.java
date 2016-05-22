/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Motor;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.embarcacio.Veler;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Lloguer;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Document;
import com.boatinc.persona.*;
import com.boatinc.persona.empleat.Comercial;
import static com.boatinc.persona.empleat.Habilitat.*;
import com.boatinc.persona.empleat.Reparador;
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

        try {
            /*EMPRESA*/
            Empresa boatsINC = new Empresa();
            
            /*CLIENTE*/
            TargetaCredit tarjeta1 = new TargetaCredit(01, 02, 2018, 123);
            CompteCorrent compte1 = new CompteCorrent("123456789");
            Client toni = new Client("Toni", "Dalmau", Document.DNI, "11111111A", "C/ mar nº 1", 600000001, "tonidalmau@gmail.com", tarjeta1, compte1);

            /*COMERCIALS*/
            Comercial paco = new Comercial("Paco", "Jemez", Document.DNI, "11111111B", "C/ mar nº 2", 600000002, "pacojemez@gmail.com", 1000f, "01/01/2016", 10);

            /*REPARADORS*/
            Reparador jose = new Reparador("Jose", "delafuente", Document.DNI, "11111111C", "C/ mar nº 3", 600000003, "josedelafuente@gmail.com", 600f, "02/05/2016", FUSTERIA,VELES);
            Reparador juan = new Reparador("Juan", "perico", Document.DNI, "11111111D", "C/ mar nº 4", 600000004, "juanperico@gmail.com", 900f, "05/05/2014", FONTANERIA,ELECTRICITAT,FIBRA_DE_VIDRE);
            
            /*PATRONS*/
            Patro bernat = new Patro("Bernat", "Sabater", Document.DNI, "11111111D", "C/ mar nº 5", 600000005, "bernatsabater@gmail.com", "Patron de 1ª", 250f);
            
            /*EMBARCACIONS DISPONIBLES*/
            Veler veler1 = new Veler(2, 4, 1, 000001, "AAA01", "Concordia", "AIR", 10, 20, 5, Proposit.LLOGUER, 50000, true);
            Iot iot1 = new Iot(2, 100, 200, true, 000002, "AAA02", "Suiter", "LUXUS", 20, 10, 20, Proposit.REPARACIO, 80000, true);
            Motor motor1 = new Motor(350, 2, true, 000003, "AAA03", "BMW", "A450", 10, 2, 3, Proposit.VENTA, 30000, true);
            
            /*EMBARCACIONS NO DISPONIBLES*/
            Veler veler2 = new Veler(2, 4, 1, 000001, "AAA04", "Concordia", "AIR2", 10, 20, 5, Proposit.LLOGUER, 50000, false);
            Iot iot2 = new Iot(2, 100, 200, true, 000002, "AAA05", "Suiter", "LUXUS2", 20, 10, 20, Proposit.REPARACIO, 80000, false);
            Motor motor2 = new Motor(350, 2, true, 000003, "AAA06", "BMW", "A4502", 10, 2, 3, Proposit.VENTA, 30000, false);
            
            

        } catch (DataException | NoEliminatException | NoAfegitException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
