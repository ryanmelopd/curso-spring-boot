package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.database.model.ExerciciosEntity;
import br.com.api.curso_spring_boot.dto.ExerciciosDto;
import br.com.api.curso_spring_boot.service.ExerciciosService;
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

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll() {
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExerciciosDto exerciciosDto) {
        exerciciosService.save(exerciciosDto);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular) {
        return exerciciosService.getExerciciosByGrupoMuscular(grupoMuscular);
    }
}
