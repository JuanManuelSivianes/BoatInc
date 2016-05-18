/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.eines.Eina;
import com.boatinc.exceptions.DataException;
import com.boatinc.persona.Document;
import com.boatinc.persona.Persona;
import java.util.Date;

/**
 *
 * @author Joanmi
 */
public class Empleat extends Persona{
    private Date dataAlta;
    private float sou;
    
    public Empleat (String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte){
        super(nom,cognom,document,numeroDocument,adreça,telefon,email);
        this.sou=sou;
                
        try{
            dataAlta=Eina.creaDate(dataContracte);
        }catch(DataException e){
            System.err.println(e.getMessage());
        }
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public float getSou() {
        return sou;
    }

    public void setSou(float sou) {
        this.sou = sou;
    }

    public String tornaNomina(){
        return "hola";
    }
    
    @Override
    public String toString() {
        return "Empleat{" + "dataAlta=" + dataAlta + ", sou=" + sou + '}';
    }
    
    
}
