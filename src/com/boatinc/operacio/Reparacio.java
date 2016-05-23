/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.Client;
import com.boatinc.persona.empleat.Reparador;
import java.util.ArrayList;
import java.util.Date;

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

    public Reparacio(Empresa empresa, String lloc, String dataInici, String dataPrevista, String descripcioAveria, Client client, Embarcacio embarcacio, Estat estat, float preu) throws DataException, NoAfegitException {
        super(client, embarcacio, estat, preu);
        this.lloc = lloc;
        this.dataInici = Eina.creaDate(dataInici);
        this.dataPrevista = Eina.creaDate(dataPrevista);
        if (this.dataInici.after(this.dataPrevista)) {
            throw new DataException("La data d'inici d'una reparació no pot ser posterior a la prevista de finalització.");
        }
        this.descripcioAveria = descripcioAveria;
        this.comentarisReparacio = new ArrayList<>();
        this.empleats = new ArrayList<>();
        if (embarcacio.getProposit() != Proposit.REPARACIO || embarcacio.isDisponibilitat() == false) {
            throw new NoAfegitException("Aquest vaixell no esta disponible per reparar.");
        }
        empresa.afegirOperacions(this);
    }

    public ArrayList<Reparador> getEmpleats() {
        return empleats;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(String dataInici) throws DataException {
        this.dataInici = Eina.creaDate(dataInici);
        if (this.dataInici.after(this.dataPrevista)) {
            throw new DataException("La data d'inici d'una reparació no pot ser posterior a la prevista de finalització.");
        }
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(String dataPrevista) throws DataException {
        this.dataPrevista = Eina.creaDate(dataPrevista);
    }

    public String getDescripcioAveria() {
        return descripcioAveria;
    }

    public void setDescripcioAveria(String descripcioAveria) {
        this.descripcioAveria = descripcioAveria;
    }

    public ArrayList<Comentari> getComentarisReparacio() {
        return comentarisReparacio;
    }

    @Override
    public String toString() {
        return super.toString() + "Reparacio{" + "empleats=" + retornaEmpleats() + "comentarisReparacio=" + comentarisReparacio + ", lloc=" + lloc + ", dataInici=" + dataInici + ", dataPrevista=" + dataPrevista + ", descripcioAveria=" + descripcioAveria + '}';
    }

    //FUNCIONA.

    /*
    Si el reparador esta en la lista, lanza una excepcion y no lo añade.
    Si no lo esta, lo añade a la lista.
     */
    public void afegirEmpleat(Reparador reparador) throws NoAfegitException {
        if (empleats.contains(reparador)) {
            throw new NoAfegitException("Aquest reparador ja esta a la llista.");
        } else {
            empleats.add(reparador);
        }
    }

    //FUNCIONA.
    /*
    Si el reparador esta en la lista, lo elimina de esta.
    Si no lo esta, o la lista esta vacia, lanza una excepcion y no lo elimina.
     */
    public void eliminarEmpleat(Reparador reparador) throws NoEliminatException {
        if (empleats.contains(reparador)) {
            empleats.remove(reparador);
        } else {
            throw new NoEliminatException("No s'ha pogut eliminar l'empleat.");
        }
    }

    //FUNCIONA.
    /*
    Si el comentario esta en la lista, lanza una excepcion y no lo añade.
    Si no lo esta, lo añade a la lista.
     */
    public void afegirComentari(Comentari comentari) throws NoAfegitException {
        if (comentarisReparacio.contains(comentari)) {
            throw new NoAfegitException("Ja existeix aquest comentari.");
        } else {
            comentarisReparacio.add(comentari);
        }
    }

    //FUNCIONA.
    /*
    Busca el ID del comentario, si esta en la lista, lo elimina.
    Si no esta en la lista, lanza una excepcion y no lo elimina.
     */
    public void eliminarComentari(int identificador) throws NoEliminatException {
        for (Comentari i : comentarisReparacio) {
            if (i.getIdentificador() == identificador) {
                comentarisReparacio.remove(i);
            }
        }
    }
    //FUNCIONA.

    /*
    Recorre la lista de empleados de la repacion y devuelve un string concatenado.
     */
    public String retornaEmpleats() {
        String llistatEmpleats = "";
        for (Reparador i : empleats) {
            llistatEmpleats = llistatEmpleats + i.getNom() + ", ";
        }
        return llistatEmpleats;
    }
}
