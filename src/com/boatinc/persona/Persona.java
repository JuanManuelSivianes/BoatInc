/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

import java.io.Serializable;

/**
 *
 * @author Joanmi
 */
public class Persona implements Serializable{
    private String nom;
    private String cognom;
    private Document document;
    private String numeroDocument;
    private String adreça;
    private int telefon;
    private String email;
    
    public Persona(String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email){
        this.nom=nom;
        this.cognom=cognom;
        this.document=document;
        this.numeroDocument=numeroDocument;
        this.adreça=adreça;
        this.telefon=telefon;
        this.email=email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getNumeroDocument() {
        return numeroDocument;
    }

    public void setNumeroDocument(String numeroDocument) {
        this.numeroDocument = numeroDocument;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "| Identificador: "+document+": "+numeroDocument+", Nom: "+nom+", Cognoms: "+cognom+" |";
    }
    
    
}
