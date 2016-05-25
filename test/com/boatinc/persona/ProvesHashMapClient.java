package com.boatinc.persona;

import com.boatinc.empresa.Empresa;
import com.boatinc.exceptions.NoAfegitException;
import com.boatinc.exceptions.NoEliminatException;
import com.boatinc.persona.pagament.TargetaCredit;
import com.boatinc.persona.pagament.TipusPagament;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Joanmi
 */
public class ProvesHashMapClient {
    HashMap<Integer,TipusPagament> formesPagament;
    Empresa empresa;
    Client client;
    TargetaCredit targeta1;
    TargetaCredit targeta2;

    @Before
    public void inicia() throws NoAfegitException {
        this.empresa= new Empresa("prova", "234234234a", "adreça", 234234234);
        this.client = new Client(empresa, "Toni", "Pons Van", Document.DNI, "11111111E", "C/ mar nº2, Alcudia", 600252421, "toni@gmail.com");
        this.targeta1 = new TargetaCredit(3333444455556666L, 10, 14, 223);
        this.targeta2 = new TargetaCredit(1111222288887777L, 8, 15, 740);
        this.formesPagament= new HashMap<>();
        System.out.println("HOLA");
    }
    
    

    @Test
    public void testAfegirRecuperarFormaPagament() throws NoAfegitException {
        System.out.println("Test Afegir, comprovar que hi és i recuperar una forma de pagament.");
        
        client.afegirFormaPagament(targeta1);
        assertTrue(client.getFormesPagament().containsKey(targeta1.getIdentificador()));
        assertTrue(client.getFormesPagament().containsValue(targeta1));
        assertEquals(targeta1, client.getFormesPagament().get(targeta1.getIdentificador()));
    }
    
    
    
    @Test
    public void testEliminarFormaPagament() throws NoEliminatException, NoAfegitException {
        System.out.println("Test eliminar una forma de pagament.");

        client.afegirFormaPagament(targeta1);
        client.afegirFormaPagament(targeta2);
        
        client.eliminarFormaPagament(targeta1.getIdentificador());
        
        assertFalse(client.getFormesPagament().containsKey(targeta1.getIdentificador()));
        assertFalse(client.getFormesPagament().containsValue(targeta1));
    }
    
    
    
    
    @Test(expected=NoAfegitException.class)
    public void testAfegirFormaPagamentException() throws NoAfegitException {
        System.out.println("Test afegir forma de pagament que ja esta inserida.");
        
        client.afegirFormaPagament(targeta1);
        client.afegirFormaPagament(targeta2);
        client.afegirFormaPagament(targeta1);
    }    
    
    
    
    
    @Test(expected=NoEliminatException.class)
    public void testEliminarFormaPagamentException() throws NoEliminatException, NoAfegitException {
        System.out.println("Test eliminar una forma de pagament que no té inserida el client.");
        
        client.afegirFormaPagament(targeta1);
        client.eliminarFormaPagament(targeta2.getIdentificador());
    }    
}