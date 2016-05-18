/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.exceptions.DataException;
import com.boatinc.persona.Document;
import java.util.ArrayList;

/**
 *
 * @author Joanmi
 */
public class Reparador extends Empleat{
    private ArrayList<Habilitat> habilitats;
    
    public Reparador(String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte) throws DataException{
        super(nom,cognom,document,numeroDocument,adreça,telefon,email,sou,dataContracte);
        habilitats = new ArrayList<>();
    }

    
    
    
    public void afegirHabilitat(Habilitat habilitat){
        habilitats.add(habilitat);
    }
    
    public void eliminarHabilitat(Habilitat habilitat){
        habilitats.remove(habilitat);
    }
    
    
    
    
    
    
    @Override
    public String toString() {
        return "Reparador{" +super.toString()+ "habilitats=" + habilitats + '}';
    }
    
    
}
