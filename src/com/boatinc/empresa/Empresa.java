/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.empresa;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.exceptions.NoTrovatException;
import com.boatinc.operacio.Estat;
import com.boatinc.operacio.Lloguer;
import com.boatinc.operacio.Operacio;
import com.boatinc.operacio.Reparacio;
import com.boatinc.persona.Client;
import com.boatinc.persona.Patro;
import com.boatinc.persona.empleat.Empleat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author Arsenik
 */
public class Empresa implements Serializable{
    private String nom;
    private String cif;
    private String adreça;
    private int telefon;
    private HashMap<Integer,Embarcacio> llistaEmbarcacions;
    private HashMap<String,Client> llistaClients;
    private HashMap<String,Empleat> llistaEmpleat;
    private HashMap<String,Patro> llistaPatrons;
    private HashMap<Integer,Operacio> llistaOperacions;

    public Empresa(String nom, String cif, String adreça, int telefon) {
        this.nom=nom;
        this.cif=cif;
        this.adreça=adreça;
        this.telefon=telefon;
        this.llistaEmbarcacions = new HashMap<>();
        this.llistaClients = new HashMap<>();
        this.llistaEmpleat = new HashMap<>();
        this.llistaPatrons = new HashMap<>();
        this.llistaOperacions = new HashMap<>();
    }
    
    public HashMap<Integer, Embarcacio> getLlistaEmbarcacions() {
        return llistaEmbarcacions;
    }

    public HashMap<String, Client> getLlistaClients() {
        return llistaClients;
    }

    public HashMap<String, Empleat> getLlistaEmpleat() {
        return llistaEmpleat;
    }

    public HashMap<String, Patro> getLlistaPatrons() {
        return llistaPatrons;
    }

    public HashMap<Integer, Operacio> getLlistaOperacions() {
        return llistaOperacions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void afegirOperacions(Operacio operacio) throws NoAfegitException{
        if(llistaOperacions.containsKey(operacio.getIdentificador())){
            throw new NoAfegitException("No s'ha pogut afegir la operacio a la empresa.");
        }else{
            llistaOperacions.put(operacio.getIdentificador(), operacio);
        }
    }
    
    public void eliminarOperacio(int identificador) throws NoEliminatException{
        if(llistaOperacions.containsKey(identificador)){
            llistaOperacions.remove(identificador);
        }else{
            throw new NoEliminatException("No s'ha eliminat aquesta operació del llista perque l'identificador no coincideix amb cap de les operacions.");
        }
    }
    
    public void afegirClient(Client client) throws NoAfegitException{
        if(llistaClients.containsKey(client.getNumeroDocument())){
            throw new NoAfegitException("No s'ha pogut inserir el client a la llista perque ja existeix.");
        }else{
            llistaClients.put(client.getNumeroDocument(), client);
        }
    }
    
    public void eliminarClient(String numeroDocument) throws NoEliminatException{
        if(llistaClients.containsKey(numeroDocument)){
            llistaClients.remove(numeroDocument);
        }else{
            throw new NoEliminatException("No s'ha eliminat el client de la llista perque el numero de document no coincideix amb cap dels clients.");
        }
    }
    
    public void afegirEmbarcacio(Embarcacio embarcacio) throws NoAfegitException{
        if(llistaEmbarcacions.containsKey(embarcacio.getNumeroSerie())){
            throw new NoAfegitException("No s'ha pogut inserir l'embarcacio a la llista perque ja existeix.");
        }else{
            llistaEmbarcacions.put(embarcacio.getNumeroSerie(), embarcacio);
        }
    }
    
    public void eliminaEmbarcacio(int numeroSerie) throws NoEliminatException{
        if(llistaEmbarcacions.containsKey(numeroSerie)){
            llistaEmbarcacions.remove(numeroSerie);
        }else{
            throw new NoEliminatException("No s'ha eliminat l'embarcacio de la llista perque el numero de serie no coincideix amb cap de les embarcacions.");
        }
    }
    
    public void afegirEmpleat(Empleat empleat) throws NoAfegitException{
        if(llistaEmpleat.containsKey(empleat.getNumeroDocument())){
            throw new NoAfegitException("No s'ha pogut inserir l'empleat a la llista perque ja existeix.");
        }else{
            llistaEmpleat.put(empleat.getNumeroDocument(), empleat);
        }
    }
    
    public void eliminarEmpleat(String numeroDocument) throws NoEliminatException{
        if(llistaEmpleat.containsKey(numeroDocument)){
            llistaEmpleat.remove(numeroDocument);
        }else{
            throw new NoEliminatException("No s'ha eliminat l'empleat de la llista perque el numero de document no coincideix amb cap dels empleats");
        }
    }
    
    public void afegirPatro(Patro patro) throws NoAfegitException{
        if(llistaPatrons.containsKey(patro.getNumeroDocument())){
            throw new NoAfegitException("No s'ha pogut inserir el patró a la llista perque ja existeix.");
        }else{
            llistaPatrons.put(patro.getNumeroDocument(), patro);
        }
    }
    
    public void eliminarPatro(String numeroDocument) throws NoEliminatException{
        if(llistaPatrons.containsKey(numeroDocument)){
            llistaPatrons.remove(numeroDocument);
        }else{
            throw new NoEliminatException("No s'ha eliminat el patro de la llista perque el numero de document no coincideix amb cap dels patrons");
        }
    }
    
    public ArrayList<String> tornaModelsVenta() throws NoTrovatException{
        ArrayList<String> modelsVenta = new ArrayList<>();
        for(Entry<Integer, Embarcacio> x: llistaEmbarcacions.entrySet()){
            if(x.getValue().getProposit().equals(Proposit.VENTA)){
                modelsVenta.add(x.getValue().getModel());
            }
        }
        if(modelsVenta.isEmpty()){
            throw new NoTrovatException("No s'ha trovat cap model a la venta");
        }
        return modelsVenta;
    }
    
    public ArrayList<String> tornaModelsVentaTipus(String tipusEmbarcacio) throws NoTrovatException{
        ArrayList<String> modelsTipus = new ArrayList<>();
        for(Entry<Integer, Embarcacio> x: llistaEmbarcacions.entrySet()){
            if(x.getValue().getTipusEmbarcacio().equals(tipusEmbarcacio) && x.getValue().getProposit().equals(Proposit.VENTA)){
                modelsTipus.add(x.getValue().getModel());
            }
        }
        if(modelsTipus.isEmpty()){
            throw new NoTrovatException("No s'ha trovat cap model del tipus "+tipusEmbarcacio+".");
        }
        return modelsTipus;                
    }
    
    public ArrayList<String> tornaModelsVentaPreu(float preuMinim, float preuMaxim) throws NoTrovatException{
        ArrayList<String> modelsTipusPreu = new ArrayList<>();
        for(Entry<Integer, Embarcacio> x: llistaEmbarcacions.entrySet()){
            if((x.getValue().getProposit().equals(Proposit.VENTA)) && (x.getValue().getPreu()>=preuMinim) && (x.getValue().getPreu()<=preuMaxim)){
                modelsTipusPreu.add(x.getValue().getModel());
            }
        }
        if(modelsTipusPreu.isEmpty()){
            throw new NoTrovatException("No s'ha trovat cap model entre els preus "+preuMinim+" i "+preuMaxim);
        }
        return modelsTipusPreu;        
    }
    
    public ArrayList<Reparacio> tornaReparacionsEstat(Estat estat) throws NoTrovatException{
        ArrayList<Reparacio> llistaReparacions = new ArrayList<>();
        for(Entry<Integer,Operacio> x: llistaOperacions.entrySet()){
            if(x.getValue().getTipusOperacio().equals("Reparacio") && x.getValue().getEstat().equals(estat)){
                llistaReparacions.add((Reparacio)x.getValue());
            }
        }
        if(llistaReparacions.isEmpty()){
            throw new NoTrovatException("No tenim cap reparació amb l'estat: "+estat);
        }
        return llistaReparacions;
    }
    
    public HashMap<Integer,Reparacio> tornaHistoricReparacions(Embarcacio embarcacio) throws NoTrovatException{
        if(embarcacio.getHistoricReparacions().isEmpty()){
            throw new NoTrovatException("Aquesta embarcacio no ha sofert cap reparació.");
        }
        return embarcacio.getHistoricReparacions();
    }
    
    public HashMap<Integer,Embarcacio> tornaLloguersDisponibles(String dataPrimera, String dataFinal) throws DataException, NoTrovatException{
        HashMap<Integer,Embarcacio> llistaEmbarcacionsDisponibles = new HashMap<>();
        ArrayList<Lloguer> llistaLloguers = new ArrayList<>();
        ArrayList<Embarcacio> llistaEmbarcacionsOcupades = new ArrayList<>();
        Date fechaPrimera;
        Date fechaFinal;
        fechaPrimera=Eina.creaDate(dataPrimera);
        fechaFinal=Eina.creaDate(dataFinal);
        
        if(fechaPrimera.after(fechaFinal)){
            throw new DataException("La primera data no pot ser posterior a la data final.");
        }
        
        
        for(Entry<Integer,Operacio> x: llistaOperacions.entrySet()){
            if(x.getValue().getTipusOperacio().equals("Lloguer")){
                llistaLloguers.add((Lloguer)x.getValue());
            }
        }
        
        for(Lloguer x: llistaLloguers){
            if((fechaPrimera.before(x.getDataFinal())) && (fechaFinal.after(x.getDataInicial()))){
                llistaEmbarcacionsOcupades.add(x.getEmbarcacio());
            }
        }
        
        for(Entry<Integer,Embarcacio> x: llistaEmbarcacions.entrySet()){
            if(llistaEmbarcacionsOcupades.contains(x.getValue())==false){
                llistaEmbarcacionsDisponibles.put(x.getValue().getNumeroSerie(), x.getValue());
            }
        }
        
        if(llistaEmbarcacionsDisponibles.isEmpty()){
            throw new NoTrovatException("No tenim lloguers disponibles en aquest moment.");
        }
        
        return llistaEmbarcacionsDisponibles;
    }
}
