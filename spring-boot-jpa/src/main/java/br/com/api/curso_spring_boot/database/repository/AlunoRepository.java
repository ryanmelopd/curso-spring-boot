package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
    Optional<AlunoEntity> findByEmail(String email);

    @Query(value = "SELECT a FROM AlunoEntity a JOIN FETCH a.avaliacaoFisica")
    Optional<AlunoEntity> findByIdFetch(Integer alunoId);
}
