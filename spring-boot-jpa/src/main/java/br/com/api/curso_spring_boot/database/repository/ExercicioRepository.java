package br.com.api.curso_spring_boot.database.repository;

import br.com.api.curso_spring_boot.database.model.ExercicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Integer> {

    List<ExercicioEntity> findAllByGrupoMuscular(String grupoMuscular); // Query Method
}
