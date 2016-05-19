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
public class Motor extends Embarcacio {
    private int potencia;
    private int capacitatDeposit;
    private boolean motorAuxiliar;

    public Motor(int potencia, int capacitatDeposit, boolean motorAuxiliar, int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda, boolean disponibilitat) {
        super(numeroSerie, matricula, marca, model, manga, eslora, calat, proposit, preuVenda, disponibilitat);
        this.potencia = potencia;
        this.capacitatDeposit = capacitatDeposit;
        this.motorAuxiliar = motorAuxiliar;
    } 

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCapacitatDeposit() {
        return capacitatDeposit;
    }

    public void setCapacitatDeposit(int capacitatDeposit) {
        this.capacitatDeposit = capacitatDeposit;
    }

    public boolean isMotorAuxiliar() {
        return motorAuxiliar;
    }

    public void setMotorAuxiliar(boolean motorAuxiliar) {
        this.motorAuxiliar = motorAuxiliar;
    }

    @Override
    public String toString() {
        return "Motor{" + "potencia=" + potencia + ", capacitatDeposit=" + capacitatDeposit + ", motorAuxiliar=" + motorAuxiliar + '}';
    }
    
    @Override
    public String infoDetallada() {
        super.infoGeneral();
        return super.infoGeneral() + " " + "Motor{" + "\"potencia\"" + ": " + potencia + "," + " \"capacitatDeposit\"" + ": " + capacitatDeposit + "," + " \"motorAuxiliar\"" + ": " + "\"" +motorAuxiliar + "\"" + '}';
    }
    
}
