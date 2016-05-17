/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.pagament;

/**
 *
 * @author Joanmi
 */
public abstract class TipusPagament {
    private int identificador;
    private static int contador=1;
    
    public TipusPagament(){
        this.identificador=contador;
        contador++;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "TipusPagament{" + "identificador=" + identificador + '}';
    } 
}
