package br.com.api.curso_spring_boot.service;

import br.com.api.curso_spring_boot.database.model.ProdutoModel;
import br.com.api.curso_spring_boot.dto.ProdutoDto;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.FileSystemNotFoundException;
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

    public List<ProdutoModel> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoModel createProduct(ProdutoDto produtoDto) {

        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoModel::getId)
                .max()
                .orElse(0) + 1;

        ProdutoModel newProduct = ProdutoModel.builder()
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .quantidade(produtoDto.getQuantidade())
                .build();

        PRODUTOS.add(newProduct);
        return newProduct;
    }

    public ProdutoModel updateProduct(ProdutoDto produtoDto, Integer id) throws NotFoundException {
        ProdutoModel produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    public void deleteProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }
}