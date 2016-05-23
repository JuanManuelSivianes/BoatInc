/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.eines.Eina;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.persona.Document;
import com.boatinc.persona.Persona;
import java.util.Date;

/**
 *
 * @author Joanmi
 */
public class Empleat extends Persona {

    private Date dataAlta;
    private float sou;

    public Empleat(Empresa empresa, String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte) throws DataException, NoAfegitException {
        super(nom, cognom, document, numeroDocument, adreça, telefon, email);
        this.sou = sou;
        dataAlta = Eina.creaDate(dataContracte);
        empresa.afegirEmpleat(this);
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) throws DataException {
        this.dataAlta = Eina.creaDate(dataAlta);
    }

    public float getSou() {
        return sou;
    }

    public void setSou(float sou) {
        this.sou = sou;
    }

    public String tornaNomina() {
        return "{\"Nom\": \""+getNom()+"\", \"Cognom\": \""+getCognom()+"\", \"document\": \""+getDocument()+"\", \"Numero Document\": \""+getNumeroDocument()+"\", \"Adreça\": \""+getAdreça()+"\", \"Telefon\": "+getTelefon()+", \"Email\": \""+getEmail()+"\", \"Data d'Alta\": \""+dataAlta+"\", \"Sou\": "+sou+"}";
    }

    @Override
    public String toString() {
        return super.toString();
    }

}