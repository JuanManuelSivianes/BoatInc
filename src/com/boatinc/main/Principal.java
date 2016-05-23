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
import com.boatinc.operacio.Venda;
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
            Empresa boatsINC = new Empresa("Mare Nostrum", "A26123457", "C/ Bissanyes, nº 7", 902202122);

            /*CLIENTE*/
            TargetaCredit tarjeta1 = new TargetaCredit(01, 02, 2018, 123);
            CompteCorrent compte1 = new CompteCorrent("123456789");
            Client toni = new Client(boatsINC, "Toni", "Dalmau", Document.DNI, "11111111A", "C/ mar nº 1", 600000001, "tonidalmau@gmail.com", tarjeta1, compte1);
            Client alfonso = new Client(boatsINC, "Alfonso", "Perez", Document.DNI, "11111111B", "C/ mar nº 2", 600000002, "alfonsoperez@gmail.com", tarjeta1, compte1);
            Client catalina = new Client(boatsINC, "Catalina", "Guardiola", Document.DNI, "11111111C", "C/ mar nº 3", 600000003, "catalinaguardiola@gmail.com", tarjeta1, compte1);

            /*COMERCIALS*/
            Comercial paco = new Comercial(boatsINC, "Paco", "Jemez", Document.DNI, "11111111D", "C/ mar nº 4", 600000004, "pacojemez@gmail.com", 1000f, "01/01/2016", 10);
            Comercial luis = new Comercial(boatsINC, "Luis", "Bajon", Document.DNI, "11111111I", "C/ mar nº 9", 600000009, "luisbajon@gmail.com", 1000f, "02/01/2016", 10);

            /*REPARADORS*/
            Reparador jose = new Reparador(boatsINC, "Jose", "delafuente", Document.DNI, "11111111E", "C/ mar nº 5", 600000005, "josedelafuente@gmail.com", 600f, "02/05/2016", FUSTERIA, VELES);
            Reparador juan = new Reparador(boatsINC, "Juan", "perico", Document.DNI, "11111111F", "C/ mar nº 6", 600000006, "juanperico@gmail.com", 900f, "05/05/2014", FONTANERIA, ELECTRICITAT, FIBRA_DE_VIDRE);

            /*PATRONS*/
            Patro bernat = new Patro(boatsINC, "Bernat", "Sabater", Document.DNI, "11111111G", "C/ mar nº 7", 600000007, "bernatsabater@gmail.com", "Patron de 1ª", 250f);
            Patro jenny = new Patro(boatsINC, "Jenny", "Valencia", Document.DNI, "11111111H", "C/ mar nº 8", 600000008, "jenyvalencia@gmail.com", "Patron de 2ª", 150f);

            /*EMBARCACIONS DISPONIBLES*/
            Veler veler1 = new Veler(boatsINC, 2, 4, 1, 000001, "AAA01", "Concordia", "AIR", 10, 20, 5, Proposit.LLOGUER, 50000, true);
            Veler veler2 = new Veler(boatsINC, 5, 2, 8, 000002, "AAA02", "Luitsu", "FIRE", 10, 20, 5, Proposit.LLOGUER, 50000, true);
            Iot iot1 = new Iot(boatsINC, 2, 100, 200, true, 000003, "AAA02", "Suiter", "LUXUS", 20, 10, 20, Proposit.REPARACIO, 80000, true);
            Motor motor1 = new Motor(boatsINC, 350, 2, true, 000005, "AAA03", "BMW", "A450", 10, 2, 3, Proposit.VENTA, 30000, true);

            /*EMBARCACIONS NO DISPONIBLES*/
            //Veler veler3 = new Veler(boatsINC, 2, 4, 1, 000001, "AAA04", "Concordia", "AIR2", 10, 20, 5, Proposit.LLOGUER, 50000, false);
            Iot iot2 = new Iot(boatsINC, 2, 100, 200, true, 000004, "AAA05", "Suiter", "LUXUS2", 20, 10, 20, Proposit.REPARACIO, 80000, false);
            Motor motor2 = new Motor(boatsINC, 350, 2, true, 000006, "AAA06", "BMW", "A4502", 10, 2, 3, Proposit.VENTA, 30000, false);

            /*OPERACIONS*/
            //Lloguer lloguer1 = new Lloguer(boatsINC, alfonso, veler1, Estat.INICIADA, "19/05/2016", "27/05/2016", 100f);
            //Reparacio reparacio1 = new Reparacio(boatsINC, "Taller", "22/05/2016", "31/05/2016", "Cambiar el motor", toni, iot1, Estat.INICIADA, 500f);
            //Venda venta1 = new Venda(boatsINC, alfonso, motor1, Estat.FINALITZADA, paco, "22/05/2016", 30000f);

            /*----------PRUEBAS----------*/
            System.out.println("############################" + "\n## PROVES CLASSE OPERACIO  ##" + "\n############################\n");

            System.out.println("En aquest cas agafarem un lloguer ja que no podem crear una operacio perque la classe es abstracta i farem ús dels metodes de operacio: \n");
            Lloguer lloguer1 = new Lloguer(boatsINC, alfonso, veler1, Estat.INICIADA, "19/05/2016", "27/05/2016", bernat, 100f);
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> lloguer1.getIdentificador(): " + lloguer1.getIdentificador());
            System.out.println("-> lloguer1.getClient(): " + lloguer1.getClient());
            System.out.println("-> lloguer1.getEmbarcacio(): " + lloguer1.getEmbarcacio());
            System.out.println("-> lloguer1.getEstat(): " + lloguer1.getEstat());
            System.out.println("-> lloguer1.getPreu(): " + lloguer1.getPreu());
            System.out.println("-> lloguer1.getTipusOperacio(): " + lloguer1.getTipusOperacio());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Client de la operacio: " + lloguer1.getClient() + "\nEl canviam per el client Alfonso amb lloguer1.setClient(alfonso)");
            lloguer1.setClient(alfonso);
            System.out.println("Client de la operacio després del canvi: " + lloguer1.getClient());

            System.out.println("\nEmbarcacio de la operacio: " + lloguer1.getEmbarcacio() + "\nEl canviam per un IOT amb lloguer1.setEmbarcacio(iot1)");
            lloguer1.setEmbarcacio(iot1);
            System.out.println("Embarcacio de la operacio després del canvi: " + lloguer1.getEmbarcacio());

            System.out.println("\nEstat de la operacio: " + lloguer1.getEstat() + "\nEl canviam a ATURADA amb lloguer1.setEstat(Estat.ATURADA)");
            lloguer1.setEstat(Estat.ATURADA);
            System.out.println("Estat de la operacio després del canvi: " + lloguer1.getEstat());

            System.out.println("\nPreu de la operacio: " + lloguer1.getPreu() + "\nEl canviam a 200 amb lloguer1.setPreu(200f);");
            lloguer1.setPreu(200f);
            System.out.println("Preu de la operacio després del canvi: " + lloguer1.getPreu());

            System.out.println("\n\n##########################" + "\n## PROVES CLASSE LLOGUER  ##" + "\n##########################\n");
            System.out.println("\nAquí farem les proves de la part especifica de la classe Lloguer:");

            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> lloguer1.getDataInicial(): " + lloguer1.getDataInicial());
            System.out.println("-> lloguer1.getDataFinal(): " + lloguer1.getDataFinal());
            System.out.println("-> lloguer1.getPatro(): " + lloguer1.getPatro());
            System.out.println("-> lloguer1.getPreuTotal(): " + lloguer1.getPreuTotal());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Data incial de la operacio: " + lloguer1.getDataInicial() + "\nLa canviam per 22/05/2016 amb lloguer1.setDataInicial(19/05/2016)");
            lloguer1.setDataInicial("22/05/2016");
            System.out.println("Data incial de la operacio després del canvi: " + lloguer1.getDataInicial());

            System.out.println("\nData final de la operacio: " + lloguer1.getDataFinal() + "\nLa canviam per 01/06/2016 amb lloguer1.setDataInicial(19/05/2016)");
            lloguer1.setDataFinal("01/06/2016");
            System.out.println("Data final de la operacio després del canvi: " + lloguer1.getDataFinal());

            System.out.println("\nPatro de la operacio: " + lloguer1.getPatro() + "\nEl canviam per el patro Jenny amb lloguer1.setPatro(jenny)");
            lloguer1.setPatro(jenny);
            System.out.println("Patro de la operacio després del canvi: " + lloguer1.getPatro());

            System.out.println("\nPreu de la operacio amb patro: " + lloguer1.getPreuTotal() + "\nEl canviam per el patro Jenny amb lloguer1.setPreuTotal(450f)");
            lloguer1.setPreuTotal(450f);
            System.out.println("Preu de la operacio després del canvi: " + lloguer1.getPreuTotal());

            System.out.println("\n\n##########################" + "\n## PROVES CLASSE REPARACIO  ##" + "\n##########################\n");
            System.out.println("\nAquí farem les proves de la part especifica de la classe Reparacio:");
            Reparacio reparacio1 = new Reparacio(boatsINC, "Taller", "22/05/2016", "31/05/2016", "Cambiar el motor", toni, iot1, Estat.INICIADA, 500f);
            Comentari comentari1 = new Comentari("22/05/2016", juan, "He iniciado el cambio del motor");
            Comentari comentari2 = new Comentari("25/05/2016", juan, "Empiezo a cambiar los filtros");
            reparacio1.afegirComentari(comentari1);
            reparacio1.afegirEmpleat(jose);

            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> reparacio1.getEmpleats(): " + reparacio1.getEmpleats());
            System.out.println("-> reparacio1.getComentarisReparacio(): " + reparacio1.getComentarisReparacio());
            System.out.println("-> reparacio1.getLloc(): " + reparacio1.getLloc());
            System.out.println("-> reparacio1.getDataInici(): " + reparacio1.getDataInici());
            System.out.println("-> reparacio1.getDataPrevista(): " + reparacio1.getDataPrevista());
            System.out.println("-> reparacio1.getDescripcioAveria(): " + reparacio1.getDescripcioAveria());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Lloc de la operacio: " + reparacio1.getLloc() + "\nEl camviam per Oficina amb reparacio1.setLloc(\"Oficina\")");
            reparacio1.setLloc("Oficina");
            System.out.println("Lloc de la operacio després del canvi: " + reparacio1.getLloc());

            System.out.println("\nData inicial de la operacio: " + reparacio1.getDataInici() + "\nLa canviam per \"25/05/2016\" amb reparacio1.setDataInici(\"25/05/2016\")");
            reparacio1.setDataInici("25/05/2016");
            System.out.println("Data inicial de la operacio després del canvi: " + reparacio1.getDataInici());

            System.out.println("\nData prevista de la operacio: " + reparacio1.getDataPrevista() + "\nLa canviam per \"02/06/2016\" amb reparacio1.setDataPrevista(\"02/06/2016\")");
            reparacio1.setDataPrevista("02/06/2016");
            System.out.println("Data prevista de la operacio després del canvi: " + reparacio1.getDataPrevista());

            System.out.println("\nDescripcio de la operacio: " + reparacio1.getDescripcioAveria() + "\nLa canviam per \"Limpieza de filtros\" amb reparacio1.setDescripcioAveria(\"Limpieza de filtros\")");
            reparacio1.setDescripcioAveria("Limpieza de filtros");
            System.out.println("Descripcio de la operacio després del canvi: " + reparacio1.getDescripcioAveria());

            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("Afegim un nou treballador a la reparacio amb reparacio1.afegirEmpleat(juan)");
            reparacio1.afegirEmpleat(juan);
            System.out.println("Comprovam que s'ha afegit: " + reparacio1.getEmpleats());

            System.out.println("Que passaria si afegim un altre cop el mateix treballador ? Ens retornaria un NoAfegitException el qual imprimirem el missatge:");
            try {
                reparacio1.afegirEmpleat(juan);
            } catch (NoAfegitException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nAra eliminarem el treballador que tenia pasant l'objecte d'aquest");
            reparacio1.eliminarEmpleat(juan);
            System.out.println(reparacio1.getEmpleats());
            System.out.println("S'ha eliminat correctament, pero que passaria si intentam eliminar un treballador que no te ? Ens avisaria de que el treballador introduït no coincideix amb cap de les que té la reparacio:");
            try {
                reparacio1.eliminarEmpleat(juan);
            } catch (NoEliminatException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nAfegim un nou comentari a la reparacio amb reparacio1.afegirComentari(comentari2)");
            reparacio1.afegirComentari(comentari2);
            System.out.println("Comprovam que s'ha afegit: " + reparacio1.getComentarisReparacio());
            System.out.println("Que passaria si afegim un altre cop el mateix comentari ? Ens retornaria un NoAfegitException el qual imprimirem el missatge:");
            try {
                reparacio1.afegirComentari(comentari2);
            } catch (NoAfegitException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nAra eliminarem un comentari que tenia pasant l'identificador d'aquest");
            System.out.println(reparacio1.getComentarisReparacio());
            //reparacio1.eliminarComentari(2);
            //System.out.println(reparacio1.getComentarisReparacio());

            System.out.println("\nAra retornarem el nom dels empleats que estan fent feina a la operacio amb reparacio1.retornaEmpleats()");
            System.out.println(reparacio1.retornaEmpleats());

            System.out.println("\n\n##########################" + "\n## PROVES CLASSE VENDA  ##" + "\n##########################\n");
            System.out.println("\nAquí farem les proves de la part especifica de la classe Venda:");
            Venda venta1 = new Venda(boatsINC, alfonso, motor1, Estat.FINALITZADA, paco, "22/05/2016", 30000f);
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> venta1.getComercial(): " + venta1.getComercial());
            System.out.println("-> venta1.getDataVenta(): " + venta1.getDataVenta());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Comercial de la operacio: " + venta1.getComercial() + "\nEl camviam per el comercial Luis amb venta1.setComercial(luis);");
            venta1.setComercial(luis);
            System.out.println("Comercial de la operacio després del canvi: " + venta1.getComercial());

            System.out.println("\nData de la operacio: " + venta1.getDataVenta() + "\nLa canviam per \"31/05/2016\" amb venta1.setDataVenta(\"22/05/2016\");");
            venta1.setDataVenta("31/05/2016");
            System.out.println("Data de la operacio després del canvi: " + venta1.getDataVenta());

        } catch (DataException | NoAfegitException | NoEliminatException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
