/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.embarcacio.Veler;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Venda;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Comercial;
import com.boatinc.persona.empleat.Empleat;
import com.boatinc.persona.empleat.Habilitat;
import com.boatinc.persona.empleat.Reparador;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanmi
 */
public class MainJoanmi {
    public static void main(String[] args) {
        
        try{
            Empresa empresa = new Empresa("ASDASD", "ASDASD2", "ASDASD", 65454);
            
            TargetaCredit tarj1 = new TargetaCredit(1111000022224444L, 10, 18, 221);
            TargetaCredit tarj2 = new TargetaCredit(3333444422221111L, 8, 17, 114);
            TargetaCredit tarj3 = new TargetaCredit(3333111177776666L, 4, 18, 334);
            TargetaCredit tarj4 = new TargetaCredit(4504254985614457L, 8, 18, 748);
            TargetaCredit tarj5 = new TargetaCredit(9457462559871347L, 11, 18, 341);
            
            CompteCorrent com1 = new CompteCorrent("ES1200001111887777777777");
            CompteCorrent com2 = new CompteCorrent("ES1211112222334444444444");
            CompteCorrent com3 = new CompteCorrent("ES2065411111542222222222");
            CompteCorrent com4 = new CompteCorrent("ES1066661111361111111111");
            CompteCorrent com5 = new CompteCorrent("ES1288881111783333333333");
            CompteCorrent com6 = new CompteCorrent("ES1425401111201542178452");
            
            
            Client client1 = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com",tarj1,tarj2,com1);
            Client client2 = new Client(empresa, "Manel", "Ferrer Mir", Document.DNI, "22222222G", "C/ tucan nº7, Sa Pobla", 600224455, "manel@gmail.com",tarj3);
            Client client3 = new Client(empresa, "Ana", "Johansen", Document.NIE, "X1234567P", "C/ perla nº 1, 2c, Manacor", 600111111, "ana@gmail.com",com2);
            Client client4 = new Client(empresa, "Clara", "Wassenger", Document.PASSAPORT, "O123456", "C/ marisc, nº2, Inca", 712557744, "clara@gmail.com",com4,tarj4);
            Client client5 = new Client(empresa, "Rafel", "Pol Vich", Document.DNI, "23847521G", "C/ mussol, planta baixa, Soller", 600334488, "rafel@yahoo.es",tarj5);
            Client client6 = new Client(empresa, "Pau", "Fernández Mas", Document.DNI, "66771144V", "C/ General Luque, nº23, 4b, Palma", 612784595, "pau@msn.es",com5);
            Client client7 = new Client(empresa, "Joan Miquel", "Fernández Cifre", Document.DNI, "21487652E", "C/ Joan Mas nº1, Vilafranca", 575232565, "joanmiquel@hotmail.com",com6);
            
                     
            Patro patro1 = new Patro(empresa, "Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);
            Patro patro2 = new Patro(empresa, "Raul", "Valls", Document.NIE, "X3245124C", "C/ Tord, nº4, escalera 2, Inca", 900114455, "raul@msn.es", "Patró embarcació bàsica", 120f);
            Patro patro3 = new Patro(empresa, "Lucia", "Ferrer Sanchez", Document.DNI, "9545512422G", "C/ Faissan, nº2, 3c, Soller", 906314575, "lucia@gmail.com", "Patró embarcació de recreo", 170f);
            
            Empleat empleat1 = new Empleat(empresa, "Carlos", "Punset", Document.DNI, "78943526F", "C/ Pascual, nº 2, 4b, Inca", 642554411, "Carlos@gmail.com", 1240f, "20/04/2000");
            Empleat empleat2 = new Empleat(empresa, "Elena", "Pascual", Document.DNI, "22465714J", "C/ Mondragó, atic, Inca", 640224488, "Elena@gmail.com", 1024f, "12/01/2002");
            Empleat empleat3 = new Empleat(empresa, "Guillem", "Fassina", Document.NIE, "X3485614F", "C/ Roca nº 9, Inca", 632448877, "guillem@gmail.com", 1160f, "15/05/2001");
            
            Comercial comercial1 = new Comercial(empresa, "David", "Ferrer Amoros", Document.DNI, "23451278G", "C/ Xavi nº10, Pollença", 654235241, "david@gmail.com", 300f, "02/04/1999", 7);
            Comercial comercial2 = new Comercial(empresa, "Reimond", "Powell", Document.NIE, "X3544124P", "Avinguda Reus nº10, Algaida", 620348544, "Reimond@gmail.com", 400f, "20/09/2000", 9);
            
            Reparador reparador1 = new Reparador(empresa, "Jose", "Sanchez Rodriguez", Document.DNI, "52164784P", "C/ Olmos nº2, Alcudia", 640224457, "jose@gmail.es", 920f, "07/09/2001", Habilitat.ELECTRICITAT,Habilitat.FUSTERIA);
            Reparador reparador2 = new Reparador(empresa, "Manolo", "Cruz Dias", Document.DNI, "35664127K", "C/ San Martin nº13, Palma", 625449975, "manolo@msn.es", 920f, "07/09/2001", Habilitat.VELES,Habilitat.FUSTERIA);
            Reparador reparador3 = new Reparador(empresa, "Benito", "Perez Silva", Document.NIE, "X6451244F", "C/ Aragon nº4, 5b, Palma", 664325674, "benito@gmail.es", 920f, "22/10/2001", Habilitat.FIBRA_DE_VIDRE,Habilitat.FUSTERIA,Habilitat.VELES);
            Reparador reparador4 = new Reparador(empresa, "Santiago", "Calatrava", Document.DNI, "34998245A", "C/ Bonaire nº4, 2c, Palma", 648772165, "santiago@yahoo.es", 920f, "10/07/2003", Habilitat.MECANICA,Habilitat.FONTANERIA);
            Reparador reparador5 = new Reparador(empresa, "Ramon", "Benitez Ruiz", Document.NIE, "X2844765G", "C/ Protectora nº7, Puerto de Alcudia", 634857321, "ramon@hotmail.com", 920f, "07/09/2001", Habilitat.ELECTRICITAT,Habilitat.FONTANERIA,Habilitat.MECANICA);
            
            Iot iot1 = new Iot(empresa,4,25, 200, true, 1234, "4444x", "Yamaha", "y23", 2, 10, 1, Proposit.LLOGUER, 20000, true);
            Veler concordia = new Veler(empresa,5, 4, 2, 00001, "BNX105", "Goleto", "Turca", 10, 50, 20, Proposit.REPARACIO, 23.215f,true);
            
//            Venda venda1 = new Venda(client1, iot1, Estat.FINALITZADA, comercial1, "20/04/2016", iot1.getPreuVenda());
//            Venda venda2 = new Venda(client1, iot1, Estat.FINALITZADA, comercial1, "20/04/2016", iot1.getPreuVenda());


            

        }catch(NoAfegitException | DataException e){
            System.err.println(e.getMessage());
        }
        
//        provesPersona();
        
    }
    
    public static void provesPersona() throws NoAfegitException{
        Empresa empresa = new Empresa("Mare Nostrum", "A26123457", "C/ Bissanyes, nº 7", 902202122);
        System.out.println("############################" + "\n## PROVES CLASSE PERSONA  ##" + "\n############################\n");
        
        System.out.println("En aquest cas agafarem un patró ja que no podem crear una persona perque la classe es abstracta i farem ús dels metodes de persona: \n");
        Patro patro1 = new Patro(empresa, "Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> patro1.getNom(): "+patro1.getNom());
        System.out.println("-> patro1.getCognom(): "+patro1.getCognom());
        System.out.println("-> patro1.getDocument() + patro1.getNumeroDocument(): "+patro1.getDocument()+": "+patro1.getNumeroDocument());
        System.out.println("-> patro1.getAdreça(): "+patro1.getAdreça());
        System.out.println("-> patro1.getTelefon(): "+patro1.getTelefon());
        System.out.println("-> patro1.getEmail(): "+patro1.getEmail());
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Nom de la persona: "+patro1.getNom()+"\nEl canviam per Tofol amb patro1.setNom(\"Tofol\");");
        patro1.setNom("Tòfol");
        System.out.println("Nom de la persona després del canvi: "+patro1.getNom());
        
        System.out.println("\nCognom de la persona: "+patro1.getCognom()+"\nEl canviam per \"Cifre Cerdà\" amb patro1.setCognom(\"Cifre Cerdà\");");
        patro1.setCognom("Cifre Cerdà");
        System.out.println("Cognom de la persona després del canvi: "+patro1.getCognom());
        
        System.out.println("\nTipus i número de document de la persona: "+patro1.getDocument()+": "+patro1.getNumeroDocument()+"\nEl canviam per un tipus NIE i numero \"X3451286F\" amb patro1.setDocument(Document.NIE) i patro1.setNumeroDocument(\"X3451286F\");");
        patro1.setDocument(Document.NIE);
        patro1.setNumeroDocument("X3451286F");
        System.out.println("Tipus i número de document de la persona després del canvi: "+patro1.getDocument()+": "+patro1.getNumeroDocument());
        
        System.out.println("\nAdreça de la persona: "+patro1.getAdreça()+"\nEl canviam per \"C/ maristany nº 7, planta baixa, Can Picafort\" amb patro1.setAdreça(\"C/ maristany nº 7, planta baixa, Can Picafort\");");
        patro1.setAdreça("C/ maristany nº 7, planta baixa, Can Picafort");
        System.out.println("Adreça de la persona després del canvi: "+patro1.getAdreça());
        
        System.out.println("\nTelefon de la persona: "+patro1.getTelefon()+"\nEl canviam per 687452244 amb patro1.setTelefon(687452244);");
        patro1.setTelefon(687452244);
        System.out.println("Telefon de la persona després del canvi: "+patro1.getTelefon());
        
        System.out.println("\nEmail de la persona: "+patro1.getEmail()+"\nEl canviam per \"tofolet24@yahoo.com\" amb patro1.setEmail(\"tofolet24@yahoo.com\");");
        patro1.setEmail("tofolet24@yahoo.com");
        System.out.println("Email de la persona després del canvi: "+patro1.getEmail());
        
        
        System.out.println("\n\n##########################" + "\n## PROVES CLASSE PATRO  ##" + "\n##########################\n");
        System.out.println("\nAquí farem les proves de la part especifica de la classe Patro:");
        
        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> getTitulacio(): "+patro1.getTitulacio());
        System.out.println("-> getCost(): "+patro1.getCost());
        
        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Titulació del patro: "+patro1.getTitulacio()+"\nEl canviam per \"Patró de navegació bàsica\" amb patro1.setTitulacio(\"Patró de navegació bàsica\")");
        patro1.setTitulacio("Patró de navegació bàsica");
        System.out.println("Titulació del patró després del canvi: "+patro1.getTitulacio());
        
        System.out.println("\nCost del patro: "+patro1.getCost()+"\nEl canviam per 450 amb patro1.setCost(450f)");
        patro1.setCost(450f);
        System.out.println("Cost del patró després del canvi: "+patro1.getCost());
        
        
        
        System.out.println("\n\n###########################" + "\n## PROVES CLASSE CLIENT  ##" + "\n###########################\n");
       
        TargetaCredit tarj1 = new TargetaCredit(1111000022224444L, 10, 18, 221);
        TargetaCredit tarj2 = new TargetaCredit(3333444422221111L, 8, 17, 114);
        
        try {
            Client client1 = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com",tarj1);
            System.out.println("\nEn aquest cas el Client no te cap atribut a destacar, nomes te un HashMap en el qual guarda els seus metodes de pagament.");
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> client1.getFormesPagament(): "+client1.getFormesPagament());
            
            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("No té setters pero si te mètodes per afegir o eliminar formes de pagament que veurem a continuació.");
            
            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("Afegim una nova targeta de crèdit al client1 amb client1.afegirFormaPagament(tarj2)");
            client1.afegirFormaPagament(tarj2);
            System.out.println("Comprovam que s'ha afegit: "+client1.getFormesPagament());
            
            System.out.println("Que passaria si afegim un altre cop la mateixa targeta ? Ens retornaria un NoAfegitException el qual imprimirem el missatge:");
            try{
                client1.afegirFormaPagament(tarj2);
            }catch(NoAfegitException e){
                System.out.println(e.getMessage());
            }
            
            System.out.println("\nAra eliminarem la primera targeta que tenia pasant l'identificador d'aquesta");
            client1.eliminarFormaPagament(tarj1.getIdentificador());
            System.out.println(client1.getFormesPagament());
            System.out.println("S'ha eliminat correctament, pero que passaria si intentam eliminar una targeta que no te ? Ens avisaria de que l'identificador de la targeta introduida no coincideix amb cap de les que té el client:");
            try{
                client1.eliminarFormaPagament(tarj1.getIdentificador());
            }catch(NoEliminatException e){
                System.out.println(e.getMessage());
            }
            
            
            Empleat empleat1 = new Empleat(empresa, "Carlos", "Punset", Document.DNI, "78943526F", "C/ Pascual, nº 2, 4b, Inca", 642554411, "Carlos@gmail.com", 1240f, "20/04/2000");
            System.out.println("\n\n############################" + "\n## PROVES CLASSE EMPLEAT  ##" + "\n############################\n");
            
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> empleat1.getDataAlta(): "+empleat1.getDataAlta());
            System.out.println("-> empleat1.getSou(): "+empleat1.getSou());
            
            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Data d'alta de l'empleat: "+empleat1.getDataAlta()+"\nLa canviam per \"18/02/1948\" amb empleat1.setDataAlta(\"18/02/1948\")");
            empleat1.setDataAlta("18/02/1948");
            System.out.println("Data d'alta de l'empleat després del canvi: "+empleat1.getDataAlta());
            
            System.out.println("\nQue passaria si ficam una data erronea o un altra format ? que ens tornaria un DataException: ");
            
            System.out.println("empleat1.setDataAlta(\"HOLA\"); ens tornaria:");
            try{
                empleat1.setDataAlta("HOLA");
            }catch(DataException e){
                System.out.println(e.getMessage());
            }
            
            System.out.println("\nempleat1.setDataAlta(\"50/20-4444\"); ens tornaria:");
            try{
                empleat1.setDataAlta("50/20-4444");
            }catch(DataException e){
                System.out.println(e.getMessage());
            }
            
            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("Si feim empleat1.tornaNomina() ens retornarà un String amb la nòmina de l'empleat en format JSON: ");
            System.out.println(empleat1.tornaNomina());
            
            Comercial comercial1 = new Comercial(empresa, "David", "Ferrer Amoros", Document.DNI, "23451278G", "C/ Xavi nº10, Pollença", 654235241, "david@gmail.com", 300f, "02/04/1999", 7);
            Iot iot1 = new Iot(empresa, 4, 250, 200, true, 1234, "4444x", "Yamaha", "y23", 2, 10, 1, Proposit.VENTA, 20000, true);
            Iot iot2 = new Iot(empresa, 4, 300, 400, true, 4321, "7799x", "Volvo", "v34", 2, 15, 1, Proposit.VENTA, 40000, true);
            Venda venda1 = new Venda(empresa, client1, iot1, Estat.FINALITZADA, comercial1, "12/04/2000", iot1.getPreu());
            Venda venda2 = new Venda(empresa, client1, iot2, Estat.FINALITZADA, comercial1, "12/04/2000", iot2.getPreu());
            
            System.out.println("\n\n##############################" + "\n## PROVES CLASSE COMERCIAL  ##" + "\n##############################\n");
            
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> comercial1.getComissio();"+comercial1.getComissio());
            System.out.println("-> comercial1.getPercentComissio(): "+comercial1.getPercentComissio());
            
            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Comissió del comercial: "+comercial1.getComissio()+"\nLa canviam per 750 amb comercial1.setComissio(750)");
            comercial1.setComissio(750);
            System.out.println("Comissió del comercial després del canvi: "+comercial1.getComissio());

            System.out.println("Percentatge de comissió del comercial: "+comercial1.getPercentComissio()+"\nLa canviam per un 12% amb comercial1.setPercentComissio(12)");
            comercial1.setPercentComissio(12);
            System.out.println("Percentatge de comissió del comercial després del canvi: "+comercial1.getPercentComissio());
            
            System.out.println("\n\n -- PROVES METODES --");    
            System.out.println("L'històric d'operacions del comercial es buida: "+comercial1.getHistoricOperacions());
            System.out.println("\nAfegim dues operacions al comercial:");
            comercial1.afegirOperacio(venda1);
            comercial1.afegirOperacio(venda2);
            System.out.println("L'històric d'operacions del comercial ara té dues operacions: "+comercial1.getHistoricOperacions());
            
            System.out.println("\nAra eliminam l'operacio amb l'identificador 2");
            comercial1.eliminarOperacio(2);
            System.out.println("Mostram la llista de comercial i s'ha eliminat correctament: "+comercial1.getHistoricOperacions());
            
            System.out.println("\nSi volem eliminar una operacio que no esta a la llista ens tornarà un NoEliminatException, i si volem afegir una operació que ja hi es ens tornarà un NoAfegitException.");
            try{
                comercial1.eliminarOperacio(2);
            }catch(NoEliminatException e){
                System.out.println(e.getMessage());
            }
            
            try{
                comercial1.afegirOperacio(venda1);
            }catch(NoAfegitException e){
                System.out.println(e.getMessage());
            }
            
            
            Reparador reparador1 = new Reparador(empresa, "Jose", "Sanchez Rodriguez", Document.DNI, "52164784P", "C/ Olmos nº2, Alcudia", 640224457, "jose@gmail.es", 920f, "07/09/2001", Habilitat.ELECTRICITAT,Habilitat.FUSTERIA);
            System.out.println("\n\n##############################" + "\n## PROVES CLASSE REPARADOR  ##" + "\n##############################\n");
            
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> reparador1.getHabilitats(): "+reparador1.getHabilitats());
            
            
            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("No té setters pero si te mètodes per afegir o eliminar habilitats.");
            
            System.out.println("\n\n -- PROVES METODES --"); 
            System.out.println("Llista d'habilitats del reparador1: "+reparador1.getHabilitats());
            System.out.println("\nAfegim una altra habilitat amb reparador1.afegirHabilitat(Habilitat.VELES)");
            reparador1.afegirHabilitat(Habilitat.VELES);
            System.out.println("S'ha afegit correctament: "+reparador1.getHabilitats());
            
            System.out.println("\nEliminam una habilitat amb reparador1.eliminarHabilitat(Habilitat.VELES)");
            reparador1.eliminarHabilitat(Habilitat.VELES);
            System.out.println("S'ha eliminat correctament: "+reparador1.getHabilitats());
            
            System.out.println("\nEn cas que volguem afegir una habilitat que ja te a la llista, o volem eliminar una habilitat que no té ens tornarà un NoAfegitException o un NoEliminatException.");
  
            try{
                reparador1.afegirHabilitat(Habilitat.ELECTRICITAT);
            }catch(NoAfegitException e){
                System.out.println(e.getMessage());
            }
            try{
                reparador1.eliminarHabilitat(Habilitat.VELES);
            }catch(NoEliminatException e){
                System.out.println(e.getMessage());
            }

        } catch (NoAfegitException | NoEliminatException | DataException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
