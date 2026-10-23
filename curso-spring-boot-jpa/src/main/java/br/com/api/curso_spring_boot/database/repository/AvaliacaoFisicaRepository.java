package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.AvaliacaoFisicaEntity;
import br.com.api.curso_spring_boot.dto.AvaliacaoFisicaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisicaEntity, Integer> {

    @NativeQuery(value = """
        SELECT a.id                             idAluno,
               a.nome                           nomeAluno,
               af.id                            idAvaliacao, 
               af.peso                          peso,
               af.altura                        altura,
               af.percentual_gordura_corporal   percentualGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
        """)
    List<AvaliacaoFisicaProjection> getAllAvaliacoes();

    @NativeQuery(value = """
        SELECT a.id                             idAluno,
               a.nome                           nomeAluno,
               af.id                            idAvaliacao, 
               af.peso                          peso,
               af.altura                        altura,
               af.percentual_gordura_corporal   percentualGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
        """,
            countQuery = """
        SELECT count(af.id)
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
        """)
    Page<AvaliacaoFisicaProjection> getAllAvaliacoesPageable(Pageable pageable);
}
