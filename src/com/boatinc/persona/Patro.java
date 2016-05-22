/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

/**
 *
 * @author Joanmi
 */
public class Patro extends Persona{
    private String titulacio;
    private float cost;
    
    public Patro(String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, String titulacio, float cost){
        super(nom,cognom,document,numeroDocument,adreça,telefon,email);
        this.titulacio=titulacio;
        this.cost=cost;
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
        return "|ID Patró: "+super.getDocument()+": "+super.getNumeroDocument()+", Nom: "+super.getNom()+", Cognoms: "+super.getCognom()+"|";
    }
}
