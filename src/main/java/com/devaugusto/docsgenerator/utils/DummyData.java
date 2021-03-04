/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.utils;

import java.util.logging.Logger;
import lombok.Builder;

/**
 *
 * @author AUGUSTO
 */
public class DummyData {
    private static final int val = 1;
    private String TITLE = "TERMO DE ENTREGA";
    private String KIT = "5 kg de arroz, "
            + "1 kg de feijão preto, "
            + "1 kg de açúcar refinado, "
            + "900 ml de óleo, "
            + "1 kg de farinha de mesa, "
            + "1 kg de fubá e "
            + "500 g de macarrão parafuso";
    private String LAST_TEXT = ", referente aos  Recursos  Federal e Estadual "
            + "do Programa Nacional de Alimentação Escolar (PNAE- 3ª e 4ª cotas) "
            + "e (Descentralizado- 3ª cota).";
    private String DATA = "Guapimirim, ____ de agosto de 2020.";
    private String SIGNATURE = "________________________________________________";
    private String SIGNATURE_TEXT = "(Assinatura do Responsável do Aluno)";


    public String getKIT() {
        return KIT;
    }

    public String getLAST_TEXT() {
        return LAST_TEXT;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getDATA() {
        return DATA;
    }

    public String getSIGNATURE() {
        return SIGNATURE;
    }

    public String getSIGNATURE_TEXT() {
        return SIGNATURE_TEXT;
    }
    
    
    
}
