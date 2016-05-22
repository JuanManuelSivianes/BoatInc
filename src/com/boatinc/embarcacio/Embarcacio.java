/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.embarcacio;

import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Reparacio;
import java.util.HashMap;

/**
 *
 * @author Arsenik
 */
public abstract class Embarcacio implements Informacio{
    private int numeroSerie;
    private String matricula;
    private String marca;
    private String model;
    private int manga;
    private int eslora;
    private int calat;
    private String tipusEmbarcacio;
    private Proposit proposit;
    private float preu;
    private HashMap<Integer, Reparacio> historicReparacions;
    private boolean disponibilitat;

    public Embarcacio(int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda, boolean disponibilitat) {
        this.numeroSerie = numeroSerie;
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.manga = manga;
        this.eslora = eslora;
        this.calat = calat;
        this.proposit = proposit;
        this.preu = preuVenda;
        this.tipusEmbarcacio = this.getClass().getName().substring(23);
        historicReparacions = new HashMap<>();
        this.disponibilitat = disponibilitat;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManga() {
        return manga;
    }

    public void setManga(int manga) {
        this.manga = manga;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getCalat() {
        return calat;
    }

    public void setCalat(int calat) {
        this.calat = calat;
    }

    public String getTipusEmbarcacio() {
        return tipusEmbarcacio;
    }

    public Proposit getProposit() {
        return proposit;
    }

    public void setProposit(Proposit proposit) {
        this.proposit = proposit;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public HashMap<Integer, Reparacio> getHistoricReparacions() {
        return historicReparacions;
    }

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    @Override
    public String toString() {
        return "| Numero Serie: "+numeroSerie+", Tipus d'embarcacio: "+tipusEmbarcacio+", Proposit: "+proposit+" |";
    }
    

    @Override
    public String infoGeneral() {
        return "Embarcacio{" + "\"numeroSerie\"" + ": " + numeroSerie + "," + " \"matricula\"" + ": " + "\"" + matricula + "\"" + "," + " \"marca\"" + ": " + "\"" + marca + "\"" + "," + " \"model\"" + ": " + "\"" + model + "\"" + "," + " \"manga\"" + ": " + manga + "," + " \"eslora\"" + ": " + eslora + "," + " \"calat\"" + ": " + calat + "," + " \"tipusEmbarcacio\"" + ": " + "\"" + tipusEmbarcacio + "\"" + "," + " \"proposit\"" + ": " + "\"" + proposit + "\"" + "," + " \"preuVenda\"" + ": " + preu + "," + " \"historicReparacions\"" + ": " + "\"" + historicReparacions + "\"" + "," + " \"disponibilitat\"" + ": " + "\"" + disponibilitat + "\"" + '}';
    }

    @Override
    public String infoDetallada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void afegirReparacio(Reparacio reparacio) throws NoAfegitException{
        if(historicReparacions.containsKey(reparacio.getIdentificador())){
            throw new NoAfegitException("Aquesta embaracació ja té aquesta reparació dins el seur històric.");
        }else{
            historicReparacions.put(reparacio.getIdentificador(), reparacio);
        }
    }
    
    public void eliminarReparacio(Reparacio reparacio) throws NoEliminatException{
        if(historicReparacions.containsKey(reparacio.getIdentificador())){
            historicReparacions.remove(reparacio.getIdentificador());
        }else{
            throw new NoEliminatException("No s'ha pogut eliminar la reparació del històric perque l'embaració no conté aquesta reparació.");
        }
    }
}
