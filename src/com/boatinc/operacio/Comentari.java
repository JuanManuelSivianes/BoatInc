/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import java.util.Date;

/**
 *
 * @author Arsenik
 */
public class Comentari {
    private int identificador;
    private static int contador = 1;
    private Date dataComentari;
    private Reparador reparador;
    private String comentari;

    public Comentari(Date dataComentari, Reparador reparador, String comentari) {
        this.dataComentari = dataComentari;
        this.reparador = reparador;
        this.comentari = comentari;
        contador++;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Comentari.contador = contador;
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
    
    
}
