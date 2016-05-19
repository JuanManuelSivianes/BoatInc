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
    public int hashCode() {
        return this.identificador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipusPagament other = (TipusPagament) obj;
        if (this.identificador != other.identificador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipusPagament{" + "identificador=" + identificador + '}';
    } 
}
