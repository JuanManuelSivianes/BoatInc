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
            Empresa empresa1 = new Empresa("DevelopersNautics", "", "", 677888888);
            
            Empleat empleat1 = new Empleat(empresa1, "Pep", "Serra", Document.DNI, "74125896v", "C/ Major", 632478942, "pep@email.com", 1200, "14/07/1990");
            Empleat empleat2 = new Empleat(empresa1, "Joan", "Soler", Document.DNI, "89125864x", "C/ Menor", 688478111, "joan@email.com", 1400, "20/06/1989");
            Empleat empleat3 = new Empleat(empresa1, "Toni", "Fiol", Document.DNI, "47125897z", "C/ Jaume", 677478222, "toni@email.com", 1300, "24/04/1987");
            
            Client client1 = new Client(empresa1, "Xavier", "Valens", Document.DNI, "98745632x", "Carrer sol", 123456789, "xavier@email.com");
            Client client2 = new Client(empresa1, "Alfonso", "Perez", Document.DNI, "11111111B", "C/ mar nº 2", 600000002, "alfonsoperez@gmail.com");
            Client client3 = new Client(empresa1, "Catalina", "Guardiola", Document.DNI, "11111111C", "C/ mar nº 3", 600000003, "catalinaguardiola@gmail.com");
            
            System.out.println("2");
            Iot iot1 = new Iot(4, 1000, 200, true, 1234, "4444x", "Fairline", "f47", 2, 10, 1, Proposit.LLOGUER, 200000, true);
            Iot iot2 = new Iot(4, 800, 400, true, 4321, "7799x", "Bavaria", "v34", 2, 15, 1, Proposit.REPARACIO, 100000, true);
            Iot iot3 = new Iot(4, 700, 500, true, 5678, "8800x", "Menorqui", "m67", 2, 20, 1, Proposit.VENTA, 150000, true);
            
            Veler veler1 = new Veler(2, 1, 2, 7744, "6688q", "Sunseeker", "x78", 3, 12, 2, Proposit.LLOGUER, 80000, true);
            Veler veler2 = new Veler(4, 1, 4, 1414, "4422t", "Catamaran", "c42", 6, 14, 2, Proposit.REPARACIO, 100000, true);
            Veler veler3 = new Veler(2, 1, 4, 2424, "3399g", "Beneteau", "j64", 4, 12, 2, Proposit.VENTA, 70000, true);
            
            Motor motor1 = new Motor(150, 100, true, 9999, "3214m", "Yamaha", "y23", 2, 8, 1, Proposit.LLOGUER, 20000, true);
            Motor motor2 = new Motor(400, 300, true, 1111, "1177n", "Raptor", "r98", 2, 10, 1, Proposit.REPARACIO, 30000, true);
            Motor motor3 = new Motor(300, 200, true, 2222, "2234w", "Zodiac", "z46", 2, 12, 1, Proposit.VENTA, 25000, true);
            
            System.out.println("3");
            
            Reparacio reparacio1 = new Reparacio(empresa1, "Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", client1, iot2, Estat.PENDENT, 1000);  
            Reparacio reparacio2 = new Reparacio(empresa1, "Sa Pobla", "21/05/2016", "24/05/2016", "Casc romput", client1, iot2, Estat.PENDENT, 2000);
            
            Reparador jose = new Reparador(empresa1, "Joseca", "Anchoa", Document.DNI, "11111111E", "C/ mar nº 2", 677999442, "jsoso@email.com", 23.215f, "18/11/2016");
            Reparador reparador1 = new Reparador(empresa1, "Pepe", "Perez", Document.DNI, "77777777M", "C/ Roca nº 4", 633444222, "pepe@email.com", 23.215f, "20/10/2010");
            Reparador reparador2 = new Reparador(empresa1, "Paco", "Gomez", Document.DNI, "44444444C", "C/ Mallorca nº 1", 611111777, "paco@email.com", 23.215f, "04/03/2007");
            
            Comentari comentari1 = new Comentari("18/05/2016", jose, "Motor romput");
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
    
    public static void provesEmbarcacio(){
        System.out.println("############################" + "\n## PROVES CLASSE EMBARCACIO  ##" + "\n############################\n");
        
        System.out.println("En aquest cas agafarem un iot ja que no podem crear una embarcació perque la classe es abstracta i farem ús dels metodes de embarcacio: \n");
        Iot iot1 = new Iot(4, 1000, 200, true, 1234, "4444x", "Fairline", "f47", 2, 10, 1, Proposit.LLOGUER, 200000, true);
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> iot1.getNumeroSerie(): "+iot1.getNumeroSerie());
        System.out.println("-> iot1.getMatricula(): "+iot1.getMatricula());
        System.out.println("-> iot1.getMarca(): "+iot1.getMarca());
        System.out.println("-> iot1.getModel(): "+iot1.getModel());
        System.out.println("-> iot1.getManga(): "+iot1.getManga());
        System.out.println("-> patro1.getEmail(): "+iot1.getEslora());
        System.out.println("-> iot1.getCalat(): "+iot1.getCalat());
        System.out.println("-> iot1.getTipusEmbarcacio(): "+iot1.getTipusEmbarcacio());
        System.out.println("-> iot1.getProposit(): "+iot1.getProposit());
        System.out.println("-> iot1.getPreu(): "+iot1.getPreu());
        System.out.println("-> iot1.getHistoricReparacions(): "+iot1.getHistoricReparacions());
        
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Numero de serie de l'embarcacio: "+iot1.getNumeroSerie()+"\nEl canviam per \"7777\" amb iot1.setNumeroSerie(7777);");
        iot1.setNumeroSerie(7777);
        System.out.println("Numero de serie després del canvi: "+iot1.getNumeroSerie());
        
        System.out.println("\nMatricula de l'embarcacio: "+iot1.getMatricula()+"\nLa canviam per \"4411r\" amb iot1.setMatricula(\"4411r\");");
        iot1.setMatricula("4411r");
        System.out.println("Matricula de l'embarcacio després del canvi: "+iot1.getMatricula());
        
        System.out.println("\nMarca de l'embarcacio: "+iot1.getMarca()+"\nLa canviam per \"Bavaria\" amb iot1.setMarca(\"Bavaria\");");
        iot1.setMarca("Bavaria");
        System.out.println("Marca de l'embarcacio després del canvi: "+iot1.getMarca());
        
        System.out.println("\nModel de l'embarcacio: "+iot1.getModel()+"\nLa canviam per \"v34\" amb iot1.setModel(\"v34\");");
        iot1.setModel("v34");
        System.out.println("Model de l'embarcacio després del canvi: "+iot1.getModel());
        
        System.out.println("\nManga de l'embarcacio: "+iot1.getManga()+"\nLa canviam per \"3\" amb iot1.setManga(3);");
        iot1.setModel("v34");
        System.out.println("Manga de l'embarcacio després del canvi: "+iot1.getManga());
        
        System.out.println("\nEslora de l'embarcacio: "+iot1.getEslora()+"\nLa canviam per \"15\" amb iot1.setEslora(15);");
        iot1.setEslora(15);
        System.out.println("Eslora de l'embarcacio després del canvi: "+iot1.getEslora());
        
        System.out.println("\nCalat de l'embarcacio: "+iot1.getCalat()+"\nEl canviam per \"2\" amb iot1.setCalat(2);");
        iot1.setCalat(2);
        System.out.println("Calat de l'embarcacio després del canvi: "+iot1.getCalat());
        
        System.out.println("\nProposit de l'embarcacio: "+iot1.getProposit()+"\nEl canviam per \"VENTA\" amb iot1.setProposit(Proposit.VENTA);");
        iot1.setProposit(Proposit.VENTA);
        System.out.println("Proposit de l'embarcacio després del canvi: "+iot1.getProposit());
        
        System.out.println("\nPreu de l'embarcacio: "+iot1.getPreu()+"\nEl canviam per \"300000\" amb iot1.setPreu(300000);");
        iot1.setPreu(300000);
        System.out.println("Preu de l'embarcacio després del canvi: "+iot1.getPreu());
        
        
        System.out.println("\n\n##########################" + "\n## PROVES CLASSE IOT  ##" + "\n##########################\n");
        System.out.println("\nAquí farem les proves de la part especifica de la classe Iot:");
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> iot1.getNumeroCamarots(): "+iot1.getNumeroCamarots());
        System.out.println("-> iot1.getPotencia(): "+iot1.getPotencia());
        System.out.println("-> iot1.getAutonomia(): "+iot1.getAutonomia());
        
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Numero de camarots de l'embaracio: "+iot1.getNumeroCamarots()+"\nEl canviam per \"2\" amb iot1.setNumeroCamarots(2);");
        iot1.setNumeroCamarots(2);
        System.out.println("Numero de camarots després del canvi: "+iot1.getNumeroCamarots());
        
        System.out.println("Potencia de l'embaracio: "+iot1.getPotencia()+"\nLa canviam per \"1200\" amb iot1.setPotencia(1200);");
        iot1.setPotencia(1200);
        System.out.println("Potencia després del canvi: "+iot1.getPotencia());
        
        System.out.println("Autonomia de l'embaracio: "+iot1.getAutonomia()+"\nLa canviam per \"300\" amb iot1.setAutonomia(300);");
        iot1.setAutonomia(300);
        System.out.println("Autonomia després del canvi: "+iot1.getAutonomia());
        
        
        System.out.println("\n\n##########################" + "\n## PROVES CLASSE VELER  ##" + "\n##########################\n");
        System.out.println("\nAquí farem les proves de la part especifica de la classe Veler:");
        Veler veler1 = new Veler(2, 1, 2, 7744, "6688q", "Sunseeker", "x78", 3, 12, 2, Proposit.LLOGUER, 80000, true);
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> veler1.getNumeroCascs(): "+veler1.getNumeroCascs());
        System.out.println("-> veler1.getNumeroPals(): "+veler1.getNumeroPals());
        System.out.println("-> veler1.getNumeroCabines(): "+veler1.getNumeroCabines());
        
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Numero de cascs de l'embaracio: "+veler1.getNumeroCascs()+"\nEl canviam per \"4\" amb veler1.setNumeroCascs(4);");
        veler1.setNumeroCascs(4);
        System.out.println("Numero de cascs després del canvi: "+veler1.getNumeroCascs());
        
        System.out.println("Numero de pals de l'embaracio: "+veler1.getNumeroPals()+"\nEl canviam per \"2\" amb veler1.setNumeroPals(2);");
        veler1.setNumeroPals(2);
        System.out.println("Numero de pals després del canvi: "+veler1.getNumeroPals());
        
        System.out.println("Numero de cabines de l'embaracio: "+veler1.getNumeroCabines()+"\nEl canviam per \"4\" amb veler1.setNumeroCabines(4);");
        veler1.setNumeroCabines(4);
        System.out.println("Numero de cabines després del canvi: "+veler1.getNumeroCabines());
        
        
        System.out.println("\n\n##########################" + "\n## PROVES CLASSE MOTOR  ##" + "\n##########################\n");
        System.out.println("\nAquí farem les proves de la part especifica de la classe Motor:");
        Motor motor1 = new Motor(150, 100, true, 9999, "3214m", "Yamaha", "y23", 2, 8, 1, Proposit.LLOGUER, 20000, true);
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> motor1.getPotencia(): "+motor1.getPotencia());
        System.out.println("-> motor1.getCapacitatDeposit(): "+motor1.getCapacitatDeposit());
        
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Potencia de l'embaracio: "+motor1.getPotencia()+"\nLa canviam per \"200\" amb motor1.setPotencia(200);");
        motor1.setPotencia(200);
        System.out.println("Potencia després del canvi: "+motor1.getPotencia());
        
        System.out.println("Capacitat del deposit de l'embaracio: "+motor1.getCapacitatDeposit()+"\nLa canviam per \"150\" amb motor1.setCapacitatDeposit(150);");
        motor1.setCapacitatDeposit(150);
        System.out.println("Capacitat del deposit després del canvi: "+motor1.getCapacitatDeposit());
        
    }
    
}
