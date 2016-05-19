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
import com.boatinc.persona.empleat.Comercial;
import java.util.Date;

/**
 *
 * @author Arsenik
 */
public class Venda extends Operacio{
    private Comercial comercial;
    private Date dataVenta;
    private float preu;

    public Venda(Client client, Embarcacio embarcacio, Estat estat, Comercial comercial, String dataVenta, float preu) throws DataException {
        super(client, embarcacio, estat);
        this.dataVenta = Eina.creaDate(dataVenta);
        this.comercial=comercial;
        this.preu=preu;
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

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }
    
    
    
}