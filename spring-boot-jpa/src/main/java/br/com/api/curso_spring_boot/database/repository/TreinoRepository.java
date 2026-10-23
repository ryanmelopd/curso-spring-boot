package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.TreinoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface TreinoRepository extends JpaRepository<TreinoEntity, Integer> {
    Optional<TreinoEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
