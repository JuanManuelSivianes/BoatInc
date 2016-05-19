/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.main;

import com.boatinc.embarcacio.Iot;
import com.boatinc.embarcacio.Proposit;
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

/**
 *
 * @author Joanmi
 */
public class MainJoanmi {
    public static void main(String[] args) {
        
        try{
            Client client1 = new Client("Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com");
            Client client2 = new Client("Manel", "Ferrer Mir", Document.DNI, "22222222G", "C/ tucan nº7, Sa Pobla", 600224455, "manel@gmail.com");
            Client client3 = new Client("Ana", "Johansen", Document.NIE, "X1234567P", "C/ perla nº 1, 2c, Manacor", 600111111, "ana@gmail.com");
            Client client4 = new Client("Clara", "Wassenger", Document.PASSAPORT, "O123456", "C/ marisc, nº2, Inca", 712557744, "clara@gmail.com");
            Client client5 = new Client("Rafel", "Pol Vich", Document.DNI, "23847521G", "C/ mussol, planta baixa, Soller", 600334488, "rafel@yahoo.es");
            Client client6 = new Client("Pau", "Fernández Mas", Document.DNI, "66771144V", "C/ General Luque, nº23, 4b, Palma", 612784595, "pau@msn.es");
            Client client7 = new Client("Joan Miquel", "Fernández Cifre", Document.DNI, "21487652E", "C/ Joan Mas nº1, Vilafranca", 575232565, "joanmiquel@hotmail.com");
            
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
            
            client1.afegirFormaPagament(tarj1);
            client1.afegirFormaPagament(tarj2);
            client1.afegirFormaPagament(com1);
            client2.afegirFormaPagament(tarj3);
            client3.afegirFormaPagament(com2);
            client4.afegirFormaPagament(com4);
            client4.afegirFormaPagament(tarj4);
            client5.afegirFormaPagament(tarj5);
            client6.afegirFormaPagament(com5);
            client7.afegirFormaPagament(com6);
                     
            Patro patro1 = new Patro("Josep", "Ferriol Crestatx", Document.DNI, "3344665547C", "C/ Colomi, planta baixa, Puigpunyent", 902202122, "josepet@gmail.com", "Patró de Iot", 200f);
            Patro patro2 = new Patro("Raul", "Valls", Document.NIE, "X3245124C", "C/ Tord, nº4, escalera 2, Inca", 900114455, "raul@msn.es", "Patró embarcació bàsica", 120f);
            Patro patro3 = new Patro("Lucia", "Ferrer Sanchez", Document.DNI, "9545512422G", "C/ Faissan, nº2, 3c, Soller", 906314575, "lucia@gmail.com", "Patró embarcació de recreo", 170f);
            
            Empleat empleat1 = new Empleat("Carlos", "Punset", Document.DNI, "78943526F", "C/ Pascual, nº 2, 4b, Inca", 642554411, "Carlos@gmail.com", 1240f, "20/04/2000");
            Empleat empleat2 = new Empleat("Elena", "Pascual", Document.DNI, "22465714J", "C/ Mondragó, atic, Inca", 640224488, "Elena@gmail.com", 1024f, "12/01/2002");
            Empleat empleat3 = new Empleat("Guillem", "Fassina", Document.NIE, "X3485614F", "C/ Roca nº 9, Inca", 632448877, "guillem@gmail.com", 1160f, "15/05/2001");
            
            Comercial comercial1 = new Comercial("David", "Ferrer Amoros", Document.DNI, "23451278G", "C/ Xavi nº10, Pollença", 654235241, "david@gmail.com", 300f, "02/04/1999", 7);
            Comercial comercial2 = new Comercial("Reimond", "Powell", Document.NIE, "X3544124P", "Avinguda Reus nº10, Algaida", 620348544, "Reimond@gmail.com", 400f, "20/09/2000", 9);
            
            // reparadors
            
            
            Iot iot1 = new Iot(4, 200, true, 1234, "4444x", "Yamaha", "y23", 2, 10, 1, Proposit.LLOGUER, 20000, true);
            
            
            Venda venda1 = new Venda(client1, iot1, Estat.FINALITZADA, comercial1, "20/04/2016", iot1.getPreuVenda());
            Venda venda2 = new Venda(client1, iot1, Estat.FINALITZADA, comercial1, "20/04/2016", iot1.getPreuVenda());
                    
            
            
            
            
            CompteCorrent com = new CompteCorrent("NUMEROIBAN");
            TargetaCredit tar = new TargetaCredit(111111111111L, 10, 2000, 221);
            Reparador pep = new Reparador("Pepet", "Riutort", Document.DNI, "22224444", "C/ coral", 902202122, "sivianes@gmail.com", 20.00f, "12/10/2014");
            
            System.out.println(pep.getHabilitats());
            pep.afegirHabilitat(Habilitat.MECANICA);
            System.out.println(pep.getHabilitats());
            
            
            client1.afegirFormaPagament(tar);
            client1.afegirFormaPagament(com);
            
            System.out.println(client1.getFormesPagament());
            
            client1.eliminarFormaPagament(com.getIdentificador());
            
            System.out.println(client1.getFormesPagament());
            
            comercial1.afegirOperacio(venda1);
            System.out.println(comercial1.getHistoricOperacions());
            System.out.println(comercial1.getComissio());
            comercial1.eliminarOperacio(venda1.getIdentificador());
            System.out.println(comercial1.getComissio());

            

            

            
        }catch(NoAfegitException | DataException | NoEliminatException e){
            System.err.println(e.getMessage());
        }
    }
    
}
