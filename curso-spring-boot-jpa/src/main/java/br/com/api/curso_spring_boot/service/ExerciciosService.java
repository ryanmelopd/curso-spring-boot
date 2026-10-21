package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.ExerciciosEntity;
import br.com.api.curso_spring_boot.database.repository.ExerciciosRepository;
import br.com.api.curso_spring_boot.dto.ExerciciosDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final ExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll() {
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDto exerciciosDto) {
        exerciciosRepository.save(ExerciciosEntity.builder()
                        .nome(exerciciosDto.getNome())
                        .grupoMuscular(exerciciosDto.getGrupoMuscular())
                .build());
    }

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular) {
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
