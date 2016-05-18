/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.empresa;

import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.operacio.Operacio;
import com.boatinc.persona.Client;
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Empleat;
import java.util.HashMap;

/**
 *
 * @author Arsenik
 */
public class Empresa {
    private HashMap<Integer,Embarcacio> llistaEmbarcacions;
    private HashMap<String,Client> llistaClients;
    private HashMap<String,Empleat> llistaEmpleat;
    private HashMap<String,Patro> llistaPatrons;
    private HashMap<Integer,Operacio> llistaOperacions;
    
}
