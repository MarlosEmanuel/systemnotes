package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.ProdutoService;
import dev.marlone.notasfiscais.request.ProdutoRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return produtoService.listar();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criar(produtoRequest);
    }

}
