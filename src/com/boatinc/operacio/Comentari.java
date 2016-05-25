/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.eines.Eina;
import com.boatinc.exceptions.DataException;
import com.boatinc.persona.empleat.Reparador;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Arsenik
 */
public class Comentari implements Serializable{

    private int identificador;
    private static int contador = 1;
    private Date dataComentari;
    private Reparador reparador;
    private String comentari;

    public Comentari(String dataComentari, Reparador reparador, String comentari) throws DataException {
        this.identificador = contador;
        this.dataComentari = Eina.creaDate(dataComentari);
        this.reparador = reparador;
        this.comentari = comentari;
        contador++;
    }

    public int getIdentificador() {
        return identificador;
    }

    public Date getDataComentari() {
        return dataComentari;
    }

    public void setDataComentari(Date dataComentari) {
        this.dataComentari = dataComentari;
    }

    public Reparador getReparador() {
        return reparador;
    }

    public void setReparador(Reparador reparador) {
        this.reparador = reparador;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    @Override
    public String toString() {
        return "Comentari{" + "dataComentari=" + dataComentari + ", reparador=" + reparador.getNom() + ", comentari=" + comentari + '}';
    }

}
