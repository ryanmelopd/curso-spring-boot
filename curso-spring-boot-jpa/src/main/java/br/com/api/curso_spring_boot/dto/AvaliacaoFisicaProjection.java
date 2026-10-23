package br.com.api.curso_spring_boot.dto;

import java.math.BigDecimal;

public interface AvaliacaoFisicaProjection {

    Integer getIdAluno();
    String getNomeAluno();
    Integer getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGorduraCorporal();

}
