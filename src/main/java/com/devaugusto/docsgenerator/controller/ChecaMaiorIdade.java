/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto
 */
public class ChecaMaiorIdade implements ChecaIdade{
    SimpleDateFormat sdf;
    Date dataAtual;
    
    @Override
    public boolean checaIdade(Date dataNasc) {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataAtual = sdf.parse("13/03/2021");
            int ano = dataAtual.getYear() - dataNasc.getYear();
            if(ano > 18)
                 return true;
            else if(ano == 18 && dataAtual.getMonth() > dataNasc.getMonth())
                 return true;
            else if(ano == 18 && 
                 dataAtual.getMonth() == dataNasc.getMonth()
                 && dataAtual.getDate()>= dataNasc.getDate())
                 return true;
            else
                return false;
            
        } catch (ParseException ex) {
            Logger.getLogger(ChecaMaiorIdade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
