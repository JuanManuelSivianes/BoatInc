/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.operacio.Operacio;
import com.boatinc.persona.Document;
import java.util.HashMap;

/**
 *
 * @author Joanmi
 */
public class Comercial extends Empleat{
    private double comissio;
    private int percentComissio;
    private HashMap<Integer, Operacio> historicOperacions;
    
    public Comercial (String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte, int percentComissio){
        super(nom,cognom,document,numeroDocument,adreça,telefon,email,sou,dataContracte);
        this.comissio=0;
        this.percentComissio=percentComissio;
        this.historicOperacions = new HashMap();  
    }

    public double getComissio() {
        return comissio;
    }

    public void setComissio(double comissio) {
        this.comissio = comissio;
    }

    public int getPercentComissio() {
        return percentComissio;
    }

    public void setPercentComissio(int percentComissio) {
        this.percentComissio = percentComissio;
    }

    public HashMap<Integer, Operacio> getHistoricOperacions() {
        return historicOperacions;
    }

    public void setHistoricOperacions(HashMap<Integer, Operacio> historicOperacions) {
        this.historicOperacions = historicOperacions;
    }

    public void afegirOperacio(Operacio operacio){
        historicOperacions.put(operacio.getIdentificador(), operacio);
    }
    
    public void eliminarOperacio(int identificador){
        historicOperacions.remove(identificador);
    }
    
    @Override
    public String toString() {
        return "Comercial{" + "comissio=" + comissio + ", percentComissio=" + percentComissio + ", historicOperacions=" + historicOperacions + '}';
    }
}
