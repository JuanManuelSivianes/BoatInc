package com.boatinc.proves;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Motor;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.embarcacio.Veler;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.exceptions.NoTrovatException;
import com.boatinc.operacio.Comentari;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Lloguer;
import com.boatinc.operacio.Reparacio;
import com.boatinc.operacio.Venda;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Comercial;
import com.boatinc.persona.empleat.Empleat;
import com.boatinc.persona.empleat.Habilitat;
import static com.boatinc.persona.empleat.Habilitat.*;
import com.boatinc.persona.empleat.Reparador;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Empresa mare = new Empresa("Mare Nostrum", "A26123457", "C/ Bissanyes, nº 7", 902202122);

        
        inicialitzacio(mare);
        
        try {
            desaDades("src/com/boatinc/dades/dadesSistema.dat", mare);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        

        mare=(Empresa)recuperaDades("src/com/boatinc/dades/dadesSistema.dat");
        try{
//            System.out.println(mare.tornaModelsVenta());
//            System.out.println(mare.tornaModelsVentaTipus("Veler"));
//            System.out.println(mare.tornaModelsVentaPreu(2000000, 3000000));
//            System.out.println(mare.tornaReparacionsEstat(Estat.PENDENT));
//            System.out.println(mare.tornaReparacionsEstat(Estat.ATURADA));
//            System.out.println(mare.tornaHistoricReparacions(01010101));
//            System.out.println(mare.tornaEmpleat("23451278G").tornaNomina());
//            System.out.println(mare.tornaLloguersDisponibles("20/05/2016", "30/05/2016"));
            provesEmbarcacio();
            }catch(Exception /*| NoTrovatException | DataException | NoAfegitException*/ e){
            System.out.println(e.getMessage());
            }
           
    }

    public static void inicialitzacio(Empresa empresa) {
        try {
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

            Client client1 = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com", tarj1, tarj2, com1);
            Client client2 = new Client(empresa, "Manel", "Ferrer Mir", Document.DNI, "22222222G", "C/ tucan nº7, Sa Pobla", 600224455, "manel@gmail.com", tarj3);
            Client client3 = new Client(empresa, "Ana", "Johansen", Document.NIE, "X1234567P", "C/ perla nº 1, 2c, Manacor", 600111111, "ana@gmail.com", com2);
            Client client4 = new Client(empresa, "Clara", "Wassenger", Document.PASSAPORT, "O123456", "C/ marisc, nº2, Inca", 712557744, "clara@gmail.com", com4, tarj4);
            Client client5 = new Client(empresa, "Rafel", "Pol Vich", Document.DNI, "23847521G", "C/ mussol, planta baixa, Soller", 600334488, "rafel@yahoo.es", tarj5);
            Client client6 = new Client(empresa, "Pau", "Fernández Mas", Document.DNI, "66771144V", "C/ General Luque, nº23, 4b, Palma", 612784595, "pau@msn.es", com5);
            Client client7 = new Client(empresa, "Joan Miquel", "Fernández Cifre", Document.DNI, "21487652E", "C/ Joan Mas nº1, Vilafranca", 575232565, "joanmiquel@hotmail.com", com6);

            Patro patro1 = new Patro(empresa, "Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);
            Patro patro2 = new Patro(empresa, "Raul", "Valls", Document.NIE, "X3245124C", "C/ Tord, nº4, escalera 2, Inca", 900114455, "raul@msn.es", "Patró embarcació bàsica", 120f);
            Patro patro3 = new Patro(empresa, "Lucia", "Ferrer Sanchez", Document.DNI, "95412422G", "C/ Faissan, nº2, 3c, Soller", 906314575, "lucia@gmail.com", "Patró embarcació de recreo", 170f);

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
            
            Iot iot1 = new Iot(empresa, 4, 1000, 2000, true, 12341234, "4444x", "Fairline", "f47", 3, 10, 1, Proposit.LLOGUER, 200000, true);
            Iot iot2 = new Iot(empresa, 4, 800, 4000, true, 43210000, "7799w", "BAVARIA", "v34", 3, 15, 1, Proposit.REPARACIO, 100000, true);
            Iot iot3 = new Iot(empresa, 4, 700, 5000, true, 56781111, "8800q", "Menorqui", "m67", 3, 20, 1, Proposit.VENTA, 150000, true);
            Iot iot4 = new Iot(empresa, 5, 2000, 5000, true, 78942222, "1100b", "HORIZON", "p110", 6, 33, 2, Proposit.LLOGUER, 3000000, true);
            Iot iot5 = new Iot(empresa, 6, 4000, 20000, true, 33334444, "0147k", "DOMINATOR", "40M", 8, 40, 3, Proposit.VENTA, 4000000, true);
            Iot iot6 = new Iot(empresa, 4, 2000, 10000, true, 98748888, "1111j", "Sunseeker", "116", 5, 35, 2, Proposit.VENTA, 2500000, true);
            Iot iot7 = new Iot(empresa, 6, 4000, 15000, true, 44444444, "6321m", "SANLORENZO", "SL118", 7, 36, 2, Proposit.LLOGUER, 3500000, true);
            Iot iot8 = new Iot(empresa, 5, 4000, 25000, true, 98653214, "4567t", "Benetti", "ILLUSION FB246", 8, 45, 3, Proposit.ALTRES, 0, false);
            Iot iot9 = new Iot(empresa, 4, 2000, 5000, true, 14873487, "7632h", "WESTPORT", "W125", 7, 38, 2, Proposit.VENTA, 1500000, true);
            
            Veler veler1 = new Veler(empresa, 2, 1, 2, 77448888, "6688q", "Sunseeker", "x78", 3, 12, 2, Proposit.LLOGUER, 80000, true);
            Veler veler2 = new Veler(empresa, 4, 1, 4, 14141414, "4422t", "Catamaran", "c42", 6, 14, 2, Proposit.LLOGUER, 100000, true);
            Veler veler3 = new Veler(empresa, 2, 1, 2, 24242424, "3399g", "Beneteau", "j64", 4, 12, 2, Proposit.VENTA, 70000, true);
            Veler veler4 = new Veler(empresa, 2, 1, 2, 78787878, "7468m", "vismara", "v56", 4, 18, 2, Proposit.LLOGUER, 1000000, true);
            Veler veler5 = new Veler(empresa, 2, 1, 4, 01010101, "1433n", "Feeling", "FEELING 52", 4, 15, 2, Proposit.REPARACIO, 800000, true);
            Veler veler6 = new Veler(empresa, 2, 1, 4, 43444344, "7291z", "Gunfleet", "58", 4, 18, 2, Proposit.VENTA, 2000000, true);
            Veler veler7 = new Veler(empresa, 2, 1, 2, 22778899, "8966r", "Beneteau", "55", 4, 17, 2, Proposit.VENTA, 1700000, true);
            Veler veler8 = new Veler(empresa, 4, 1, 4, 11223344, "3388j", "BAVARIA", "OPEN 46", 6, 13, 2, Proposit.VENTA, 3000000, true);
            Veler veler9 = new Veler(empresa, 4, 1, 4, 77771414, "9977d", "LEOPARD", "58", 6, 17, 2, Proposit.VENTA, 3500000, true);
            
            Motor motor1 = new Motor(empresa, 150, 100, true, 99994444, "3214m", "Yamaha", "y23", 2, 8, 1, Proposit.ALTRES, 0, false);
            Motor motor2 = new Motor(empresa, 400, 300, true, 11112222, "1177n", "Raptor", "r98", 2, 10, 1, Proposit.VENTA, 30000, true);
            Motor motor3 = new Motor(empresa, 300, 200, true, 22223333, "2234w", "ZODIAC", "z46", 2, 12, 1, Proposit.VENTA, 25000, true);
            Motor motor4 = new Motor(empresa, 400, 200, true, 44770000, "0170s", "ZODIAC", "FC-580", 2, 6, 1, Proposit.LLOGUER, 10000, true);
            Motor motor5 = new Motor(empresa, 400, 200, true, 21004700, "4301f", "SELVA", "600 PRO", 2, 6, 1, Proposit.REPARACIO, 15000, true);
            Motor motor6 = new Motor(empresa, 600, 300, true, 78001400, "7702n", "SELVA", "700 PRO", 2, 7, 1, Proposit.VENTA, 20000, true);
            Motor motor7 = new Motor(empresa, 200, 150, true, 33222233, "2461v", "MERCURY", "HEAVY DUTY 470", 2, 5, 1, Proposit.ALTRES, 0, false);
            Motor motor8 = new Motor(empresa, 150, 100, true, 14799000, "4962x", "MERCURY", "HEAVY DUTY 415", 1, 4, 1, Proposit.ALTRES, 0, false);
            Motor motor9 = new Motor(empresa, 600, 300, true, 46339900, "6984q", "ASIS", "8M", 2, 8, 1, Proposit.VENTA, 20000, true);
            
            Comentari comentari1 = new Comentari("18/05/2016", reparador1, "Inspeccionat el motor i fet un canvi de peça, pendent de proves.");
            Comentari comentari2 = new Comentari("19/05/2016", reparador2, "El motor funciona correctament, passam averia a finalitzada.");
            Comentari comentari3 = new Comentari("21/05/2016", reparador3, "Inspecció del casc realitzada.");
            Comentari comentari4 = new Comentari("22/05/2016", reparador4, "He detectat una anomalia al costat esquerra del casc.");
            Comentari comentari5 = new Comentari("22/05/2016", reparador4, "La anomalia necesita un producte especial per al seu tractament.");
            Comentari comentari6 = new Comentari("23/05/2016", reparador5, "Passam la reparació a aturada fins que arrivi el material.");
            
            Reparacio reparacio1 = new Reparacio(empresa, "Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", client1, iot2, Estat.INICIADA, 7200, reparador1, reparador2);
            reparacio1.afegirComentari(comentari1);
            reparacio1.afegirComentari(comentari2);
            reparacio1.setEstat(Estat.FINALITZADA);
             
            Reparacio reparacio2 = new Reparacio(empresa, "Sa Pobla", "21/05/2016", "26/05/2016", "Casc romput", client4, veler5, Estat.INICIADA, 5000, reparador3, reparador4, reparador5);
            reparacio2.afegirComentari(comentari3);
            reparacio2.afegirComentari(comentari4);
            reparacio2.afegirComentari(comentari5);
            reparacio2.afegirComentari(comentari6);
            reparacio2.setEstat(Estat.ATURADA);
            
            Reparacio reparacio3 = new Reparacio(empresa, "Port Pollença", "29/05/2016", "20/06/2016", "Manteniment", client3, motor5, Estat.PENDENT, 4500, reparador2, reparador4, reparador5);

            
            Venda venda1 = new Venda(empresa, client3, iot5, Estat.FINALITZADA, comercial1, "10/02/2015", 650);
            iot5.setDisponibilitat(false);
            Venda venda2 = new Venda(empresa, client4, iot6, Estat.FINALITZADA, comercial2, "15/05/2015", 420);
            iot6.setDisponibilitat(false);
            Venda venda3 = new Venda(empresa, client2, veler3, Estat.FINALITZADA, comercial2, "13/09/2015", 570);
            veler3.setDisponibilitat(false);
            Venda venda4 = new Venda(empresa, client4, veler6, Estat.INICIADA, comercial1, "10/02/2016", 840);
            veler6.setDisponibilitat(false);
            Venda venda5 = new Venda(empresa, client6, veler7, Estat.INICIADA, comercial2, "25/04/2016", 630);
            veler7.setDisponibilitat(false);
            Venda venda6 = new Venda(empresa, client5, motor6, Estat.PENDENT, comercial1, "20/06/2016", 280);
            motor6.setDisponibilitat(false);
            Venda venda7 = new Venda(empresa, client4, iot9, Estat.PENDENT, comercial1, "20/06/2016", 740);
            iot9.setDisponibilitat(false);
            
            Lloguer lloguer1 = new Lloguer(empresa, client1, iot1, Estat.FINALITZADA, "10/02/2016", "20/02/2016", 1000);
            Lloguer lloguer2 = new Lloguer(empresa, client1, iot4, Estat.FINALITZADA, "15/02/2016", "17/02/2016", patro2, 300);
            Lloguer lloguer3 = new Lloguer(empresa, client1, iot7, Estat.FINALITZADA, "19/02/2016", "12/03/2016", patro2, 2000);
            Lloguer lloguer4 = new Lloguer(empresa, client1, veler4, Estat.FINALITZADA, "15/03/2016", "22/03/2016", patro1, 1000);
            Lloguer lloguer5 = new Lloguer(empresa, client1, motor4, Estat.INICIADA, "20/05/2016", "30/05/2016", 700);
            motor4.setDisponibilitat(false);
            Lloguer lloguer6 = new Lloguer(empresa, client1, iot1, Estat.INICIADA, "25/05/2016", "30/05/2016", patro2, 450);
            iot1.setDisponibilitat(false);
            Lloguer lloguer7 = new Lloguer(empresa, client1, iot7, Estat.INICIADA, "15/05/2016", "30/05/2016", patro3, 1000);
            iot7.setDisponibilitat(false);
            Lloguer lloguer8 = new Lloguer(empresa, client1, veler4, Estat.INICIADA, "10/05/2016", "20/05/2016", 500);
            veler4.setDisponibilitat(false);
            Lloguer lloguer9 = new Lloguer(empresa, client1, veler2, Estat.PENDENT, "25/07/2016", "10/08/2016", patro3, 1200);
            Lloguer lloguer10 = new Lloguer(empresa, client1, iot4, Estat.PENDENT, "20/07/2016", "22/08/2016", patro1, 1700);
            
        } catch (NoAfegitException | DataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void desaDades(String desti, Object objecte) throws FileNotFoundException, IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)))) {
            out.writeObject(objecte);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object recuperaDades(String origen) {
        Object nou = new Object();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)))) {
            nou = in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
        return nou;
    }

    public static void provesPersona() throws NoAfegitException {
        Empresa empresa = new Empresa("Mare Nostrum", "A26123457", "C/ Bissanyes, nº 7", 902202122);
        System.out.println("############################" + "\n## PROVES CLASSE PERSONA  ##" + "\n############################\n");

        System.out.println("En aquest cas agafarem un patró ja que no podem crear una persona perque la classe es abstracta i farem ús dels metodes de persona: \n");
        Patro patro1 = new Patro(empresa, "Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);

        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> patro1.getNom(): " + patro1.getNom());
        System.out.println("-> patro1.getCognom(): " + patro1.getCognom());
        System.out.println("-> patro1.getDocument() + patro1.getNumeroDocument(): " + patro1.getDocument() + ": " + patro1.getNumeroDocument());
        System.out.println("-> patro1.getAdreça(): " + patro1.getAdreça());
        System.out.println("-> patro1.getTelefon(): " + patro1.getTelefon());
        System.out.println("-> patro1.getEmail(): " + patro1.getEmail());

        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Nom de la persona: " + patro1.getNom() + "\nEl canviam per Tofol amb patro1.setNom(\"Tofol\");");
        patro1.setNom("Tòfol");
        System.out.println("Nom de la persona després del canvi: " + patro1.getNom());

        System.out.println("\nCognom de la persona: " + patro1.getCognom() + "\nEl canviam per \"Cifre Cerdà\" amb patro1.setCognom(\"Cifre Cerdà\");");
        patro1.setCognom("Cifre Cerdà");
        System.out.println("Cognom de la persona després del canvi: " + patro1.getCognom());

        System.out.println("\nTipus i número de document de la persona: " + patro1.getDocument() + ": " + patro1.getNumeroDocument() + "\nEl canviam per un tipus NIE i numero \"X3451286F\" amb patro1.setDocument(Document.NIE) i patro1.setNumeroDocument(\"X3451286F\");");
        patro1.setDocument(Document.NIE);
        patro1.setNumeroDocument("X3451286F");
        System.out.println("Tipus i número de document de la persona després del canvi: " + patro1.getDocument() + ": " + patro1.getNumeroDocument());

        System.out.println("\nAdreça de la persona: " + patro1.getAdreça() + "\nEl canviam per \"C/ maristany nº 7, planta baixa, Can Picafort\" amb patro1.setAdreça(\"C/ maristany nº 7, planta baixa, Can Picafort\");");
        patro1.setAdreça("C/ maristany nº 7, planta baixa, Can Picafort");
        System.out.println("Adreça de la persona després del canvi: " + patro1.getAdreça());

        System.out.println("\nTelefon de la persona: " + patro1.getTelefon() + "\nEl canviam per 687452244 amb patro1.setTelefon(687452244);");
        patro1.setTelefon(687452244);
        System.out.println("Telefon de la persona després del canvi: " + patro1.getTelefon());

        System.out.println("\nEmail de la persona: " + patro1.getEmail() + "\nEl canviam per \"tofolet24@yahoo.com\" amb patro1.setEmail(\"tofolet24@yahoo.com\");");
        patro1.setEmail("tofolet24@yahoo.com");
        System.out.println("Email de la persona després del canvi: " + patro1.getEmail());

        System.out.println("\n\n##########################" + "\n## PROVES CLASSE PATRO  ##" + "\n##########################\n");
        System.out.println("\nAquí farem les proves de la part especifica de la classe Patro:");

        System.out.println("-- PROVES GETTERS --");
        System.out.println("-> getTitulacio(): " + patro1.getTitulacio());
        System.out.println("-> getCost(): " + patro1.getCost());

        System.out.println("\n\n-- PROVES SETTERS --");
        System.out.println("Titulació del patro: " + patro1.getTitulacio() + "\nEl canviam per \"Patró de navegació bàsica\" amb patro1.setTitulacio(\"Patró de navegació bàsica\")");
        patro1.setTitulacio("Patró de navegació bàsica");
        System.out.println("Titulació del patró després del canvi: " + patro1.getTitulacio());

        System.out.println("\nCost del patro: " + patro1.getCost() + "\nEl canviam per 450 amb patro1.setCost(450f)");
        patro1.setCost(450f);
        System.out.println("Cost del patró després del canvi: " + patro1.getCost());

        System.out.println("\n\n###########################" + "\n## PROVES CLASSE CLIENT  ##" + "\n###########################\n");

        TargetaCredit tarj1 = new TargetaCredit(1111000022224444L, 10, 18, 221);
        TargetaCredit tarj2 = new TargetaCredit(3333444422221111L, 8, 17, 114);

        try {
            Client client1 = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com", tarj1);
            System.out.println("\nEn aquest cas el Client no te cap atribut a destacar, nomes te un HashMap en el qual guarda els seus metodes de pagament.");
            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> client1.getFormesPagament(): " + client1.getFormesPagament());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("No té setters pero si te mètodes per afegir o eliminar formes de pagament que veurem a continuació.");

            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("Afegim una nova targeta de crèdit al client1 amb client1.afegirFormaPagament(tarj2)");
            client1.afegirFormaPagament(tarj2);
            System.out.println("Comprovam que s'ha afegit: " + client1.getFormesPagament());

            System.out.println("Que passaria si afegim un altre cop la mateixa targeta ? Ens retornaria un NoAfegitException el qual imprimirem el missatge:");
            try {
                client1.afegirFormaPagament(tarj2);
            } catch (NoAfegitException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nAra eliminarem la primera targeta que tenia pasant l'identificador d'aquesta");
            client1.eliminarFormaPagament(tarj1.getIdentificador());
            System.out.println(client1.getFormesPagament());
            System.out.println("S'ha eliminat correctament, pero que passaria si intentam eliminar una targeta que no te ? Ens avisaria de que l'identificador de la targeta introduida no coincideix amb cap de les que té el client:");
            try {
                client1.eliminarFormaPagament(tarj1.getIdentificador());
            } catch (NoEliminatException e) {
                System.out.println(e.getMessage());
            }

            Empleat empleat1 = new Empleat(empresa, "Carlos", "Punset", Document.DNI, "78943526F", "C/ Pascual, nº 2, 4b, Inca", 642554411, "Carlos@gmail.com", 1240f, "20/04/2000");
            System.out.println("\n\n############################" + "\n## PROVES CLASSE EMPLEAT  ##" + "\n############################\n");

            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> empleat1.getDataAlta(): " + empleat1.getDataAlta());
            System.out.println("-> empleat1.getSou(): " + empleat1.getSou());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Data d'alta de l'empleat: " + empleat1.getDataAlta() + "\nLa canviam per \"18/02/1948\" amb empleat1.setDataAlta(\"18/02/1948\")");
            empleat1.setDataAlta("18/02/1948");
            System.out.println("Data d'alta de l'empleat després del canvi: " + empleat1.getDataAlta());

            System.out.println("\nQue passaria si ficam una data erronea o un altra format ? que ens tornaria un DataException: ");

            System.out.println("empleat1.setDataAlta(\"HOLA\"); ens tornaria:");
            try {
                empleat1.setDataAlta("HOLA");
            } catch (DataException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nempleat1.setDataAlta(\"50/20-4444\"); ens tornaria:");
            try {
                empleat1.setDataAlta("50/20-4444");
            } catch (DataException e) {
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
            System.out.println("-> comercial1.getComissio();" + comercial1.getComissio());
            System.out.println("-> comercial1.getPercentComissio(): " + comercial1.getPercentComissio());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("Comissió del comercial: " + comercial1.getComissio() + "\nLa canviam per 750 amb comercial1.setComissio(750)");
            comercial1.setComissio(750);
            System.out.println("Comissió del comercial després del canvi: " + comercial1.getComissio());

            System.out.println("Percentatge de comissió del comercial: " + comercial1.getPercentComissio() + "\nLa canviam per un 12% amb comercial1.setPercentComissio(12)");
            comercial1.setPercentComissio(12);
            System.out.println("Percentatge de comissió del comercial després del canvi: " + comercial1.getPercentComissio());

            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("L'històric d'operacions del comercial conté dues operacions: " + comercial1.getHistoricOperacions());
            System.out.println("\nAixò es degut a que quan cream una operació (dues creades anteriorment) el comercial té un mètode per inserir operacions que l'objecte Venta crida quan en cream un.");

            System.out.println("\nAra eliminam l'operacio amb l'identificador 2");
            comercial1.eliminarOperacio(venda2.getIdentificador());
            System.out.println("Mostram la llista de comercial i s'ha eliminat correctament: " + comercial1.getHistoricOperacions());

            System.out.println("\nSi volem eliminar una operacio que no està a la llista ens tornarà un NoEliminatException, i si volem afegir una operació que ja hi es ens tornarà un NoAfegitException.");
            try {
                comercial1.eliminarOperacio(2);
            } catch (NoEliminatException e) {
                System.out.println(e.getMessage());
            }

            try {
                comercial1.afegirOperacio(venda1);
            } catch (NoAfegitException e) {
                System.out.println(e.getMessage());
            }

            Reparador reparador1 = new Reparador(empresa, "Jose", "Sanchez Rodriguez", Document.DNI, "52164784P", "C/ Olmos nº2, Alcudia", 640224457, "jose@gmail.es", 920f, "07/09/2001", Habilitat.ELECTRICITAT, Habilitat.FUSTERIA);
            System.out.println("\n\n##############################" + "\n## PROVES CLASSE REPARADOR  ##" + "\n##############################\n");

            System.out.println("-- PROVES GETTERS --");
            System.out.println("-> reparador1.getHabilitats(): " + reparador1.getHabilitats());

            System.out.println("\n\n-- PROVES SETTERS --");
            System.out.println("No té setters pero si te mètodes per afegir o eliminar habilitats.");

            System.out.println("\n\n -- PROVES METODES --");
            System.out.println("Llista d'habilitats del reparador1: " + reparador1.getHabilitats());
            System.out.println("\nAfegim una altra habilitat amb reparador1.afegirHabilitat(Habilitat.VELES)");
            reparador1.afegirHabilitat(Habilitat.VELES);
            System.out.println("S'ha afegit correctament: " + reparador1.getHabilitats());

            System.out.println("\nEliminam una habilitat amb reparador1.eliminarHabilitat(Habilitat.VELES)");
            reparador1.eliminarHabilitat(Habilitat.VELES);
            System.out.println("S'ha eliminat correctament: " + reparador1.getHabilitats());

            System.out.println("\nEn cas que volguem afegir una habilitat que ja te a la llista, o volem eliminar una habilitat que no té ens tornarà un NoAfegitException o un NoEliminatException.");

            try {
                reparador1.afegirHabilitat(Habilitat.ELECTRICITAT);
            } catch (NoAfegitException e) {
                System.out.println(e.getMessage());
            }
            try {
                reparador1.eliminarHabilitat(Habilitat.VELES);
            } catch (NoEliminatException e) {
                System.out.println(e.getMessage());
            }

        } catch (NoAfegitException | NoEliminatException | DataException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public static void provesEmbarcacio() throws NoAfegitException, NoEliminatException{
        try {
            Empresa empresa = new Empresa("DevelopersNautics", "", "", 677888888);
            System.out.println("############################" + "\n## PROVES CLASSE EMBARCACIO  ##" + "\n############################\n");
            
            System.out.println("En aquest cas agafarem un iot ja que no podem crear una embarcació perque la classe es abstracta i farem ús dels metodes de embarcacio: \n");
            Iot iot1 = new Iot(empresa,4, 1000, 200, true, 1234, "4444x", "Fairline", "Targa", 2, 10, 1, Proposit.LLOGUER, 200000, true);
            
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
            Veler veler1 = new Veler(empresa,2, 1, 2, 7744, "6688q", "Sunseeker", "x78", 3, 12, 2, Proposit.LLOGUER, 80000, true);
            
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
            Motor motor1 = new Motor(empresa,150, 100, true, 9999, "3214m", "Yamaha", "y23", 2, 8, 1, Proposit.LLOGUER, 20000, true);
            
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
            
            System.out.println("\n\n -- PROVES METODES --");
            
            Iot iot2 = new Iot(empresa, 4, 800, 4000, true, 43210000, "7799w", "BAVARIA", "v34", 3, 15, 1, Proposit.REPARACIO, 100000, true);
            Iot iot5 = new Iot(empresa, 6, 4000, 20000, true, 33334444, "0147k", "DOMINATOR", "40M", 8, 40, 3, Proposit.REPARACIO, 4000000, true);
            Iot iot6 = new Iot(empresa, 4, 2000, 10000, true, 98748888, "1111j", "Sunseeker", "116", 5, 35, 2, Proposit.VENTA, 2500000, true);
            
            TargetaCredit tarj1 = new TargetaCredit(1111000022224444L, 10, 18, 221);
            TargetaCredit tarj2 = new TargetaCredit(3333444422221111L, 8, 17, 114);
            TargetaCredit tarj3 = new TargetaCredit(3333111177776666L, 4, 18, 334);
            
            CompteCorrent com1 = new CompteCorrent("ES1200001111887777777777");
            
            Client client1 = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com",tarj1,tarj2,com1);
            Client client2 = new Client(empresa, "Manel", "Ferrer Mir", Document.DNI, "22222222G", "C/ tucan nº7, Sa Pobla", 600224455, "manel@gmail.com",tarj3);
            
            Reparador reparador1 = new Reparador(empresa, "Jose", "Sanchez Rodriguez", Document.DNI, "52164784P", "C/ Olmos nº2, Alcudia", 640224457, "jose@gmail.es", 920f, "07/09/2001", Habilitat.ELECTRICITAT,Habilitat.FUSTERIA);
            Reparador reparador2 = new Reparador(empresa, "Manolo", "Cruz Dias", Document.DNI, "35664127K", "C/ San Martin nº13, Palma", 625449975, "manolo@msn.es", 920f, "07/09/2001", Habilitat.VELES,Habilitat.FUSTERIA);
            
            Reparacio reparacio1 = new Reparacio(empresa, "Alcudia", "18/05/2016", "20/05/2016", "Motor averiat", client1, iot5, Estat.PENDENT, 1000);
            Reparacio reparacio2 = new Reparacio(empresa, "Sa Pobla", "21/05/2016", "24/05/2016", "Casc romput", client2, iot2, Estat.PENDENT, 2000);
            
            Comentari comentari1 = new Comentari("18/05/2016", reparador1, "Motor romput");
            Comentari comentari2 = new Comentari("19/05/2016", reparador2, "Reparació realitzada");
            
            System.out.println("Quan cream reparacions el constructor d'aquesta ja s'encarrega d'inserir la reparació en la embarcacio corresponent.");
            System.out.println(iot5.getHistoricReparacions());
            System.out.println("Com podem observar la embarcacio ja les  té inserides en el seu històric.");
            
            
            try{
                System.out.println("\nSi volem afegir la mateixa reparació dins el llista botara una excepció (NoAfegitException)");
                iot5.afegirReparacio(reparacio1);
            }catch(NoAfegitException e){
                e.getMessage();
            }

            

            
             
            System.out.println("\nEliminam una reparació de la llista de reparacions: iot5.eliminarReparacio(reparacio2);");
            iot5.eliminarReparacio(reparacio1);
            

            try{
                System.out.println("Si intentam eliminar una reparació que no te asociada aquesta embarcació botara una excepció (NoEliminatException)");
                iot5.eliminarReparacio(reparacio1);
            }catch(NoEliminatException e){
                e.getMessage();
            }

            
            System.out.println();
            
            System.out.println("Mostrar la informació general d'una embarcació: (iot5.infoGeneral())");
            System.out.println(iot5.infoGeneral());
            
            System.out.println();
            
            System.out.println("Mostrar la informació detallada d'una embarcació: (iot5.infoDetallada())");
            System.out.println(iot5.infoDetallada());
            
        } catch (DataException | NoAfegitException | NoEliminatException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    public static void provesOperacions() {
        try {
            Empresa boatsINC = new Empresa("Mare Nostrum", "A26123457", "C/ Bissanyes, nº 7", 902202122);
            TargetaCredit tarjeta1 = new TargetaCredit(01, 02, 2018, 123);
            CompteCorrent compte1 = new CompteCorrent("123456789");
            Client alfonso = new Client(boatsINC, "Alfonso", "Perez", Document.DNI, "11111111B", "C/ mar nº 2", 600000002, "alfonsoperez@gmail.com", tarjeta1, compte1);
            Client toni = new Client(boatsINC, "Toni", "Dalmau", Document.DNI, "11111111A", "C/ mar nº 1", 600000001, "tonidalmau@gmail.com", tarjeta1, compte1);
            Veler veler1 = new Veler(boatsINC, 2, 4, 1, 000001, "AAA01", "Concordia", "AIR", 10, 20, 5, Proposit.LLOGUER, 50000, true);
            Motor motor1 = new Motor(boatsINC, 350, 2, true, 000005, "AAA03", "BMW", "A450", 10, 2, 3, Proposit.VENTA, 30000, true);
            Iot iot1 = new Iot(boatsINC, 2, 100, 200, true, 000003, "AAA02", "Suiter", "LUXUS", 20, 10, 20, Proposit.REPARACIO, 80000, true);
            Reparador jose = new Reparador(boatsINC, "Jose", "delafuente", Document.DNI, "11111111E", "C/ mar nº 5", 600000005, "josedelafuente@gmail.com", 600f, "02/05/2016", FUSTERIA, VELES);
            Reparador juan = new Reparador(boatsINC, "Juan", "perico", Document.DNI, "11111111F", "C/ mar nº 6", 600000006, "juanperico@gmail.com", 900f, "05/05/2014", FONTANERIA, ELECTRICITAT, FIBRA_DE_VIDRE);
            Patro bernat = new Patro(boatsINC, "Bernat", "Sabater", Document.DNI, "11111111G", "C/ mar nº 7", 600000007, "bernatsabater@gmail.com", "Patron de 1ª", 250f);
            Patro jenny = new Patro(boatsINC, "Jenny", "Valencia", Document.DNI, "11111111H", "C/ mar nº 8", 600000008, "jenyvalencia@gmail.com", "Patron de 2ª", 150f);
            Comercial paco = new Comercial(boatsINC, "Paco", "Jemez", Document.DNI, "11111111D", "C/ mar nº 4", 600000004, "pacojemez@gmail.com", 1000f, "01/01/2016", 10);
            Comercial luis = new Comercial(boatsINC, "Luis", "Bajon", Document.DNI, "11111111I", "C/ mar nº 9", 600000009, "luisbajon@gmail.com", 1000f, "02/01/2016", 10);

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
            } catch (NoAfegitException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("\nAra eliminarem el treballador que tenia pasant l'objecte d'aquest");
            reparacio1.eliminarEmpleat(juan);
            System.out.println(reparacio1.getEmpleats());
            System.out.println("S'ha eliminat correctament, pero que passaria si intentam eliminar un treballador que no te ? Ens avisaria de que el treballador introduït no coincideix amb cap de les que té la reparacio:");
            try {
                reparacio1.eliminarEmpleat(juan);
            } catch (NoEliminatException ex) {
                ex.getMessage();
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
            reparacio1.eliminarComentari(comentari1.getIdentificador());
            System.out.println(reparacio1.getComentarisReparacio());

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
        
        
