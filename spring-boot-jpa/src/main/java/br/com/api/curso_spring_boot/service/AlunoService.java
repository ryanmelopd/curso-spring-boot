package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.AlunoEntity;
import br.com.api.curso_spring_boot.database.model.AvaliacaoFisicaEntity;
import br.com.api.curso_spring_boot.database.model.TreinoEntity;
import br.com.api.curso_spring_boot.database.repository.AlunoRepository;
import br.com.api.curso_spring_boot.dto.AlunoDto;
import br.com.api.curso_spring_boot.exception.BadRequestException;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public void criarAluno(AlunoDto alunoDto) {
        AlunoEntity aluno = alunoRepository.findByEmail(alunoDto.email())
                .orElse(null);

        if (aluno != null) {
            throw new BadRequestException("Aluno já cadastrado este email");
        }

        alunoRepository.save(AlunoEntity.builder()
                .nome(alunoDto.nome())
                .email(alunoDto.email())
                .build()
        );
    }

    public AvaliacaoFisicaEntity getAlunoAvaliacao(Integer alunoId) {
        AlunoEntity aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicaEntity avaliacao = aluno.getAvaliacoesFisica();
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação física não encontrada para este aluno");
        }
        return avaliacao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletarAluno(Integer alunoId) throws Exception {
        AlunoEntity aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        //1. deletar treinos do aluno
        List<Integer> treinosAlunoIds = aluno.getTreinos().stream()
                .map(TreinoEntity::getId)
                .toList();

        treinoRepository.deleteAllById(treinosAlunoIds);

        //2. deletar o aluno
        alunoRepository.deleteById(alunoId);

        //3. deletar avaliação física
        avaliacaoFisicaRepository.deleteById(aluno.getAvaliacaoFisica().getId());
    }

}