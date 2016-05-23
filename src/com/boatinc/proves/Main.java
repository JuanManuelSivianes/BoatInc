package com.boatinc.proves;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Motor;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.embarcacio.Veler;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Estat;
import com.boatinc.persona.Client;
import com.boatinc.persona.Document;
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Comercial;
import com.boatinc.persona.empleat.Empleat;
import com.boatinc.persona.empleat.Habilitat;
import com.boatinc.persona.empleat.Reparador;
import com.boatinc.persona.pagament.CompteCorrent;
import com.boatinc.persona.pagament.TargetaCredit;
import com.boatinc.persona.pagament.TipusPagament;
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

        
//        inicialitzacio(mare);
//        
//        try {
//            desaDades("src/dadesOB.dat", mare);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        

        mare=(Empresa)recuperaDades("src/dadesOB.dat");
        System.out.println(mare.getLlistaClients());
        System.out.println(mare.getLlistaEmpleat());
        System.out.println(mare.getLlistaPatrons());
        System.out.println(mare.getLlistaEmbarcacions());
        System.out.println(mare.tornaModelsVenta());
        System.out.println(mare.tornaModelsVentaTipus("Iot"));
        System.out.println(mare.tornaModelsVentaPreu(100, 200000));


    }
    
    public static void inicialitzacio(Empresa empresa){
        try{
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
            
            Iot iot1 = new Iot(empresa, 4, 1000, 200, true, 1234, "4444x", "Fairline", "f47", 2, 10, 1, Proposit.LLOGUER, 200000, true);
            Iot iot2 = new Iot(empresa, 4, 800, 400, true, 4321, "7799x", "Bavaria", "v34", 2, 15, 1, Proposit.REPARACIO, 100000, true);
            Iot iot3 = new Iot(empresa, 4, 700, 500, true, 5678, "8800x", "Menorqui", "m67", 2, 20, 1, Proposit.VENTA, 150000, true);
            
            Veler veler1 = new Veler(empresa, 2, 1, 2, 7744, "6688q", "Sunseeker", "x78", 3, 12, 2, Proposit.LLOGUER, 80000, true);
            Veler veler2 = new Veler(empresa, 4, 1, 4, 1414, "4422t", "Catamaran", "c42", 6, 14, 2, Proposit.REPARACIO, 100000, true);
            Veler veler3 = new Veler(empresa, 2, 1, 4, 2424, "3399g", "Beneteau", "j64", 4, 12, 2, Proposit.VENTA, 70000, true);
            
            Motor motor1 = new Motor(empresa, 150, 100, true, 9999, "3214m", "Yamaha", "y23", 2, 8, 1, Proposit.LLOGUER, 20000, true);
            Motor motor2 = new Motor(empresa, 400, 300, true, 1111, "1177n", "Raptor", "r98", 2, 10, 1, Proposit.REPARACIO, 30000, true);
            Motor motor3 = new Motor(empresa, 300, 200, true, 2222, "2234w", "Zodiac", "z46", 2, 12, 1, Proposit.VENTA, 25000, true);
            
        }catch(NoAfegitException | DataException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void desaDades(String desti, Object objecte) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)))){
            out.writeObject(objecte);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static Object recuperaDades(String origen){
        Object nou = new Object();
	try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)))){
            nou=in.readObject();
        }catch(ClassNotFoundException |IOException e){
            System.out.println(e.getMessage());
        }
	return nou;
    }
    
}
