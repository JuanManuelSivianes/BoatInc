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
import com.boatinc.persona.Patro;
import java.util.Date;

/**
 *
 * @author Arsenik
 */
public class Lloguer extends Operacio {
    private Date dataInicial;
    private Date dataFinal;
    private float preu;
    private Patro patro;
    private float preuTotal;

    public Lloguer(Empresa empresa, Client client, Embarcacio embarcacio, Estat estat, String dataInicial, String dataFinal) throws DataException, NoAfegitException {
        super(client, embarcacio, estat);
        this.dataInicial = Eina.creaDate(dataInicial);
        this.dataFinal = Eina.creaDate(dataFinal);
        if(super.getEmbarcacio().getProposit()!=Proposit.LLOGUER || super.getEmbarcacio().isDisponibilitat()==false){
            throw new NoAfegitException("Aquest vaixell no esta disponible per lloguer.");
        }
        empresa.afegirOperacions(this);
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public Patro getPatro() {
        return patro;
    }

    public void setPatro(Patro patro) {
        this.patro = patro;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(float preuTotal) {
        this.preuTotal = preuTotal;
    }

    @Override
    public String toString() {
        return "Lloguer{" + "dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", preu=" + preu + ", patro=" + patro + ", preuTotal=" + preuTotal + '}';
    }
    
}
