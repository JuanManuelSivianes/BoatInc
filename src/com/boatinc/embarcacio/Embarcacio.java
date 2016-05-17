/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.embarcacio;

import java.util.HashMap;

/**
 *
 * @author Arsenik
 */
public class Embarcacio {
    private int numeroSerie;
    private String matricula;
    private String marca;
    private String model;
    private int manga;
    private int eslora;
    private int calat;
    private String tipusEmbarcacio;
    private Proposit proposit;
    private float preuVenda;
    private HashMap<Integer,Reparacio> historicReparacions;

    public Embarcacio(int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda) {
        this.numeroSerie = numeroSerie;
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.manga = manga;
        this.eslora = eslora;
        this.calat = calat;
        this.proposit = proposit;
        this.preuVenda = preuVenda;
        tipusEmbarcacio = this.getClass().getName();
        historicReparacions = new HashMap<Integer, Object>();
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

    public void setTipusEmbarcacio(String tipusEmbarcacio) {
        this.tipusEmbarcacio = tipusEmbarcacio;
    }

    public Proposit getProposit() {
        return proposit;
    }

    public void setProposit(Proposit proposit) {
        this.proposit = proposit;
    }

    public float getPreuVenda() {
        return preuVenda;
    }

    public void setPreuVenda(float preuVenda) {
        this.preuVenda = preuVenda;
    }

    public HashMap<Integer, Reparacio> getHistoricReparacions() {
        return historicReparacions;
    }

    public void setHistoricReparacions(HashMap<Integer, Reparacio> historicReparacions) {
        this.historicReparacions = historicReparacions;
    }
    
    
    
}
