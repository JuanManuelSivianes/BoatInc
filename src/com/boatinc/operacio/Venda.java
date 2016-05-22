/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.embarcacio.Proposit;
import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.persona.Client;
import com.boatinc.persona.empleat.Comercial;
import java.util.Date;

/**
 *
 * @author Arsenik
 */
public class Venda extends Operacio {

    private Comercial comercial;
    private Date dataVenta;

    public Venda(Empresa empresa, Client client, Embarcacio embarcacio, Estat estat, Comercial comercial, String dataVenta, float preu) throws DataException, NoAfegitException {
        super(client, embarcacio, estat, preu);
        this.dataVenta = Eina.creaDate(dataVenta);
        this.comercial = comercial;
        if (embarcacio.getProposit() != Proposit.VENTA || embarcacio.isDisponibilitat() == false) {
            throw new NoAfegitException("Aquest vaixell no esta disponible per venta.");
        }
        embarcacio.setDisponibilitat(false);
        empresa.afegirOperacions(this);
    }

    public Comercial getComercial() {
        return comercial;
    }

    public void setComercial(Comercial comercial) {
        this.comercial = comercial;
    }

    public Date getDataVenta() {
        return dataVenta;
    }

    public void setDataVenta(Date dataVenta) {
        this.dataVenta = dataVenta;
    }

    @Override
    public String toString() {
        return "ID Operacio: "+getIdentificador()+", Comercial: "+ comercial.getNom()+" "+comercial.getCognom() + ", Data de venda: " + dataVenta+".";
    }

}
