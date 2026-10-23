package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.database.model.AvaliacaoFisicaEntity;
import br.com.api.curso_spring_boot.dto.AlunoDto;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import br.com.api.curso_spring_boot.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) {
        alunoService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    public AvaliacaoFisicaEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.getAlunoAvaliacao(alunoId);
    }
}
