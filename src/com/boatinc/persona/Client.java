/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona;

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
        formesPagament = new HashMap();
    }

    public void afegirFormaPagament(TipusPagament metodePagament){
        formesPagament.put(metodePagament.getIdentificador(), metodePagament);
    }
    
    public void eliminarFormaPagament(int identificador){
        formesPagament.remove(identificador);
    }
    
    
    @Override
    public String toString() {
        return "Client{" + "formesPagament=" + formesPagament + '}';
    }

}
