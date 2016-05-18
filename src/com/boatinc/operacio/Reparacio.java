/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.exceptions.DataException;
import com.boatinc.persona.Client;
import com.boatinc.persona.empleat.Reparador;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arsenik
 */
public class Reparacio extends Operacio {

    private ArrayList<Reparador> empleats;
    private ArrayList<Comentari> comentarisReparacio;
    private String lloc;
    private Date dataInici;
    private Date dataPrevista;
    private String descripcioAveria;
    private float preuTotal;

    public Reparacio(String lloc, String dataInici, String dataPrevista, String descripcioAveria, float preuTotal, Client client, Embarcacio embarcacio, Estat estat) {
        super(client, embarcacio, estat);
        this.lloc = lloc;
        try {
            this.dataInici = Eina.creaDate(dataInici);
        } catch (DataException ex) {
            Logger.getLogger(Reparacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.dataPrevista = Eina.creaDate(dataPrevista);
        } catch (DataException ex) {
            Logger.getLogger(Reparacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.descripcioAveria = descripcioAveria;
        this.preuTotal = preuTotal;
        this.comentarisReparacio = new ArrayList<>();
    }

    public ArrayList<Reparador> getEmpleats() {
        return empleats;
    }

    public void setEmpleats(ArrayList<Reparador> empleats) {
        this.empleats = empleats;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getDescripcioAveria() {
        return descripcioAveria;
    }

    public void setDescripcioAveria(String descripcioAveria) {
        this.descripcioAveria = descripcioAveria;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(float preuTotal) {
        this.preuTotal = preuTotal;
    }

    public ArrayList<Comentari> getComentarisReparacio() {
        return comentarisReparacio;
    }

    public void setComentarisReparacio(ArrayList<Comentari> comentarisReparacio) {
        this.comentarisReparacio = comentarisReparacio;
    }

    @Override
    public String toString() {
        return "Reparacio{" + "empleats=" + empleats + ", comentarisReparacio=" + comentarisReparacio + ", lloc=" + lloc + ", dataInici=" + dataInici + ", dataPrevista=" + dataPrevista + ", descripcioAveria=" + descripcioAveria + ", preuTotal=" + preuTotal + '}';
    }

    //Habria que lanzar una excepcion de que el empleado ya esta y no se ha podido añadir.
    public boolean afegirEmpleat(Reparador reparador) {
        if (empleats.contains(reparador)) {
            return false;
        } else {
            empleats.add(reparador);
            return true;
        }
    }

    public boolean eliminarEmpleat(Reparador reparador) {
        if (empleats.contains(reparador)) {
            empleats.remove(reparador);
            return true;
        } else {
            return false;
        }
    }

    //Añadir Exceptions.
    public void afegirComentari(Comentari comentari) {
        comentarisReparacio.add(comentari);
    }

    //FUNCIONA.
    public void eliminarComentari(int identificador) {
        Iterator<Comentari> it = comentarisReparacio.iterator();
        while (it.hasNext()) {
            if(it.next().getIdentificador() == identificador){
                it.remove();
            }
        }
    }
}
