package br.com.api.curso_spring_boot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExerciciosDto {

    @NotBlank //NÃO PODE SER NULA NEM VAZIA
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
