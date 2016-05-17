/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.embarcacio.Embarcacio;
import com.sun.security.ntlm.Client;

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
    
    public Operacio(int identificador, Client client, Embarcacio embarcacio, Estat estat) {
        this.identificador = identificador;
        this.client = client;
        this.embarcacio = embarcacio;
        this.estat = estat;
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

    @Override
    public String toString() {
        return "Operacio{" + "identificador=" + identificador + ", client=" + client + ", embarcacio=" + embarcacio + ", estat=" + estat + '}';
    }
    
}
