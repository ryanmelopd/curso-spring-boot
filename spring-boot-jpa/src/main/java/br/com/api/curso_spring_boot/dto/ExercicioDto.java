package br.com.api.curso_spring_boot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ExercicioDto(
        @NotBlank String nome,
        @NotBlank String grupoMuscular
) {
}