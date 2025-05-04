package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.ProdutoService;
import dev.marlone.notasfiscais.request.ProdutoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
@Tag(name = "Produto", description = "API de gerenciamento de produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    //Listar
    @GetMapping
    @Operation(summary = "Listar produtos", description = "Retorna todos os produtos cadastrados")
    public ResponseEntity<?> listar() {
        return produtoService.listar();
    }

    //Criar
    @PostMapping
    @Operation(summary = "Cria produtos", description = "Cria novos produtos")
    public ResponseEntity<?> salvar(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criar(produtoRequest);
    }

    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um produto", description = "endpoint para deletar um produto com base no ID")
    public ResponseEntity<?> deletar(@PathVariable String id){
        return produtoService.deleteById(id);
    }

    //Put
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto", description = "enpoint para atualizar um produto com base no ID")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody ProdutoRequest produtoRequest){
        return produtoService.put(id,produtoRequest);
    }
}
