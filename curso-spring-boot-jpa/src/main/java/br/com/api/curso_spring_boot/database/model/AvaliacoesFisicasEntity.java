package br.com.api.curso_spring_boot.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacoesFisicasEntity {

    @Id // CHAVE PRIMÁRIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA AUTOMATICAMENTE ID NOVO
    private Integer id;
    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "percentual_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;
}
