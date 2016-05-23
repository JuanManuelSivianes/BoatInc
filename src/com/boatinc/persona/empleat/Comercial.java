/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.persona.empleat;

import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.DataException;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.operacio.Venda;
import com.boatinc.persona.Document;
import java.util.HashMap;

/**
 *
 * @author Joanmi
 */
public class Comercial extends Empleat{
    private double comissio;
    private int percentComissio;
    private HashMap<Integer, Venda> historicOperacions;
    
    public Comercial (Empresa empresa, String nom, String cognom, Document document, String numeroDocument, String adreça, int telefon, String email, float sou, String dataContracte, int percentComissio) throws DataException, NoAfegitException{
        super(empresa,nom,cognom,document,numeroDocument,adreça,telefon,email,sou,dataContracte);
        this.comissio=0;
        this.percentComissio=percentComissio;
        this.historicOperacions = new HashMap<>();  
    }

    public double getComissio() {
        return comissio;
    }

    public void setComissio(double comissio) {
        this.comissio = comissio;
    }
    
    public void sumaComissio(double comissioAfegida){
        setComissio(this.comissio+(comissioAfegida*this.percentComissio/100));
    }
    
    public void restaComissio(double restaComisio){
        setComissio(this.comissio-(restaComisio*this.percentComissio/100));
    }

    public int getPercentComissio() {
        return percentComissio;
    }

    public void setPercentComissio(int percentComissio) {
        this.percentComissio = percentComissio;
    }

    public HashMap<Integer, Venda> getHistoricOperacions() {
        return historicOperacions;
    }

    public void afegirOperacio(Venda operacioVenda) throws NoAfegitException{
        if(historicOperacions.containsKey(operacioVenda.getIdentificador())){
            throw new NoAfegitException("Aquesta operació de Venda ja esta inserida al comercial "+this.getNom());
        }
        historicOperacions.put(operacioVenda.getIdentificador(), operacioVenda);
        sumaComissio(operacioVenda.getPreu());
    }
    
    public void eliminarOperacio(int identificador) throws NoEliminatException{
        if(historicOperacions.containsKey(identificador)){
            this.restaComissio(historicOperacions.get(identificador).getPreu());
            historicOperacions.remove(identificador); 
        }else{
            throw new NoEliminatException("El comercial "+this.getNom()+", no té aquesta operació al seu històric de vendes.");
        }
    }
    
    @Override
    public String tornaNomina(){
        return super.tornaNomina().substring(0, super.tornaNomina().length()-1)+", \"Percent Comissió\": "+percentComissio+", \"Comissió\": "+comissio+"}";
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
