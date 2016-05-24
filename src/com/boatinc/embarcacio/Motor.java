/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.embarcacio;

import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.NoAfegitException;

/**
 *
 * @author Xavier
 */
public class Motor extends Embarcacio {
    private int potencia;
    private int capacitatDeposit;
    private boolean motorAuxiliar;

    public Motor(Empresa empresa, int potencia, int capacitatDeposit, boolean motorAuxiliar, int numeroSerie, String matricula, String marca, String model, int manga, int eslora, int calat, Proposit proposit, float preuVenda, boolean disponibilitat) throws NoAfegitException {
        super(empresa,numeroSerie, matricula, marca, model, manga, eslora, calat, proposit, preuVenda, disponibilitat);
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
        return super.toString();
    }
    
    @Override
    public String infoDetallada() {
        super.infoGeneral();
        return super.infoGeneral() + " " + "Motor{" + "\"potencia\"" + ": " + potencia + "," + " \"capacitatDeposit\"" + ": " + capacitatDeposit + "," + " \"motorAuxiliar\"" + ": " + "\"" +motorAuxiliar + "\"" + '}';
    }
}
