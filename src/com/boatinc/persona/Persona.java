/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

import com.boatinc.eines.Eina;
import com.boatinc.exceptions.DataException;
import java.util.Date;

/**
 *
 * @author Joanmi
 */
public class Persona {
    private String nom;
    private String cognom;
    private Date fecha;
    
    public Persona(String nom, String cognom, String fecha){
        this.nom=nom;
        this.cognom=cognom;
        try{
            this.fecha=Eina.creaDate(fecha);
        }catch(DataException e){
            System.out.println(e.getMessage());
        }
        
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", cognom=" + cognom + ", fecha=" + fecha + '}';
    }  
}
