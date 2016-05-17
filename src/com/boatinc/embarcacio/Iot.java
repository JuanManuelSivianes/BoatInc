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
    private boolean embarcacioAuxiliar;

    public Iot(int numeroCamarots, int potencia, boolean embarcacioAuxiliar, int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda) {
        super(numeroSerie, matricula, marca, model, manga, eslora, calat, proposit, preuVenda);
        this.numeroCamarots = numeroCamarots;
        this.potencia = potencia;
        this.embarcacioAuxiliar = embarcacioAuxiliar;
    }

    public int getNumeroCamarots() {
        return numeroCamarots;
    }

    public void setNumeroCamarots(int numeroCamarots) {
        this.numeroCamarots = numeroCamarots;
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
    
    
    
}
