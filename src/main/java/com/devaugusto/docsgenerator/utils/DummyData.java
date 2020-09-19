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
    private String KIT = "5 kg de arroz, 1 kg de feijão preto, "
            + "900 ml de óleo de soja, "
            + "1 kg de sal iodado refinado, "
            + "02 unidades de 1 kg de açúcar, "
            + "1 kg de farinha de mandioca, "
            + "340 g de extrato de tomate, "
            + "03 unidades de 500 g de macarrão parafuso, "
            + "500 g de café, 400 g de leite em pó integral, "
            + "1 kg de fubá, 200g de biscoito tipo cream cracker, "
            + "350 g de biscoito tipo rosquinha, "
            + "750ml de vinagre "
            + "e 125 g de sardinha em lata";
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
