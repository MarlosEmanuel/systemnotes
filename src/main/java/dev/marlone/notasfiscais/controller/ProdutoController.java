package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.ProdutoService;
import dev.marlone.notasfiscais.request.ProdutoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@Tag(name = "Produto", description = "API de gerenciamento de produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar produtos", description = "Retorna todos os produtos cadastrados")
    public ResponseEntity<?> listar() {
        return produtoService.listar();
    }

    @PostMapping
    @Operation(summary = "Cria produtos", description = "Cria novos produtos")
    public ResponseEntity<?> salvar(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criar(produtoRequest);
    }

}
