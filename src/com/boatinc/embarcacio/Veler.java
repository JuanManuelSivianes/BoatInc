/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.embarcacio;

/**
 *
 * @author Xavier
 */
public class Veler extends Embarcacio {
    private int numeroCascs;
    private int numeroPals;
    private int numeroCabines;

    public Veler(int numeroCascs, int numeroPals, int numeroCabines, int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda, boolean disponibilitat) {
        super(numeroSerie, matricula, marca, model, manga, eslora, calat, proposit, preuVenda, disponibilitat);
        this.numeroCascs = numeroCascs;
        this.numeroPals = numeroPals;
        this.numeroCabines = numeroCabines;
    }

    public int getNumeroCascs() {
        return numeroCascs;
    }

    public void setNumeroCascs(int numeroCascs) {
        this.numeroCascs = numeroCascs;
    }

    public int getNumeroPals() {
        return numeroPals;
    }

    public void setNumeroPals(int numeroPals) {
        this.numeroPals = numeroPals;
    }

    public int getNumeroCabines() {
        return numeroCabines;
    }

    public void setNumeroCabines(int numeroCabines) {
        this.numeroCabines = numeroCabines;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public String infoDetallada() {
        super.infoGeneral();
        return super.infoGeneral() + " " + "Veler{" + "\"numeroCascs\"" + ": " + numeroCascs + "," + " \"numeroPals\"" + ": " + numeroPals + "," + " \"numeroCabines\"" + ": " + "\"" +numeroCabines + "\"" + '}';
    }
    
}
