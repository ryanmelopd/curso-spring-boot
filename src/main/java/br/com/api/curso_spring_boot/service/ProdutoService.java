package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoModel.builder()
                .id(1)
                .nome("Notebook")
                .preco(new BigDecimal("5000"))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(2)
                .nome("Iphone")
                .preco(new BigDecimal("7000"))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoModel.builder()
                .id(3)
                .nome("Mouse")
                .preco(new BigDecimal("500"))
                .quantidade(10)
                .build());
    }
}