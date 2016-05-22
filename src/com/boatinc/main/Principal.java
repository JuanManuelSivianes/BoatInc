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
            Empresa boatsINC = new Empresa();

            /*CLIENTE*/
            TargetaCredit tarjeta1 = new TargetaCredit(01, 02, 2018, 123);
            CompteCorrent compte1 = new CompteCorrent("123456789");
            Client toni = new Client("Toni", "Dalmau", Document.DNI, "11111111A", "C/ mar nº 1", 600000001, "tonidalmau@gmail.com", tarjeta1, compte1);
            Client alfonso = new Client("Alfonso", "Perez", Document.DNI, "11111111B", "C/ mar nº 2", 600000002, "alfonsoperez@gmail.com", tarjeta1, compte1);
            Client catalina = new Client("Catalina", "Guardiola", Document.DNI, "11111111C", "C/ mar nº 3", 600000003, "catalinaguardiola@gmail.com", tarjeta1, compte1);

            /*COMERCIALS*/
            Comercial paco = new Comercial("Paco", "Jemez", Document.DNI, "11111111D", "C/ mar nº 4", 600000004, "pacojemez@gmail.com", 1000f, "01/01/2016", 10);

            /*REPARADORS*/
            Reparador jose = new Reparador("Jose", "delafuente", Document.DNI, "11111111E", "C/ mar nº 5", 600000005, "josedelafuente@gmail.com", 600f, "02/05/2016", FUSTERIA, VELES);
            Reparador juan = new Reparador("Juan", "perico", Document.DNI, "11111111F", "C/ mar nº 6", 600000006, "juanperico@gmail.com", 900f, "05/05/2014", FONTANERIA, ELECTRICITAT, FIBRA_DE_VIDRE);

            /*PATRONS*/
            Patro bernat = new Patro("Bernat", "Sabater", Document.DNI, "11111111G", "C/ mar nº 7", 600000007, "bernatsabater@gmail.com", "Patron de 1ª", 250f);

            /*EMBARCACIONS DISPONIBLES*/
            Veler veler1 = new Veler(2, 4, 1, 000001, "AAA01", "Concordia", "AIR", 10, 20, 5, Proposit.LLOGUER, 50000, true);
            Iot iot1 = new Iot(2, 100, 200, true, 000002, "AAA02", "Suiter", "LUXUS", 20, 10, 20, Proposit.REPARACIO, 80000, true);
            Motor motor1 = new Motor(350, 2, true, 000003, "AAA03", "BMW", "A450", 10, 2, 3, Proposit.VENTA, 30000, true);

            /*EMBARCACIONS NO DISPONIBLES*/
            Veler veler2 = new Veler(2, 4, 1, 000001, "AAA04", "Concordia", "AIR2", 10, 20, 5, Proposit.LLOGUER, 50000, false);
            Iot iot2 = new Iot(2, 100, 200, true, 000002, "AAA05", "Suiter", "LUXUS2", 20, 10, 20, Proposit.REPARACIO, 80000, false);
            Motor motor2 = new Motor(350, 2, true, 000003, "AAA06", "BMW", "A4502", 10, 2, 3, Proposit.VENTA, 30000, false);

            /*OPERACIONS*/
            Lloguer lloguer1 = new Lloguer(boatsINC, alfonso, veler1, Estat.INICIADA, "19/05/2016", "27/05/2016", 100f);
            Reparacio reparacio1 = new Reparacio(boatsINC, "Taller", "22/05/2016", "31/05/2016", "Cambiar el motor", toni, iot1, Estat.INICIADA, 500f);
            Venda venta1 = new Venda(boatsINC, alfonso, motor1, Estat.FINALITZADA, paco, "22/05/2016", 30000f);

            /*PRUEBAS*/
            System.out.println("---DATOS EMPRESA---");
            System.out.println("Datos empresa: " + boatsINC);

            System.out.println("");

            /*SOLO MUESTRO LOS DE 1 CLIENTE*/
            System.out.println("---DATOS COMPLETOS CLIENTES---");
            System.out.println("GET NOM: " + toni.getNom());
            System.out.println("GET COGNOM: " + toni.getCognom());
            System.out.println("GET TIPUS DOCUMENT: " + toni.getDocument());
            System.out.println("GET NUMERO DOCUEMTN: " + toni.getNumeroDocument());
            System.out.println("GET ADREÇA: " + toni.getAdreça());
            System.out.println("GET TELEFON: " + toni.getTelefon());
            System.out.println("GET EMAIL: " + toni.getEmail());
            System.out.println("GET FORMES PAGAMENT: " + toni.getFormesPagament());
            System.out.println("TOSTRING: " + toni);

            System.out.println("");

            /*SOLO MUESTRO LOS DE 1 COMERCIAL*/
            System.out.println("---DATOS COMPLETOS COMERCIAL---");
            System.out.println("GET NOM: " + paco.getNom());
            System.out.println("GET COGNOM: " + paco.getCognom());
            System.out.println("GET TIPUS DOCUMENT: " + paco.getDocument());
            System.out.println("GET NUMERO DOCUEMTN: " + paco.getNumeroDocument());
            System.out.println("GET ADREÇA: " + paco.getAdreça());
            System.out.println("GET TELEFON: " + paco.getTelefon());
            System.out.println("GET EMAIL: " + paco.getEmail());
            System.out.println("GET SOU: " + paco.getSou());
            System.out.println("GET DATA CONTRACTE: " + paco.getDataAlta());
            System.out.println("GET PERSENTATGE COMISIO: " + paco.getPercentComissio());
            System.out.println("GET COMISIO TOTAL: " + paco.getComissio());
            System.out.println("GET HISTORIC OPERACION: " + paco.getHistoricOperacions());
            System.out.println("TOSTRING: " + paco);

            System.out.println("");

            /*SOLO MUESTRO LOS DE 1 REPARADOR*/
            System.out.println("---DATOS COMPLETOS REPARADOR---");
            System.out.println("GET NOM: " + jose.getNom());
            System.out.println("GET COGNOM: " + jose.getCognom());
            System.out.println("GET TIPUS DOCUMENT: " + jose.getDocument());
            System.out.println("GET NUMERO DOCUEMTN: " + jose.getNumeroDocument());
            System.out.println("GET ADREÇA: " + jose.getAdreça());
            System.out.println("GET TELEFON: " + jose.getTelefon());
            System.out.println("GET EMAIL: " + jose.getEmail());
            System.out.println("GET SOU: " + jose.getSou());
            System.out.println("GET DATA CONTRACTE: " + jose.getDataAlta());
            System.out.println("GET LLISTA HABILITATS: " + jose.getHabilitats());
            System.out.println("TOSTRING: " + jose);

            System.out.println("");

            /*SOLO MUESTRO LOS DE 1 PATRON*/
            System.out.println("---DATOS COMPLETOS PATRONS---");
            System.out.println("GET NOM: " + bernat.getNom());
            System.out.println("GET COGNOM: " + bernat.getCognom());
            System.out.println("GET TIPUS DOCUMENT: " + bernat.getDocument());
            System.out.println("GET NUMERO DOCUEMTN: " + bernat.getNumeroDocument());
            System.out.println("GET ADREÇA: " + bernat.getAdreça());
            System.out.println("GET TELEFON: " + bernat.getTelefon());
            System.out.println("GET EMAIL: " + bernat.getEmail());
            System.out.println("GET TITULACIO: "+ bernat.getTitulacio());
            System.out.println("GET COST: " + bernat.getCost());
            System.out.println("TOSTRING: " + bernat);
            
            System.out.println("");

            /*MUESTRO LOS DE 3 EMBARCACIONES*/
            System.out.println("---DATOS COMPLETOS EMBARCACIONES---");
            System.out.println("GET NUMERO DE SERIE: " + veler1.getNumeroSerie());
            System.out.println("GET MATRICULA: " + veler1.getMatricula());
            System.out.println("GET MARCA: " + veler1.getMarca());
            System.out.println("GET MODEL: " + veler1.getModel());
            System.out.println("GET MANGA: " + veler1.getManga());
            System.out.println("GET ESLORA: " + veler1.getEslora());
            System.out.println("GET CALAT: " + veler1.getCalat());
            System.out.println("GET TIPUS EMBARCACIO: " + veler1.getTipusEmbarcacio());
            System.out.println("GET PROPOSIT: " + veler1.getProposit());
            System.out.println("GET PREU: " + veler1.getPreu());
            System.out.println("GET HISTORICS REPARACIONS: " + veler1.getHistoricReparacions());
            System.out.println("GET DISPOBIBILITAT: " + veler1.isDisponibilitat());
            System.out.println("GET CASCS: " + veler1.getNumeroCascs());
            System.out.println("GET PALS: " + veler1.getNumeroPals());
            System.out.println("GET CABINES: " + veler1.getNumeroCabines());
            System.out.println("TOSTRING: " + veler1);
            System.out.println("INFORMACIO DETALLADA: " + veler1.infoDetallada());

        } catch (DataException | NoAfegitException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
