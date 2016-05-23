/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.NoAfegitException;

/**
 *
 * @author Joanmi
 */
public class Patro extends Persona{
    private String titulacio;
    private float cost;
    
    public Patro(Empresa empresa, String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, String titulacio, float cost) throws NoAfegitException{
        super(nom,cognom,document,numeroDocument,adreça,telefon,email);
        this.titulacio=titulacio;
        this.cost=cost;
        empresa.afegirPatro(this);
    }

    public String getTitulacio() {
        return titulacio;
    }

    public void setTitulacio(String titulacio) {
        this.titulacio = titulacio;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
