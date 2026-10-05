package br.com.api.curso_spring_boot.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoModel {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}