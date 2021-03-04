/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author AUGUSTO
 */
@Data
@Builder
public class Columns {
    private String nomeAluno;
    private Date dataNasc;
    private BigDecimal matriculaAluno;
    private BigDecimal cpfMae;
    private BigDecimal cpfAluno;
    private String nomeMae;
    private String turma;
    private BigDecimal turmaInteiro;
}
