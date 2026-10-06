package br.com.api.curso_spring_boot.controller;

import br.com.api.curso_spring_boot.database.model.ProdutoModel;
import br.com.api.curso_spring_boot.dto.ProdutoDto;
import br.com.api.curso_spring_boot.exception.NotFoundException;
import br.com.api.curso_spring_boot.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoModel> findAll() {
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel createProduct(@RequestBody ProdutoDto produtoDto) {
        return produtoService.createProduct(produtoDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoModel updateProduct(@PathVariable Integer id,
                                       @RequestBody ProdutoDto produtoDto) throws NotFoundException {
        return produtoService.updateProduct(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        produtoService.deleteProduct(id);
    }
}
