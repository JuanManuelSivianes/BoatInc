/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.embarcacio.Embarcacio;
import com.sun.security.ntlm.Client;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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

    public Reparacio(String lloc, Date dataInici, Date dataPrevista, String descripcioAveria, float preuTotal, int identificador, Client client, Embarcacio embarcacio, Estat estat) {
        super(identificador, client, embarcacio, estat);
        this.lloc = lloc;
        this.dataInici = dataInici;
        this.dataPrevista = dataPrevista;
        this.descripcioAveria = descripcioAveria;
        this.preuTotal = preuTotal;
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

    //Comprobar funcionamiento.
    public void eliminarComentari(int identificador) {
        Iterator<Comentari> it = comentarisReparacio.iterator();
        while (it.hasNext()) {
            Comentari i = it.next();
            if(comentarisReparacio.contains(i.getIdentificador()==identificador)){
                comentarisReparacio.remove(i);
            }
        }
    }
}
