package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.AlunoEntity;
import br.com.api.curso_spring_boot.database.model.AvaliacaoFisicaEntity;
import br.com.api.curso_spring_boot.database.repository.AlunoRepository;
import br.com.api.curso_spring_boot.database.repository.AvaliacaoFisicaRepository;
import br.com.api.curso_spring_boot.dto.AvaliacaoFisicaDto;
import br.com.api.curso_spring_boot.exception.BadRequestException;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AlunoRepository alunoRepository;
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunoEntity aluno = alunoRepository.findById(avaliacaoFisicaDto.alunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicaEntity avaliacaoFisicaEntity = aluno.getAvaliacoesFisica();
        if (avaliacaoFisicaEntity != null) {
            throw new BadRequestException("Avaliação física já cadastrada para este aluno");
        }

        avaliacaoFisicaEntity = AvaliacaoFisicaEntity.builder()
                .peso(avaliacaoFisicaDto.peso())
                .altura(avaliacaoFisicaDto.altura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.porcentagemGorduraCorporal())
                .build();

        avaliacaoFisicaEntity = avaliacaoFisicaRepository.save(avaliacaoFisicaEntity);

        aluno.setAvaliacoesFisica(avaliacaoFisicaEntity);
        alunoRepository.save(aluno);

    }
}
