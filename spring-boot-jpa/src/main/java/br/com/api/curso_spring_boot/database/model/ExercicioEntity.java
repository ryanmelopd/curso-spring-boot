package br.com.api.curso_spring_boot.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExercicioEntity {

    @Id // CHAVE PRIMÁRIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA AUTOMATICAMENTE ID NOVO
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;
}