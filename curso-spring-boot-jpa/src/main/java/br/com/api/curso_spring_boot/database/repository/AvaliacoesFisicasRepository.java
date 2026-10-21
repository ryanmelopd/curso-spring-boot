package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {
}
