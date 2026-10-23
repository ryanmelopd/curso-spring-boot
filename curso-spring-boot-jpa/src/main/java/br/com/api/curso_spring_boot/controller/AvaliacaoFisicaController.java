package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.dto.AvaliacaoFisicaDto;
import br.com.api.curso_spring_boot.exception.BadRequestException;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import br.com.api.curso_spring_boot.service.AvaliacaoFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
