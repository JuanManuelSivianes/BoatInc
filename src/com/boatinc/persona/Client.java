/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.pagament.TipusPagament;
import java.util.HashMap;

/**
 *
 * @author Joanmi
 */
public class Client extends Persona{
    private HashMap<Integer,TipusPagament> formesPagament;
    
    public Client (String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email){
        super(nom,cognom,document,numeroDocument,adreça,telefon,email);
        formesPagament = new HashMap<>();
    }

    public HashMap<Integer, TipusPagament> getFormesPagament() {
        return formesPagament;
    }

    public void afegirFormaPagament(TipusPagament metodePagament) throws NoAfegitException{
        if(formesPagament.containsKey(metodePagament.getIdentificador())){
            throw new NoAfegitException("El client "+this.getNom()+" ja te aquest mètode de pagament");
        }else{
            formesPagament.put(metodePagament.getIdentificador(), metodePagament);
        }
    }
    
    public void eliminarFormaPagament(int identificador) throws NoEliminatException{
        if(formesPagament.containsKey(identificador)){
            formesPagament.remove(identificador); 
        }else{
            throw new NoEliminatException("L'identificador passat no coincideix amb cap mètode de pagament.");
        }
    }
     
    @Override
    public String toString() {
        return "Client{" +super.toString()+ "formesPagament=" + formesPagament + '}';
    }
}