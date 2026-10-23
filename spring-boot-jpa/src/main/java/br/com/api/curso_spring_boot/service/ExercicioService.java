package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.ExercicioEntity;
import br.com.api.curso_spring_boot.database.repository.ExercicioRepository;
import br.com.api.curso_spring_boot.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public List<ExercicioEntity> findAll() {
        return exercicioRepository.findAll();
    }

    public void save(ExercicioDto exercicioDto) {
        exercicioRepository.save(ExercicioEntity.builder()
                        .nome(exercicioDto.nome())
                        .grupoMuscular(exercicioDto.grupoMuscular())
                .build());
    }

    public List<ExercicioEntity> getExerciciosByGrupoMuscular(String grupoMuscular) {
        return exercicioRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
