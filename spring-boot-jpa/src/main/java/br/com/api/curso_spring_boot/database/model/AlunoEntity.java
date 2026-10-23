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
public class AlunoEntity {

    @Id // CHAVE PRIMÁRIA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA AUTOMATICAMENTE ID NOVO
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacaoFisicaEntity avaliacoesFisica;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<TreinoEntity> treinos = new HashSet<>();
}