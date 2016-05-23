package com.boatinc.eines;

import com.boatinc.embarcacio.Informacio;
import com.boatinc.exceptions.DataException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Joanmi
 */
public class Eina {
    public static Date creaDate(String fechaString) throws DataException{
        int any,mes,dia;
        Date fecha;
        
        if(fechaString.length()!=10){
            throw new DataException("La data no es correcte, el format ha de ser dd/MM/aaaa");
        }else{
            dia=Integer.parseInt(fechaString.substring(0,2));
            mes=Integer.parseInt(fechaString.substring(3,5));
            any=Integer.parseInt(fechaString.substring(6,10));
            
            if(dia>31 || mes>12 || any<1500){
                throw new DataException("La data inserida no es vàlida.");
            }
            
            GregorianCalendar dataGregorian = new GregorianCalendar(any,mes-1,dia);
            fecha = dataGregorian.getTime();
            
            return fecha;
        }
    }
    
    public static void mostraJSON(Informacio embarcacio, boolean detallada){
        if(detallada){
            System.out.println(embarcacio.infoDetallada());
        }else{
            System.out.println(embarcacio.infoGeneral());
        }
    }
}
    
    

