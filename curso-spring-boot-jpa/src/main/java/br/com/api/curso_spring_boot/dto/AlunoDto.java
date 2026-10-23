package br.com.api.curso_spring_boot.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoDto(
        @NotBlank String nome,
        @NotBlank String email
) {
}
