package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
