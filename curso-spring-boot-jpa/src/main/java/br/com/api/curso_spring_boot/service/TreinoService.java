package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.AlunoEntity;
import br.com.api.curso_spring_boot.database.model.ExercicioEntity;
import br.com.api.curso_spring_boot.database.model.TreinoEntity;
import br.com.api.curso_spring_boot.database.repository.AlunoRepository;
import br.com.api.curso_spring_boot.database.repository.ExercicioRepository;
import br.com.api.curso_spring_boot.database.repository.TreinoRepository;
import br.com.api.curso_spring_boot.dto.TreinoDto;
import br.com.api.curso_spring_boot.exception.BadRequestException;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final AlunoRepository alunoRepository;
    private final ExercicioRepository exercicioRepository;
    private final TreinoRepository treinoRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        Set<ExercicioEntity> exercicios = new HashSet<>();

        AlunoEntity aluno = alunoRepository.findById(treinoDto.alunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        TreinoEntity treino = treinoRepository.findByNomeAndAlunoId(treinoDto.nome(), treinoDto.alunoId())
                .orElse(null);

        if (treino != null){
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno");
        }

        for (Integer exercicioId : treinoDto.exercicioId()) {
            ExercicioEntity exercicio = exercicioRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercício %s não encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinoEntity.builder()
                .nome(treinoDto.nome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinoRepository.save(treino);
    }
}
