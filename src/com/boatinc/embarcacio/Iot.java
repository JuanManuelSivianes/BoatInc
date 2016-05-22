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
public class Iot extends Embarcacio {
    private int numeroCamarots;
    private int potencia;
    private int autonomia;
    private boolean embarcacioAuxiliar;

    public Iot(int numeroCamarots, int potencia, int autonomia, boolean embarcacioAuxiliar, int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda, boolean disponibilitat) {
        super(numeroSerie, matricula, marca, model, manga, eslora, calat, proposit, preuVenda, disponibilitat);
        this.numeroCamarots = numeroCamarots;
        this.potencia = potencia;
        this.autonomia=autonomia;
        this.embarcacioAuxiliar = embarcacioAuxiliar;
    }

    public int getNumeroCamarots() {
        return numeroCamarots;
    }

    public void setNumeroCamarots(int numeroCamarots) {
        this.numeroCamarots = numeroCamarots;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public boolean isEmbarcacioAuxiliar() {
        return embarcacioAuxiliar;
    }

    public void setEmbarcacioAuxiliar(boolean embarcacioAuxiliar) {
        this.embarcacioAuxiliar = embarcacioAuxiliar;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    @Override
    public String infoDetallada() {
        super.infoGeneral();
        return super.infoGeneral() + " " + "Iot{" + "\"numeroCamarots\"" + ": " + numeroCamarots + "," + " \"potencia\"" + ": " + potencia + "," + " \"embarcacioAuxiliar\"" + ": " + "\"" +embarcacioAuxiliar + "\"" + '}';
    } 
}
