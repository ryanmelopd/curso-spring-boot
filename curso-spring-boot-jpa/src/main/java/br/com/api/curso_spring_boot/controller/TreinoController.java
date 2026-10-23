package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.dto.TreinoDto;
import br.com.api.curso_spring_boot.exception.BadRequestException;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import br.com.api.curso_spring_boot.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDto);
    }

}