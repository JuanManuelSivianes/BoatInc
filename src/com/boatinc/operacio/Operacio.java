/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.persona.Client;


/**
 *
 * @author Arsenik
 */
public abstract class Operacio {
    private int identificador;
    private static int contador = 1;
    private Client client;
    private Embarcacio embarcacio;
    private Estat estat;
    private float preu;
    private String tipusOperacio;
    
    public Operacio(Client client, Embarcacio embarcacio, Estat estat, float preu) {
        this.identificador = contador;
        this.client = client;
        this.embarcacio = embarcacio;
        this.estat = estat;
        this.preu=preu;
        this.tipusOperacio=this.getClass().getName().substring(21);
        contador++;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Operacio.contador = contador;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Embarcacio getEmbarcacio() {
        return embarcacio;
    }

    public void setEmbarcacio(Embarcacio embarcacio) {
        this.embarcacio = embarcacio;
    }

    public Estat getEstat() {
        return estat;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public String getTipusOperacio() {
        return tipusOperacio;
    }

    public void setTipusOperacio(String tipusOperacio) {
        this.tipusOperacio = tipusOperacio;
    }

    @Override
    public String toString() {
        return "Operacio{" + "identificador=" + identificador + ", client=" + client + ", embarcacio=" + embarcacio + ", estat=" + estat + ", preu=" + preu + ", tipusOperacio=" + tipusOperacio + '}';
    }
}
