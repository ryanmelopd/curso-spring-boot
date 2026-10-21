package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<AlunosEntity, Integer> {
}
