package br.com.api.curso_spring_boot.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDto {
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
