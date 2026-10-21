package br.com.api.curso_spring_boot.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TreinosEntity {

    @Id // CHAVE PRIMÁRIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA AUTOMATICAMENTE ID NOVO
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    // DIVERSOS TREINOS COM DIVERSOS EXERCÍCIOS
   @ManyToMany
   @JoinTable(
            name = "treinos_exercicios",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
   )
    private Set<ExerciciosEntity> exercicios = new HashSet<>();
}