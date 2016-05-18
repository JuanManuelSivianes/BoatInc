/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.operacio;

import com.boatinc.eines.Eina;
import com.boatinc.embarcacio.Embarcacio;
import com.boatinc.exceptions.DataException;
import com.boatinc.persona.Client;
import com.boatinc.persona.Patro;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arsenik
 */
public class Lloguer extends Operacio {
    private Date dataInicial;
    private Date dataFinal;
    private float preu;
    private Patro patro;
    private boolean disponibilitat;
    private float preuTotal;

    public Lloguer(Client client, Embarcacio embarcacio, Estat estat, String dataInicial, String dataFinal) {
        super(client, embarcacio, estat);
        try {
            this.dataInicial = Eina.creaDate(dataInicial);
        } catch (DataException ex) {
            Logger.getLogger(Reparacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.dataFinal = Eina.creaDate(dataFinal);
        } catch (DataException ex) {
            Logger.getLogger(Reparacio.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(float preuTotal) {
        this.preuTotal = preuTotal;
    }
}
