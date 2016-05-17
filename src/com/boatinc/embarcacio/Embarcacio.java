/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boatinc.embarcacio;

/**
 *
 * @author Arsenik
 */
public class Embarcacio {
    private int numeroSerie;
    private String matricula;
    private String marca;
    private String model;
    private int manga;
    private int eslora;
    private int calat;
    private String tipusEmbarcacio;
    private Proposit proposit;
    private float preuVenda;
    private HashMap<Integer,Reparacio> historicReparacions;
}
