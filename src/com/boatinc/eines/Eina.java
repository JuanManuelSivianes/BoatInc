package com.boatinc.eines;

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
            throw new DataException("El format de la data no es correcte!");
        }else{
            dia=Integer.parseInt(fechaString.substring(0,2));
            mes=Integer.parseInt(fechaString.substring(3,5));
            any=Integer.parseInt(fechaString.substring(6,10));
            
            if(dia>31 || mes>12 || any<1500){
                throw new DataException("numero incongruents");
            }
            
            GregorianCalendar dataGregorian = new GregorianCalendar(any,mes-1,dia);
            fecha = dataGregorian.getTime();
            
            return fecha;
        }
    }
}
    
    

