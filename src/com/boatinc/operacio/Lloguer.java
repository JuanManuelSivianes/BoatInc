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
    private Patro patro;
    private float preuTotal;

    public Lloguer(Empresa empresa, Client client, Embarcacio embarcacio, Estat estat, String dataInicial, String dataFinal, float preu) throws DataException, NoAfegitException {
        super(client, embarcacio, estat, preu);
        this.dataInicial = Eina.creaDate(dataInicial);
        this.dataFinal = Eina.creaDate(dataFinal);
        if (embarcacio.getProposit() != Proposit.LLOGUER ) {
            throw new NoAfegitException("Aquest vaixell no esta disponible per lloguer.");
        }else{
            if(embarcacio.isDisponibilitat()==false){
                throw new NoAfegitException("Aquest vaixell no esta disponible per lloguer.");
            }
        }
        if (this.dataInicial.after(this.dataFinal)) {
            throw new DataException("La data d'inici d'un lloguer no pot ser posterior a la data final.");
        }

        this.preuTotal = embarcacio.getPreu();
        empresa.afegirOperacions(this);
    }

    public Lloguer(Empresa empresa, Client client, Embarcacio embarcacio, Estat estat, String dataInicial, String dataFinal, Patro patro, float preu) throws DataException, NoAfegitException {
        this(empresa, client, embarcacio, estat, dataInicial, dataFinal, preu);
        this.patro = patro;
        this.preuTotal =this.getPreu()+ patro.getCost();
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) throws DataException {
        this.dataInicial = Eina.creaDate(dataInicial);
        if (this.dataInicial.after(this.dataFinal)) {
            throw new DataException("La data d'inici d'un lloguer no pot ser posterior a la data final.");
        }
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) throws DataException {
        this.dataFinal = Eina.creaDate(dataFinal);
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
        return super.toString() + "Lloguer{" + "dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", patro=" + patro + ", preuTotal=" + preuTotal + '}';
    }

}
