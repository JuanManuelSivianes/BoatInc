/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.pagament;

/**
 *
 * @author Joanmi
 */
public class CompteCorrent extends TipusPagament{
    private String iban;
    
    public CompteCorrent(String iban){
        super();
        this.iban=iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "CompteCorrent{" +"Identificador: "+this.getIdentificador()+ ", iban=" + iban + '}';
    } 
}
