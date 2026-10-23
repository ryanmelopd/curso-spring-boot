package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.database.model.ExercicioEntity;
import br.com.api.curso_spring_boot.dto.ExercicioDto;
import br.com.api.curso_spring_boot.service.ExercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    public List<ExercicioEntity> findAll() {
        return exercicioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExercicioDto exercicioDto) {
        exercicioService.save(exercicioDto);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    public List<ExercicioEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular) {
        return exercicioService.getExerciciosByGrupoMuscular(grupoMuscular);
    }
}
