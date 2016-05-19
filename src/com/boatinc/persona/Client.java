/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.pagament.TipusPagament;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Joanmi
 */
public class Client extends Persona{
    private HashSet<TipusPagament> formesPagament;
    
    public Client (String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email){
        super(nom,cognom,document,numeroDocument,adreça,telefon,email);
        formesPagament = new HashSet<>();
    }

    public HashSet<TipusPagament> getFormesPagament() {
        return formesPagament;
    }


    public void afegirFormaPagament(TipusPagament metodePagament) throws NoAfegitException{
        if(formesPagament.add(metodePagament)==false){
            throw new NoAfegitException("El client ja te aquest metode de pagament.");
        }
    }
    
    public void eliminarFormaPagament(int identificador) throws NoEliminatException{
        boolean correcte=false;
        Iterator<TipusPagament> i = formesPagament.iterator();
        while(i.hasNext()){
            if(i.next().getIdentificador()==identificador){
                i.remove();
                correcte=true;
            }
        }
        if(correcte!=true){
            throw new NoEliminatException("L'identificador passat no coincideix amb cap mètode de pagament.");
        }
    }
    
    
    @Override
    public String toString() {
        return "Client{" +super.toString()+ "formesPagament=" + formesPagament + '}';
    }

}
