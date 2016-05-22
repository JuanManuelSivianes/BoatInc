/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.Document;
import java.util.ArrayList;

/**
 *
 * @author Joanmi
 */
public class Reparador extends Empleat{
    private ArrayList<Habilitat> habilitats;
    
    public Reparador(String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte, Habilitat...habilitatsParam) throws DataException, NoAfegitException{
        super(nom,cognom,document,numeroDocument,adreça,telefon,email,sou,dataContracte);
        habilitats = new ArrayList<>();
        for(Habilitat x: habilitatsParam){
            this.afegirHabilitat(x);
        }
    }

    public ArrayList<Habilitat> getHabilitats() {
        return habilitats;
    }

    
    public void afegirHabilitat(Habilitat habilitat) throws NoAfegitException{
        for(Habilitat x: habilitats){
            if(x.equals(habilitat)){
                throw new NoAfegitException("Aquest reparador ja conté la habilitat: "+x);
            }
        }
        habilitats.add(habilitat);
    }
    
    public void eliminarHabilitat(Habilitat habilitat) throws NoEliminatException{
        if(habilitats.remove(habilitat)==false){
            throw new NoEliminatException("No s'ha eliminat la habilitat "+habilitat+" perque el reparador "+getNom()+" no la té.");
        }
    }

    @Override
    public String toString() {
        return "|ID Empleat: "+super.getDocument()+": "+super.getNumeroDocument()+", Nom: "+super.getNom()+", Cognoms: "+super.getCognom()+"|";
    } 
}
