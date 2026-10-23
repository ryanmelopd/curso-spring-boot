package br.com.api.curso_spring_boot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AvaliacaoFisicaDto(
        @NotBlank Integer alunoId,
        @NotBlank BigDecimal peso,
        @NotBlank BigDecimal altura,
        @NotBlank BigDecimal porcentagemGorduraCorporal
) {
}
