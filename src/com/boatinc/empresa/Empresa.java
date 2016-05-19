/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.empresa;

import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.exceptions.NoAfegitException;
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
    private HashMap<Integer,Operacio> llistaOperacions = new HashMap<>();

    public Empresa() {
        /*this.llistaEmbarcacions = llistaEmbarcacions;
        this.llistaClients = llistaClients;
        this.llistaEmpleat = llistaEmpleat;
        this.llistaPatrons = llistaPatrons;*/
    }
    
    public HashMap<Integer, Embarcacio> getLlistaEmbarcacions() {
        return llistaEmbarcacions;
    }

    public void setLlistaEmbarcacions(HashMap<Integer, Embarcacio> llistaEmbarcacions) {
        this.llistaEmbarcacions = llistaEmbarcacions;
    }

    public HashMap<String, Client> getLlistaClients() {
        return llistaClients;
    }

    public void setLlistaClients(HashMap<String, Client> llistaClients) {
        this.llistaClients = llistaClients;
    }

    public HashMap<String, Empleat> getLlistaEmpleat() {
        return llistaEmpleat;
    }

    public void setLlistaEmpleat(HashMap<String, Empleat> llistaEmpleat) {
        this.llistaEmpleat = llistaEmpleat;
    }

    public HashMap<String, Patro> getLlistaPatrons() {
        return llistaPatrons;
    }

    public void setLlistaPatrons(HashMap<String, Patro> llistaPatrons) {
        this.llistaPatrons = llistaPatrons;
    }

    public HashMap<Integer, Operacio> getLlistaOperacions() {
        return llistaOperacions;
    }
    
    public void afegirOperacions(Operacio operacio) throws NoAfegitException{
        if(llistaOperacions.containsKey(operacio.getIdentificador())){
            throw new NoAfegitException("No s'ha pogut afegir la operacio a la empresa.");
        }else{
            llistaOperacions.put(operacio.getIdentificador(), operacio);
        }
    }
}
