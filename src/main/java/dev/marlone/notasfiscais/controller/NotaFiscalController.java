package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.NotaFiscalService;
import dev.marlone.notasfiscais.request.NotaFiscalRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/notafiscal")
@AllArgsConstructor
@Tag(name = "Nota", description = "Gerenciamento de Notas")
public class NotaFiscalController {

    private NotaFiscalService notaFiscalService;

    @GetMapping
    @Operation(summary = "Listar Notas", description = "Retorna todas as notas cadastradas")
    public ResponseEntity<?> listar(){
        return notaFiscalService.listar();
    }

    @PostMapping
    @Operation(summary = "Cria as Notas", description = "Cria novas notas")
    public ResponseEntity<?> criar(@RequestBody NotaFiscalRequest request){
        return notaFiscalService.criar(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta notas", description = "Deleta as notas")
    public ResponseEntity<?> deletar(@PathVariable String id){
        return notaFiscalService.excluirNota(id);
    }
}
